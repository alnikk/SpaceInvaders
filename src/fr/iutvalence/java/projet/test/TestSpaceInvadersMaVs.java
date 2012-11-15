/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVs;

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
		// TODO More Test
		SpaceInvadersMaVs si = new SpaceInvadersMaVs();
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		monsters.start();
		si.run();
	}

}
