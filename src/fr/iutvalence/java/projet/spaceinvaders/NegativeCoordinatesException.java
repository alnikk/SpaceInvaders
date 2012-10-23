/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * Thrown by a BoundingBox to indicate that there is a negative coordinates.
 * @author Gallet Guyon
 */
public class NegativeCoordinatesException extends Exception
{
	private Coordinates bad;

	public NegativeCoordinatesException(Coordinates bad)
	{
		super();
		this.bad = bad;
	}
	
	public NegativeCoordinatesException()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "You did key in : "+ this.bad;
	}
}
