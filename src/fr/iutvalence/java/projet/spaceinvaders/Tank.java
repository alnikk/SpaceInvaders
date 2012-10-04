/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This class is son of Movable.<br/>
 * It represents the base of your "character"
 * 
 * @author Gallet Guyon
 */
public class Tank extends Movable
{
	/**
	 * Create Tank with 2 coordinates (position,size)
	 * 
	 * @param i Set the base position of the tank
	 * @param i Set the base size of the tank
	 */
	public Tank(Coordinates i, Coordinates j)
	{
		super(i, j);
	}
	
	/**
	 * Create Tank with coordinates.<br/>
	 * By default the coordinate size is (10,10)
	 * 
	 * @param i Set the base position of the monster
	 */
	public Tank(Coordinates i)
	{
		super(i);
	}

	// oldFIXME methods ?
	// not yet
}
