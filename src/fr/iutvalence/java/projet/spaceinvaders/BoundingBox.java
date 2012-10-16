/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author Gallet Guyon
 *
 */
public class BoundingBox
{
	/**
	 * The position of the movable object on the 2D grid
	 */
	private Coordinates position;
	
	/**
	 * The size of the movable on the grid.<br/>
	 * The size is defined by two values as a Coordinate object whose x means width and y means height.
	 */
	private final Coordinates size;

	/**
	 * Sets the boundingBox of the elements.
	 * @param position
	 * @param size Can't be change once it's allocated
	 */
	public BoundingBox(Coordinates position, Coordinates size)
	{
		super();
		this.position = position;
		this.size = size;
	}
	
	/**
	 * Sets the boundingBox of the elements.
	 * @param positionX
	 * @param positionY
	 * @param sizeX Can't be change once it's allocated
	 * @param sizeY
	 */
	public BoundingBox(int positionX, int positionY, int sizeX, int sizeY)
	{
		super();
		this.position = new Coordinates(positionX,positionY);
		this.size = new Coordinates(sizeX,sizeY);
	}

	/**
	 * @return the position
	 */
	public Coordinates getPosition()
	{
		return this.position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(Coordinates position)
	{
		this.position = position;
	}

	/**
	 * @return the size
	 */
	public Coordinates getSize()
	{
		return this.size;
	}
}
