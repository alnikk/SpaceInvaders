/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVa;
import fr.iutvalence.java.projet.spaceinvaders.display.SwingDisplay;
import fr.iutvalence.java.projet.spaceinvaders.threads.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.threads.TanksThreads;

/**
 * @author Gallet Guyon
 */
public class TestSwing
{
	/**
	 * @param args No
	 */
	public static void main(String[] args)
	{
		SwingDisplay d = new SwingDisplay(400,400);
		SpaceInvadersMaVa si = new SpaceInvadersMaVa(d);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		TanksThreads tank = new TanksThreads(si);
		
		tank.start();
		monsters.start();
		si.run();
		System.out.println(si);
	}
}
