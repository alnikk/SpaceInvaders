/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * Thrown when only positive coordinates are expected
 * 
 * @author Gallet Guyon
 */
@SuppressWarnings("serial")
public class OutOfGridException extends Exception
{
	/**
	 * This variable is the bad coordinates. Exception due to this coordinates. 
	 */
	private Coordinates bad;

	/**
	 * Constructors who defined the bad Coordinates to handle 
	 * @param bad It is the bad coordinates to handle. It create an OutOfGridException
	 */
	public OutOfGridException(Coordinates bad)
	{
		super();
		this.bad = bad;
	}

	/**
	 * Default Constructors, it create an OutOfGridException 
	 */
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
