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
	private Coordinates size;

	/**
	 * Sets the boundingBox of the elements.
	 * @param position
	 * @param size
	 */
	public BoundingBox(Coordinates position, Coordinates size)
	{
		super();
		this.position = position;
		this.size = size;
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
