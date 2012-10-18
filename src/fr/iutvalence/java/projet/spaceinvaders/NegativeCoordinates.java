/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * Thrown by a BoundingBox to indicate that there is a negative coordinates.
 * @author Gallet Guyon
 */
public class NegativeCoordinates extends Exception
{
	private int number;

	public NegativeCoordinates(int number)
	{
		super();
		this.number = number;
	}
	
	public NegativeCoordinates()
	{
		super();
	}

	@Override
	public String toString()
	{
		return "You did key in : "+ this.number;
	}
}
