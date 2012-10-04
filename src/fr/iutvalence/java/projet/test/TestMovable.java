/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.Movable;

// FIXME improve the comment
/**
 * @author alexandre
 *
 */
public class TestMovable
{

	// FIXME improve the comment
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Coordinates C1 = new Coordinates(0, 0);
		Coordinates C2 = new Coordinates(10, 10);
		Movable E1 = new Movable(C1, C2);
		Movable E2 = new Movable(C1, C2);

		System.out.println(E1 + "\n" + E2); //$NON-NLS-1$

		E1.move(241, 241);
		System.out.println(E1 + "\n" + E2); //$NON-NLS-1$
	}
}
