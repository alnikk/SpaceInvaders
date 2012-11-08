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
	 * Area of the grid filled by the element
	 */
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


	/**
	 * This method returns the bounding box of the element
	 * 
	 * @return return the bounding box of the element
	 */
	public BoundingBox getArea()
	{
		return this.boundingBox;
	}

	/**
	 * This method allows to modify the location and size (BoundingBox) of the element. 
	 * 
	 * @param area bounding box of the element
	 */
	protected void setArea(BoundingBox area)
	{
		this.boundingBox = area;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Element [ position=" + this.getArea().getPosition() + ", taille=" + this.getArea().getSize() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
}
