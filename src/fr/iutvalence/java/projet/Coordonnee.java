// FIXME rename the package
package fr.iutvalence.java.projet;


// FIXME finish writing the comment
// FIXME rename the class
/**
 * @author Gallet Guyon
 *
 */
public class Coordonnee
{	
	// FIXME write a comment
	private final int x;
	
	// FIXME write a comment
	private final int y;
	
	
	// FIXME finish writing the comment
	/**
	 * @param x
	 * @param y
	 */
	public Coordonnee(final int x, final int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	// FIXME improve the comment
	/**
	 * @return the x
	 */
	public int getX()
	{
		return this.x;
	}

	// FIXME improve the comment
	/**
	 * @return the y
	 */
	public int getY()
	{
		return this.y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Coordonnee [x=" + this.x + ", y=" + this.y + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	// FIXME override equals and hashCode
}
