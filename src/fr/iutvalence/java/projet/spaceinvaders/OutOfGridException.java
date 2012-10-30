/**
 * 
 */
// TODO Comment Class
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * 
 * @author Gallet Guyon
 */
public class OutOfGridException extends Exception
{
	
	private Coordinates bad;

	
	public OutOfGridException(Coordinates bad)
	{
		super();
		this.bad = bad;
	}

	public OutOfGridException()
	{
		super();
	}

	/**
	 * @return the bad coordinates
	 */
	public Coordinates getOutOfGridException()
	{
		return this.bad;
	}
}
