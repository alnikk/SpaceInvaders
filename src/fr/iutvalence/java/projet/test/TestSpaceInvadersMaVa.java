/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.ASCIIDisplay;
import fr.iutvalence.java.projet.spaceinvaders.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVa;
import fr.iutvalence.java.projet.spaceinvaders.SwingDisplay;
import fr.iutvalence.java.projet.spaceinvaders.TankListener;

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
		SwingDisplay d = new SwingDisplay(400,400);
		SpaceInvadersMaVa si = new SpaceInvadersMaVa(d);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		TankListener tank = new TankListener(si);
		
		monsters.start();
		si.run();
		System.out.println(si);
	}

}
