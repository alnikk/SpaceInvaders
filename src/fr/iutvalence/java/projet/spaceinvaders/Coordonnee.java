// FIXME remove FIXME once fixed ;-)
// FIXME rename the package
package fr.iutvalence.java.projet.spaceinvaders;


// FIXME rename the class (Coordinates, Location, ...)
// FIXME make the comment readable (see html files) 
/*
 * @author Gallet Guyon
 * 
 * This class allow you to use couple of to integer
 * as coordinates.
 */
public class Coordonnee
{	
	// The X coordinate
	private final int x;
	
	// The Y coordinate
	private final int y;
	
	// FIXME improve the comment, saying what is the state of coordinates once created
	/**
	 * instantiate new object who brings you coordinated
	 * 
	 * @param x the X coordinate  
	 * @param y the Y coordinate
	 */
	public Coordonnee(final int x, final int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	// FIXME make the comment readable (see html files)
	/**
	 * @return Return the X coordinated of the object
	 */
	public int getX()
	{
		return this.x;
	}

	// FIXME make the comment readable (see html files)
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

	// FIXME write your own version of hashCode
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

	// FIXME write your own version of equals or comment inside code to prove that you understand it and do not use getClass() but instanceof
	// FIXME write a comment to explain what means equality here
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
