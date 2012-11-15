/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This interface defines all common method to control Invaders
 * @author Gallet Guyon
 */
public interface MonsterControler
{
	/**
	 * Allows the player to shoot
	 */
	public void monsterShoot();

	/**
	 * Allows the player to move on the screen
	 * @return 
	 * 		(integer) this returns the wait time between each move. When it's equals to 0
	 * 		the game is finished.
	 */
	public int monstersMove();
	
}
