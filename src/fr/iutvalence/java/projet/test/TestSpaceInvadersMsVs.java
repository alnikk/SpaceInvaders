/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMsVs;
import fr.iutvalence.java.projet.spaceinvaders.SwingDisplay;

/**
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
		SwingDisplay d = new SwingDisplay(400,400);
		SpaceInvadersMsVs si = new SpaceInvadersMsVs(d);
		si.run();
		System.out.println(si);
	}

}
