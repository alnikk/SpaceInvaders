/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

// FIXME (SEEN) what about defining BB as immutable ?
/**
 * The BoundingBox class define area.<br/>
 * An area is defined by position (Coordinates) and size (Coordinates) on the grid.
 * The 0 point is bottom left, the grid is represented like this : <br/>
 * <br/>
 *	Y<br/>
 *	^<br/>
 *	|<br/>
 *	|<br/>
 *	|<br/>
 *	|	 (x1,y2)__________(x2,y2)<br/>
 *	|		|				 |<br/>
 *	|		|				 |<br/>
 *	|		|				 |<br/>
 *	|		|				 |<br/>
 *	|		|				 |<br/>
 *	|		|				 |<br/>
 *	|		|				 |<br/>
 *	|	 (x1,y1)__________(x2,y1)<br/>
 *	|<br/>
 *	|<br/>		
 *	0---------------------------------> X<br/>
 *			
 * @author Gallet Guyon
 */
public class BoundingBox
{
	// FIXME fix comment (BB is not related to element objects)
	/**
	 * The position of the Element object on the 2D grid.
	 */
	private final Coordinates position;
	
	/**
	 * The size of the movable on the grid.<br/>
	 * The size is defined by two values as a Coordinate object whose x means width and y means height.
	 */
	private final Coordinates size;

	// ********************* Constructor ************************
	// FIXME (SEEN) fix and finish writing comment (to discuss)
	/**
	 * Creates a new bounding box, whose position and size are given as parameters 
	 * @param position Set the position of the element in 2D grid
	 * @param size Can't be change once it's allocated
	 * @throws NegativeCoordinates If one of Coordinates is Negative.
	 */
	// TODO Size can't be negative because of interBound method.
	public BoundingBox(Coordinates position, Coordinates size) throws NegativeCoordinates
	{
		super();
		if(position.getX() < 0
				|| position.getY() < 0
				|| size.getX() < 0
				|| size.getY() < 0)
			throw new NegativeCoordinates();
		this.position = position;
		this.size = size;
	}

	//**************** Method ************************

	/**
	 * Method to change position of element on the 2D grid.
	 * @param newPosition (Coordinates) the new position to set 
	 * @return New BoundingBox with new coordinates.
	 * @throws NegativeCoordinates If position is negative.
	 */
	public BoundingBox moveTo(Coordinates newPosition) throws NegativeCoordinates
	{
		return new BoundingBox(newPosition, this.size);
	}
	
	/**
	 * Method to translate position of element on the 2D grid.
	 * @param delta (Coordinates) take the old coordinates and add delta to it.
	 * @return New BoundingBox with new coordinates.
	 * @throws NegativeCoordinates If position is negative.
	 */
	public BoundingBox translate(Coordinates delta) throws NegativeCoordinates
	{
		return this.moveTo(this.position.translate(delta));
	}
	
	/**
	 * Method to change position of element on the 2D grid.
	 * @param newPosition (Coordinates) the new position to set 
	 * @return New BoundingBox with new coordinates.
	 * @throws NegativeCoordinates If the size is negative.
	 */
	public BoundingBox reSize(Coordinates newSize) throws NegativeCoordinates
	{
		return new BoundingBox(this.position, newSize);
	}

	// FIXME (SEEN) add a method to compute the intersection with another BB (the result is a BB)	
	/**
	 * Check if a point is in BoundingBox area.
	 * @param C Coordinates of the point to check. 
	 * @param B BoundingBox area to check in
	 * @return Return true if the point is in the area, false otherwise.
	 */
	private boolean pointIn(Coordinates C, BoundingBox B)
	{
		int x,y,bx1,bx2,by1,by2;
		
		x = C.getX();
		y = C.getY();
		bx1 = B.position.getX();
		bx2 = B.position.getX() + B.size.getX();
		by1 = B.position.getY();
		by2 = B.position.getY() + B.size.getY();
		
		return ((x >= bx1) && (x <= bx2) && (y >= by1) && (y <= by2));
	}
	
