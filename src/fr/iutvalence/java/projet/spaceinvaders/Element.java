/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;


// FIXME (SEEN) finish writing comment
/**
 * The element Class is the basic class of all elements on the grid.<br/>
 * It defines all stuff needed for position and collision.
 * @author Guyon Gallet
 */
public abstract class Element
{
	// FIXME (SEEN) write a comment
	/**
	 * It sets the area on the grid which use to check collision.<br/>
	 * Any element on the grid have one (and they are all different).  
	 */
	private BoundingBox area;

	// FIXME (SEEN)  write a comment
	/**
	 * This constructors sets the base of all elements on the grid.<br/>
	 * It defines the BoundingBox of the element.
	 * @param area The BoundingBox of the element you want create.
	 */
	public Element(BoundingBox area)
	{
		super();
		this.area = area;
	}

	// FIXME fix comment (this is not compliant with method signature)
	/**
	 * This method returns the location and size of the movable object.
	 * 
	 * @return return the location and size (both Coordinates) of the movable object <br/>
	 */
	public BoundingBox getArea()
	{
		return area;
	}

	// FIXME fix comment (this is not compliant with method signature)
	/**
	 * This method allows to modify the location and size of the movable object.
	 * Setting position make the object moves<br/>
	 *
	 * @param Bounding box of the element
	 */
	protected void setArea(BoundingBox area)
	{
		this.area = area;
	}
	
	@Override
	public String toString()
	{
		return "Element [ position=" + this.getArea().getPosition() + ", taille=" + this.getArea().getSize() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
	
	// FIXME add a method calculating the overlapping (which is a BB) with another object
}
