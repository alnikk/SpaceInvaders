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
		ASCIIDisplay d = new ASCIIDisplay();
		SpaceInvadersMaVa si = new SpaceInvadersMaVa(d);
		TankListener tank = new TankListener(si);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		
		tank.start();
		monsters.start();
		si.run();
		System.out.println(si);
	}

}
