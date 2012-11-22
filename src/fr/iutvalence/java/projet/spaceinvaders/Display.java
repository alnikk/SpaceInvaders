/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This interface defines the common primitive of all view class.<br/>
 * 
 * @author Guyon Gallet
 */
public interface Display
{
	/**
	 * Allows to display the game.
	 * @param tanks The table of tanks.
	 * @param monsters The table of monsters. 
	 * @param shoots The table of shoots.
	 * @param maxSize The maximum size of the grid.
	 */
	public void show(Movable[] tanks, Movable[] monsters, Movable[] shoots, Coordinates maxSize);
}
