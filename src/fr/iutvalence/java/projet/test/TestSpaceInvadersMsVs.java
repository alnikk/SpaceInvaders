/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMsVs;
import fr.iutvalence.java.projet.spaceinvaders.display.ASCIIDisplay;

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
		ASCIIDisplay d = new ASCIIDisplay();
		SpaceInvadersMsVs si = new SpaceInvadersMsVs(d);
		si.run();
		System.out.println(si);
	}

}
