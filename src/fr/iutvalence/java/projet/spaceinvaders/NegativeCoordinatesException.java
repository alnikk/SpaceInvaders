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
	// FIXME write a comment
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

	// FIXME replace the redefinition of toString by a getter
	@Override
	public String toString()
	{
		return "You did key in : " + this.bad;
	}
}
