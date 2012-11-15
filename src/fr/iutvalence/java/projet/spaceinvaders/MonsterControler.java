/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author Gallet Guyon
 *
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
	 */
	public int monstersMove();
	
}
