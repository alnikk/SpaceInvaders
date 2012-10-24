/**
 * 
 */
package fr.iutvalence.java.projet.unused;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.Movable;

/**
 * @author alexandre
 * 
 */
public class TestListe
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// ****Declaration****
		Coordinates position = new Coordinates(0, 0);
		Coordinates taille = new Coordinates(10, 10);

		Movable E1 = new Movable(position, taille);
		Movable E2 = new Movable(position, taille);
		Movable E3 = new Movable(position, taille);

		Liste T = new Liste();
		Liste A;

		/**** 1ere methode ****/

		// Fabrication de la chaine
		T.setObjet(E1);
		T.setNom("E1"); //$NON-NLS-1$
		A = T.setSuivant();
		A.setObjet(E2);
		A.setNom("E2"); //$NON-NLS-1$
		A = A.setSuivant();
		A.setObjet(E3);
		A.setNom("E3"); //$NON-NLS-1$
		if (A != null)
		{
			A.setObjet(E3);
			A.setNom("E3"); //$NON-NLS-1$
		}

		// Differentiation des objets
		E1.move(10, 10);
		E2.move(20, 20);
		E3.move(30, 30);

		/**** 2nd methode ****/
		/*
		 * T.setObjet(new Movable(position,taille)); A = T.setSuivant(); A.setObjet(new Movable(position,taille)); A =
		 * A.setSuivant(); A.setObjet(new Movable(position,taille));
		 * 
		 * 
		 * A = T; ((Movable) A.getObjet()).move(10,10); A = A.suivant(); ((Movable) A.getObjet()).move(20,20); A =
		 * A.suivant(); ((Movable) A.getObjet()).move(30,30);
		 * 
		 * 
		 * A = T; E1 = ((Movable) A.getObjet()); A = A.suivant(); E2 = ((Movable) A.getObjet()); A = A.suivant(); E3 =
		 * ((Movable) A.getObjet());
		 */

		// Debug
		System.out.println(E1 + "\n" + E2 + "\n" + E3); //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(T);

	}

}
