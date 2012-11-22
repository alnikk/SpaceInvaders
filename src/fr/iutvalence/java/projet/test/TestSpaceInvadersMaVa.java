/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVa;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVs;
import fr.iutvalence.java.projet.spaceinvaders.display.ASCIIDisplay;
import fr.iutvalence.java.projet.spaceinvaders.threads.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.threads.TanksThreads;

/**
 * @author Gallet Guyon
 *
 */
public class TestSpaceInvadersMaVa
{
	/**
	 * @param args No arguments
	 */
	public static void main(String[] args)
	{
		ASCIIDisplay d = new ASCIIDisplay();
		SpaceInvadersMaVa si = new SpaceInvadersMaVa(d);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		TanksThreads tank = new TanksThreads(si);
		
		tank.start();
		monsters.start();
		si.run();
		System.out.println(si);
	}

}
