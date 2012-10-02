// FIXME rename the package
package fr.iutvalence.java.projet.spaceinvaders;


// FIXME rename the class
/**
 * @author Gallet Guyon
 * 
 * This class allow you to use couple of to integer
 * as coordinated.
 */
public class Coordonnee
{	
	// The X coordinated
	private final int x;
	
	// The Y coordinated
	private final int y;
	
	
	/**
	 * instantiate new object who brings you coordinated
	 * 
	 * @param x The X coordinated of the object 
	 * @param y The Y coordinated of the object
	 */
	public Coordonnee(final int x, final int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * @return Return the X coordinated of the object
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * @return Return the y coordinated of the object
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

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Coordonnee other = (Coordonnee) obj;
		if (x != other.x) {
			return false;
		}
		if (y != other.y) {
			return false;
		}
		return true;
	}
	
		
}
