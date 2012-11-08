/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvadersMsVs;

/**
 * @author Gallet Guyon
 *
 */
public class TestSpaceInvadersMsVs
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO More Test
		SpaceInvadersMsVs SI = new SpaceInvadersMsVs(10,1,new Coordinates(150,100));
		
		System.out.println("Etat Initial :" + SI);
		
		SI.start();

		System.out.println("Etat Final :" + SI);

	}

}
