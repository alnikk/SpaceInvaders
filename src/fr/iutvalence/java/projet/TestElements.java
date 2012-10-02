/**
 * 
 */
package fr.iutvalence.java.projet;

/**
 * @author alexandre
 *
 */
public class TestElements
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Coordonnee C1 = new Coordonnee(25,25);
		Coordonnee C2 = new Coordonnee(50,50);
		Elements E1 = new Elements();
		Elements E2 = new Elements(C1,C2);
		
		System.out.println(E1+"\n"+E2); //$NON-NLS-1$
	}

}
