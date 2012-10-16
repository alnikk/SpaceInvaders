package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.SpaceInvaders;

//FIXME write comment
public class TestCollision
{
	// FIXME finish writing comment
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Coordinates cMax = new Coordinates(300,300);
		SpaceInvaders S = new SpaceInvaders(1,1,cMax);
		S.start();
	}
}
