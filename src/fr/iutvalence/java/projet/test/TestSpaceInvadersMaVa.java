/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.ASCIIDisplay;
import fr.iutvalence.java.projet.spaceinvaders.FileScore;
import fr.iutvalence.java.projet.spaceinvaders.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVa;
import fr.iutvalence.java.projet.spaceinvaders.TankListener;

/**
 * This class contains main program for
 * testing SpaceInvaders class with thread for
 * moving monsters and tank control, and 
 * main thread who handle shoots and end of game.
 * ASCII graphics.
 * @author Gallet Guyon
 */
public class TestSpaceInvadersMaVa
{
	/**
	 * @param args No arguments
	 */
	public static void main(String[] args)
	{
		ASCIIDisplay d = new ASCIIDisplay();
		FileScore score = new FileScore();
		SpaceInvadersMaVa si = new SpaceInvadersMaVa("Alex", score, d);
		TankListener tank = new TankListener(si);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		
		tank.start();
		monsters.start();
		si.run();
		System.out.println(si);
	}

}
