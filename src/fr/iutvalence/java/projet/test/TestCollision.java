package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvaders;

/**
 * This class tests the collision in SpaceInvaders
 * 
 * @author Gallet Guyon
 */
public class TestCollision
{
	/**
	 * Create a new SpaceInvader's object to test Collision.
	 * @param args No arguments..
	 */
	public static void main(String[] args)
	{
		Coordinates cMax = new Coordinates(300,300);
		SpaceInvaders S = new SpaceInvaders(1,1,cMax);
		S.start();
	}
}
