/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvaders;

/**
 * This class tests the main class of SpaceInvaders
 * 
 * @author Gallet Guyon
 */
public class TestSpaceInvaders
{

	/**
	 * Create a new SpaceInvader's object to test it.
	 * 
	 * @param args
	 *            No arguments..
	 */
	public static void main(String[] args)
	{
		SpaceInvaders SI = new SpaceInvaders(1, 1);
		
		System.out.println("Etat Initial :" + SI);
		
		try
		{
			SI.start();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Etat Final :" + SI);
	}

}
