/**
 * 
 */
package fr.iutvalence.java.projet.test;

import fr.iutvalence.java.projet.spaceinvaders.BoundingBox;
import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.NegativeCoordinatesException;

/**
 * @author alexandre
 *
 */
public class TestBoundingBox
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			BoundingBox b1 = new BoundingBox(new Coordinates(0,0),
												new Coordinates(10,10));
			BoundingBox b2 = new BoundingBox(new Coordinates(0,0),
												new Coordinates(0,0));
			BoundingBox b3 = new BoundingBox(new Coordinates(0,0),
												new Coordinates(0,0));
			
			b1 = b1.moveTo(new Coordinates(10,10));/* Bb1 is fix*/
			b2 = b2.reSize(new Coordinates(10,10));
			
			
			
			/* test with bb2 is bottom-left*/
			b2 = b2.translate(new Coordinates(5,5));
			b3 = b3.translate(new Coordinates(10, 10));
			b3 = b3.reSize(new Coordinates(5,5));

			System.out.println("Bottom-left :   b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\t" + b3.equals(b2.intersection(b1))+"-"+ b3.equals(b1.intersection(b2)) + "\ton test si b3 (attendu) est égal à intersection de b1, b2 \n");
		
		
		
			/* test with bb2 is top-left*/
			b2 = b2.translate(new Coordinates(0,10));
			b3 = b3.translate(new Coordinates(0, 5));
			b3 = b3.reSize(new Coordinates(5,5));

			System.out.println("Top-left :   b1 " + b1 + "\n\t\tb2 " + b2);
			System.out.println("Intersection :  b3 " + b2.intersection(b1));
			System.out.println("\t\t" + b3.equals(b2.intersection(b1))+"-"+ b3.equals(b1.intersection(b2)) + "\ton test si b3 (attendu) est égal à intersection de b1, b2 \n");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		catch (NegativeCoordinatesException e)
		{
			e.printStackTrace();
		}

	}

}
