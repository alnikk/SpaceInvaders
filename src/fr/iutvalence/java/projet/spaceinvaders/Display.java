/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;


/**
 * This interface defines the common primitive of all view class.<br/>
 * 
 * @author Guyon Gallet
 */
public interface Display
{
	/**
	 * Allows to display the game.
	 */
	public void show();
	
	/**
	 * Allows to initialize the display.
	 * @param e (KeyListener) Allows to control your tank(s).
	 * @param elements (Movable[]) Movable to display.
	 * @param maxSize (Coordinates) The maximum coordinates of the grid.
	 */
	public void init(KeyListener e, Movable elements[], Coordinates maxSize);
}
