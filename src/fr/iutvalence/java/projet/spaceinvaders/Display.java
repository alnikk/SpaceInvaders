/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This interface defines the common primitive of all view class
 * 
 * @author Guyon Gallet
 */
public interface Display
{
	/**
	 * Allows to display the game
	 * @param tanks 
	 * @param monsters 
	 * @param shoots 
	 * @param maxSize 
	 */
	public void show(Movable[] tanks, Movable[] monsters, Movable[] shoots, Coordinates maxSize);
}
