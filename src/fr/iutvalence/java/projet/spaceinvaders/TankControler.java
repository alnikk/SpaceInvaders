/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;

/**
 * This interface is the control of the game.<br/>
 * Thanks to this class your tanks objects can 
 * be moved on the grid. 
 * 
 * @author Gallet Guyon
 */
public interface TankControler
{
	/**
	 * Allows the player to shoot.
	 */
	public void tankShoot();

	/**
	 * Allows the player to move on the screen.
	 * @param delta (Coordinates) The delta to move
	 * 				Tank
	 */
	public void tankMove(Coordinates delta);
	
	/**
	 * @param k Sets the KeyListeners for control Tanks 
	 */
	public void setControleur(KeyListener k);
	
	/**
	 * @return returns if the game is still running.
	 */
	public boolean working();
}
