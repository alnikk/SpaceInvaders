/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.ASCIIDisplay;
import fr.iutvalence.java.projet.spaceinvaders.FileScore;
import fr.iutvalence.java.projet.spaceinvaders.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVs;

/**
 * This class contains main program for
 * testing SpaceInvaders class with thread for
 * moving monsters and main thread who handle 
 * shoots, tank control and end of game.
 * ASCII graphics.
 * @author Gallet Guyon
 */
public class TestSpaceInvadersMaVs
{
	/**
	 * Create a new SpaceInvader's object to test it.
	 * 
	 * @param args No arguments..
	 */
	public static void main(String[] args)
	{
		ASCIIDisplay d = new ASCIIDisplay();
		FileScore score = new FileScore();
		SpaceInvadersMaVs si = new SpaceInvadersMaVs("Alex", score, d);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		monsters.start();
		si.run();
		System.out.println(si);
	}

}
