/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * Thrown when only positive coordinates are expected 
 * 
 * @author Gallet Guyon
 */
public class NegativeCoordinatesException extends Exception
{
	// FIXME (SEEN) write a comment
	/**
	 * This variable is the bad coordinates. Exception due to this coordinates. 
	 */
	private Coordinates bad;

	// FIXME write a comment
	public NegativeCoordinatesException(Coordinates bad)
	{
		super();
		this.bad = bad;
	}

	// FIXME write a comment
	public NegativeCoordinatesException()
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
