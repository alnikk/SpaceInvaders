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
	private int number;

	public NegativeCoordinatesException(int number)
	{
		super();
		this.number = number;
	}
	
	public NegativeCoordinatesException()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "You did key in : "+ this.number;
	}
}
