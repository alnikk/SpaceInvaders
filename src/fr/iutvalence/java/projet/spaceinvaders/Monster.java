/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

// TODO Check the behavior of contact of monster and anyone else 
/**
 * This class is son of Movable.
 * It represents the base of enemy(s).
 * In instantiated Monster, you create an enemy
 * and if he get contact with tank, for example, 
 * [tank | monster | both] die.
 *
 * 
 * @author Gallet Guyon
 */
public class Monster extends Movable
{

	/**
	 * Create Monster with 2 coordinates (position,size)
	 * 
	 * @param i Set the base position of the monster
	 * @param i Set the base size of the monster
	 */
	public Monster(Coordinates i, Coordinates j)
	{
		super(i, j);
	}

	// FIXME methods ?
	// not yet

}
