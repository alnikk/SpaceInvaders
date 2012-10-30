/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * Thrown when only positive coordinates are expected 
 * 
 * @author Gallet Guyon
 */
public class NegativeSizeException extends Exception
{
	// FIXME (SEEN) write a comment
	/**
	 * This variable is the bad coordinates. Exception due to this coordinates. 
	 */
	private Coordinates bad;

	// FIXME (SEEN) write a comment
	/**
	 * Constructors who defined the bad Coordinates to handle 
	 * @param bad It is the bad coordinates to handle. It create an NegativeCoorinatesException
	 */
	public NegativeSizeException(Coordinates bad)
	{
		super();
		this.bad = bad;
	}

	// FIXME (SEEN) write a comment
	/**
	 * Default Constructors, it create an NegativeCoorinatesException 
	 */
	public NegativeSizeException()
	{
		super();
	}

	// FIXME (SEEN) replace the redefinition of toString by a getter
	/**
	 * @return the bad coordinates
	 */
	public Coordinates getNegativeCoordinatesException()
	{
		return this.bad;
	}
}