	/**
	 * Intersection of two BoundingBox area. One of them is passed as argument and the other is the current object.
	 * @param B BoundingBox to calculate Intersection.
	 * @return Return null if there no intersection and the area (BoundingBox) of the intersection otherwise.
	 */
	public BoundingBox interBound(BoundingBox B)
	{
		int x1,x2,y1,y2,hx1,hx2,hy1,hy2;
		int posResX, posResY, sizeResX, sizeResY;
		
		hx1 = this.position.getX();
		hx2 = this.position.getX() + this.size.getX();
		hy1 = this.position.getY();
		hy2 = this.position.getY() + this.size.getY();
		
		x1 = B.position.getX();
		x2 = B.position.getX() + B.size.getX();
		y1 = B.position.getY();
		y2 = B.position.getY() + B.size.getY();
		
		if(pointIn(new Coordinates(hx1,hy1),B) 
				|| pointIn(new Coordinates(hx2,hy1),B)
				|| pointIn(new Coordinates(hx2,hy2),B)
				|| pointIn(new Coordinates(hx1,hy2),B))
		{
			if(x1 <= hx1)
				posResX = hx1;
			else
				posResX = x1;
			if(x2 >= hx2)
				sizeResX = hx2;
			else
				sizeResX = x2;
			if(y1 <= hy1)
				posResY = hy1;
			else
				posResY = y2;
			if(y2 >= hy2)
				sizeResY = hy2;
			else
				sizeResY = y2;
			
			try
			{
				return new BoundingBox(new Coordinates(posResX, posResY), new Coordinates(sizeResX, sizeResY)) ;
			}
			catch (NegativeCoordinates e)
			{
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Intersection of two BoundingBox area passed in arguments.
	 * @param A The first BoundingBox
	 * @param B The Second BoundingBox
	 * @return Return null if there no intersection and the area (BoundingBox) of the intersection otherwise.
	 */
	public BoundingBox interBound(BoundingBox A, BoundingBox B)
	{
		int x1,x2,y1,y2,hx1,hx2,hy1,hy2;
		int posResX, posResY, sizeResX, sizeResY;
		
		hx1 = A.position.getX();
		hx2 = A.position.getX() + A.size.getX();
		hy1 = A.position.getY();
		hy2 = A.position.getY() + A.size.getY();
		
		x1 = B.position.getX();
		x2 = B.position.getX() + B.size.getX();
		y1 = B.position.getY();
		y2 = B.position.getY() + B.size.getY();
		
		if(pointIn(new Coordinates(hx1,hy1),B) 
				|| pointIn(new Coordinates(hx2,hy1),B)
				|| pointIn(new Coordinates(hx2,hy2),B)
				|| pointIn(new Coordinates(hx1,hy2),B))
		{
			if(x1 <= hx1)
				posResX = hx1;
			else
				posResX = x1;
			if(x2 >= hx2)
				sizeResX = hx2;
			else
				sizeResX = x2;
			if(y1 <= hy1)
				posResY = hy1;
			else
				posResY = y2;
			if(y2 >= hy2)
				sizeResY = hy2;
			else
				sizeResY = y2;
			
			try
			{
				return new BoundingBox(new Coordinates(posResX, posResY), new Coordinates(sizeResX, sizeResY)) ;
			}
			catch (NegativeCoordinates e)
			{
				e.printStackTrace();
				return null;
			}
		}
		else
		{
			return null;
		}
	}

	//***************** Getters and Setters ************************
	
	/**
	 * Return the size of the element by the couple (width,height).
	 * @return the size of the element by the couple (width,height).
	 */
	public Coordinates getSize()
	{
		return this.size;
	}
	
	/**
	 * Getter to return position of the element on 2D grid.
	 * @return the position of the element.
	 */
	public Coordinates getPosition()
	{
		return this.position;
	}
	
	@Override
	public String toString()
	{
		return "BoundingBox [position=" + this.position + ", size=" + this.size + "]";
	}
}
