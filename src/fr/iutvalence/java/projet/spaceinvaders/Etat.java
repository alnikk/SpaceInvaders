/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This enumerate the state of invaders on the grid.
 * The cycle of the movement is :
 * <ul>
 * <li>left - LEFT_UP</li>
 * <li>right - RIGHT_UP</li>
 * <li>down - RIGHT_BOTTOM</li>
 * <li>left - LEFT_BOTTOM</li>
 * <li>down - LEFT_UP</li>
 * <li>right - RIGHT_UP</li>
 * <li> etc..</li>
 * </ul>
 */
public enum Etat
{
	/**
	 * This is the first state, and invaders are left side on the grid
	 */
	LEFT_UP,
	/**
	 * This is the second state, and invaders are right side on the grid
	 */
	RIGHT_UP,
	/**
	 * This is the third state, and invaders are right side on the grid
	 */
	RIGHT_BOTTOM,
	/**
	 * This is the fourth state, and invaders are left side on the grid
	 */
	LEFT_BOTTOM
};