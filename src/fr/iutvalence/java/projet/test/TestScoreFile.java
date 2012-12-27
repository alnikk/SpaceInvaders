/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.FileScore;

/**
 * Class for testing ScoreFile class
 * @author Gallet Guyon
 */
public class TestScoreFile
{
	/**
	 * @param args No args
	 */
	public static void main(String[] args)
	{
		FileScore sc = new FileScore();
		sc.init();
		sc.save("moi", 123);
		sc.save("moiii", 456);
		sc.showSheet();
	}
}
