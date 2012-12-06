package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This interface is used to save score.
 * @author Gallet Guyon
 */
public interface Score
{

	/**
	 * Initialize score's sheets
	 */
	public void init();
	
	/**
	 * Save the score and name into sheets. 
	 * @param name The player's name to add
	 * @param score The player's score to add
	 */
	public void save(String name, long score);
	
	/**
	 * Allows you to display score.
	 */
	public void showSheet();
}
