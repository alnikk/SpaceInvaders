/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * The element Class is the basic class of all elements on the grid.<br/>
 * It defines all stuff needed for position and collision.
 * 
 * @author Guyon Gallet
 */
public abstract class Element
{
	/**
	 * area of the grid filled by the element
	 */
	// FIXME (SEEN) why not rename it "boundingBox"
	// Because it makes lot of rehearse
	private BoundingBox boundingBox;

	// ************* Constructor ***************
	/**
	 * This constructor sets the area of the grid filled by the element .<br/>
	 * It defines the BoundingBox of the element.
	 * 
	 * @param area
	 *            The BoundingBox of the element to create.
	 */
	public Element(BoundingBox area)
	{
		super();
		this.boundingBox = area;
	}

	// ************* Methods **************
	/**
	 * Calculate the overlapping of two Elements' Object. The compute is made through bounding box. The first element to
	 * compare is the current element and the second one is given as argument.
	 * 
	 * @param e
	 *            The element to compute the overlapping with.
	 * @return (BoundingBox) the intersection of both elements if it exists, <tt>null</tt> otherwise
	 */
	public BoundingBox overlapping(Element e)
	{
		return this.boundingBox.intersection(e.boundingBox);
	}

	// ************* Getters and Setters ***************

	// FIXME (SEEN) fix comment (this is not compliant with method signature)
	// I don't understand..
	// -> N.B. here, the element is not necessarily movable, and you can say that the method returns the bounding box of this element
	
	/**
	 * This method returns the location and size of the movable object.
	 * 
	 * @return return the location and size (BoundingBox) of the object <br/>
	 */
	public BoundingBox getArea()
	{
		return boundingBox;
	}

	// FIXME (SEEN) fix comment (this is not compliant with method signature)
	// I don't understand.
	// -> N.B. here, the element is not necessarily movable,
	/**
	 * This method allows to modify the location and size (BoundingBox) of the element. Setting position make the object moves<br/>
	 * 
	 * @param Bounding
	 *            box of the element
	 */
	protected void setArea(BoundingBox area)
	{
		this.boundingBox = area;
	}

	@Override
	public String toString()
	{
		return "Element [ position=" + this.getArea().getPosition() + ", taille=" + this.getArea().getSize() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
}
