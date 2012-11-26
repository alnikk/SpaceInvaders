/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;

//TODO Commment
/**
 * This interface is the control of the game.<br/>
 * Thanks to this class your tanks objects can be moved on the grid. 
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
	 * @param delta cr
	 * @throws OutOfGridException
	 *             Indicate when Tank want to go over the screen. Then you can bip him ;)
	 */
	public void tankMove(Coordinates delta) throws OutOfGridException;
	
	/**
	 * @param k v
	 */
	public void setControleur(KeyListener k);
	
	/**
	 * @return c
	 */
	public boolean working();
}
