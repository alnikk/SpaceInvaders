/**
 * 
 */
package fr.iutvalence.java.projet.unused;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.Movable;

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
	
	/**
	 * Create Monster with coordinates.<br/>
	 * By default the coordinate size is (10,10)
	 * 
	 * @param i Set the base position of the monster
	 */
	public Monster(Coordinates i)
	{
		super(i);
	}

	@Override
	public String toString()
	{
		return "Monster [isAlive()=" + this.isAlive() + ", getPosition()="
				+ this.getPosition() + ", getSize()=" + this.getSize() + "]";
	}

	// oldFIXME methods ?
	// not yet

}