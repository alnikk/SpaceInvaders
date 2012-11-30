/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMsVs;
import fr.iutvalence.java.projet.spaceinvaders.SwingDisplay;
import fr.iutvalence.java.projet.spaceinvaders.TankListener;

/**
 * This class contains main program for
 * testing SpaceInvaders class with thread for
 * main thread who handle shoots, tank control,
 * moving monsters and end of game.
 * Swing graphics.
 * @author Gallet Guyon
 */
public class TestSwingMsVs
{
	/**
	 * This class test space invaders model MaVa with Swing controls and graphics
	 * @param args No
	 */
	public static void main(String[] args) 
	{
		SwingDisplay d = new SwingDisplay(400,400);
		SpaceInvadersMsVs si = new SpaceInvadersMsVs(d);
		TankListener tank = new TankListener(si);
		MonstersThread monsters = new MonstersThread("Monsters", si, 1000);
		
		tank.start();
		monsters.start();
		si.run();
		System.out.println(si);
	}
}
