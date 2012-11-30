/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.BoundingBox;
import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.NegativeSizeException;

/**
 * This class contains main program for 
 * testing ALL methods of BoundingBox class.
 * @author Gallet Guyon
 */
public class TestBoundingBox
{

	/**
	 * @param args No arguments
	 */
	public static void main(String[] args)
	{
		try
		{
			BoundingBox b1 = new BoundingBox(new Coordinates(0, 0), new Coordinates(10, 10));
			BoundingBox b2 = new BoundingBox(new Coordinates(0, 0), new Coordinates(0, 0));
			BoundingBox b3 = new BoundingBox(new Coordinates(0, 0), new Coordinates(0, 0));

			b1 = b1.moveTo(new Coordinates(10, 10));/* Bb1 is fix */

			/* test with bb2 is bottom-left */
			b2 = b2.reSize(new Coordinates(10, 10));
			b2 = b2.translate(new Coordinates(5, 5));
			b3 = b3.translate(new Coordinates(10, 10));
			b3 = b3.reSize(new Coordinates(5, 5));

			System.out.println("Bottom-left :   b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2 : " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 is top-left */
			b2 = b2.translate(new Coordinates(0, 10));
			b3 = b3.translate(new Coordinates(0, 5));
			b3 = b3.reSize(new Coordinates(5, 5));

			System.out.println("Top-left :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 is left */
			b2 = b2.translate(new Coordinates(0, -5));
			b3 = new BoundingBox(new Coordinates(10, 10), new Coordinates(5, 10));

			System.out.println("left :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 is top and smaller */
			b2 = b2.reSize(new Coordinates(6, 4));
			b2 = b2.translate(new Coordinates(7, 8));
			b3 = b3.translate(new Coordinates(2, 8));
			b3 = b3.reSize(new Coordinates(6, 2));

			System.out.println("top and smaller :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 is left and taller */
			b2 = b2.reSize(new Coordinates(4, 14));
			b2 = b2.translate(new Coordinates(6, -10));
			b3 = b3.translate(new Coordinates(6, -8));
			b3 = b3.reSize(new Coordinates(2, 10));

			System.out.println("top and taller :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 is bottom and equal/ taller */
			b2 = b2.reSize(new Coordinates(12, 4));
			b2 = b2.translate(new Coordinates(-8, 0));
			b3 = b3.translate(new Coordinates(-8, 0));
			b3 = b3.reSize(new Coordinates(10, 2));

			System.out.println("bottom and equal/ taller :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 is inside */
			b2 = b2.reSize(new Coordinates(6, 6));
			b2 = b2.translate(new Coordinates(2, 4));
			b3 = b3.translate(new Coordinates(2, 2));
			b3 = b3.reSize(new Coordinates(6, 6));

			System.out.println("inside :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

			/* test with bb2 frame bb1 */
			b2 = b2.reSize(new Coordinates(12, 12));
			b2 = b2.translate(new Coordinates(-3, -3));
			b3 = b3.translate(new Coordinates(-2, -2));
			b3 = b3.reSize(new Coordinates(10, 10));

			System.out.println("frame :      b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\tTest waited b3 and b1 U b2: " + b3.equals(b2.intersection(b1))
					+ "\n\t\tTest waited b3 and b2 U b1 : " + b3.equals(b1.intersection(b2)) + "\n");

		}
		catch (NegativeSizeException e)
		{
			System.out.println(e.getNegativeCoordinatesException().toString());
			e.printStackTrace();
		}

	}

}