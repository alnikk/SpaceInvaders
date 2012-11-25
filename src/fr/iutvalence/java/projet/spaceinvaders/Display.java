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
	 * @param elements The table of all Movable objects.
	 * @param maxSize The maximum size of the grid.
	 */
	public void show(Movable[] elements, Coordinates maxSize);
}
