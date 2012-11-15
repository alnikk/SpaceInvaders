/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author Gallet Guyon
 *
 */
public interface MonsterControleur
{
	/**
	 * Allows the player to shoot
	 */
	public void monsterShoot();

	/**
	 * Allows the player to move on the screen
	 * @throws OutOfGridException
	 *             Indicate when Tank want to go over the screen
	 */
	public void monstersMove() throws OutOfGridException;
}
