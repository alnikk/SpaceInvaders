/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVs;
import fr.iutvalence.java.projet.spaceinvaders.display.ASCIIDisplay;
import fr.iutvalence.java.projet.spaceinvaders.threads.MonstersThread;

/**
 * This class tests the main class of SpaceInvaders
 * 
 * @author Gallet Guyon
 */
public class TestSpaceInvadersMaVs
{

	/**
	 * Create a new SpaceInvader's object to test it.
	 * 
	 * @param args
	 *            No arguments..
	 */
	public static void main(String[] args)
	{
		ASCIIDisplay d = new ASCIIDisplay();
		SpaceInvadersMaVs si = new SpaceInvadersMaVs(d);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		monsters.start();
		si.run();
		System.out.println(si);
	}

}
