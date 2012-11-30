/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.ASCIIDisplay;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMsVs;

/**
 * This class contains main program for
 * testing SpaceInvaders class with thread for
 * main thread who handle shoots, tank control,
 * moving monsters and end of game.
 * ASCII graphics.
 * @author Gallet Guyon
 */
public class TestSpaceInvadersMsVs
{
	/**
	 * @param args
	 *            No arguments
	 */
	public static void main(String[] args)
	{
		ASCIIDisplay d = new ASCIIDisplay();
		SpaceInvadersMsVs si = new SpaceInvadersMsVs(d);
		si.run();
		System.out.println(si);
	}

}
