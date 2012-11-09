/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMsVs;

/**
 * @author Gallet Guyon
 *
 */
public class TestSpaceInvadersMsVs
{

	/**
	 * @param args No arguments
	 */
	public static void main(String[] args)
	{
		// TODO More Test
		SpaceInvadersMsVs SI = new SpaceInvadersMsVs();
		
		System.out.println("Etat Initial :" + SI);
		
		SI.run();

		System.out.println("Etat Final :" + SI);

	}

}
