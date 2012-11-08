/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMaVs;

/**
 * This class tests the main class of SpaceInvaders
 * 
 * @author Gallet Guyon
 */
public class TestSpaceInvadersMaVs
{

	/**
	 * Create a new SpaceInvader's object to test it.
	 * 
	 * @param args
	 *            No arguments..
	 */
	public static void main(String[] args)
	{
		// TODO More Test
		SpaceInvadersMaVs SI = new SpaceInvadersMaVs(10,1,new Coordinates(150,30));
		
		System.out.println("Etat Initial :" + SI);
		
		SI.start();

		System.out.println("Etat Final :" + SI);
	}

}
