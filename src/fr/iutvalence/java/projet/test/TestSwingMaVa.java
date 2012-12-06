/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.FileScore;
import fr.iutvalence.java.projet.spaceinvaders.MonstersThread;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVa;
import fr.iutvalence.java.projet.spaceinvaders.SwingDisplay;
import fr.iutvalence.java.projet.spaceinvaders.TankListener;

/**
 * This class contains main program for
 * testing SpaceInvaders class with thread for
 * moving monsters and tank control, and 
 * main thread who handle shoots and end of game.
 * Swing graphics.
 * @author Gallet Guyon
 */
public class TestSwingMaVa
{
	/**
	 * This class test space invaders model MaVa with Swing controls and graphics
	 * @param args No
	 */
	public static void main(String[] args) 
	{
		SwingDisplay d = new SwingDisplay(400,400);
		FileScore score = new FileScore();
		SpaceInvadersMaVa si = new SpaceInvadersMaVa("Alex", score, d);
		TankListener tank = new TankListener(si);
		MonstersThread monsters = new MonstersThread(si);
		
		tank.start();
		monsters.start();
		si.run();
		System.out.println(si);
	}
}
