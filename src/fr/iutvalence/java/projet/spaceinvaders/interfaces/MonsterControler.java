/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders.interfaces;

/**
 * This interface defines all common method to control Monsters.<br/>
 * Monsters can move, and shoots.
 * @author Gallet Guyon
 */
public interface MonsterControler
{
	/**
	 * Allows one of monsters to shoot.<br/>
	 * The monster who shot do is above a tank. 
	 */
	public void monsterShoot();

	/**
	 * Allows the monsters to move on the screen
	 * @return 
	 * 		(integer) This returns the wait time between each move. When it's equals to 0
	 * 		the game is finished.
	 */
	public int monstersMove();

	/**
	 * This method wait a time in function of sleepTime value and of monster alive's number
	 */
	public void waitLoop();
	
}
