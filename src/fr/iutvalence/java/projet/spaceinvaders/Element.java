/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;


// FIXME finish writing comment
/**
 * @author Guyon Gallet
 *
 */
public abstract class Element
{
	// FIXME write a comment
	private BoundingBox area;

	// FIXME write a comment
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
