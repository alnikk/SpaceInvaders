/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author Guyon Gallet
 *
 */
public abstract class Element
{
	private BoundingBox area;

	public Element(BoundingBox area)
	{
		super();
		this.area = area;
	}

	/**
	 * @return the area
	 */
	public BoundingBox getArea()
	{
		return area;
	}

	/**
	 * @param area the area to set
	 */
	protected void setArea(BoundingBox area)
	{
		this.area = area;
	}
}
