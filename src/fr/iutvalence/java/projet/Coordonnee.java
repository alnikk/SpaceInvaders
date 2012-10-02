package fr.iutvalence.java.projet;

/**
 * @author Gallet Guyon
 *
 */
public class Coordonnee
{
	private final int x;
	private final int y;
	
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
	

	/**
	 * @return the x
	 */
	public int getX()
	{
		return this.x;
	}

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
	
	
}
