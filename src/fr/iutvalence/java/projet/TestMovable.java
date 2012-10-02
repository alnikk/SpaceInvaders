/**
 * 
 */
// FIXME rename the package (may be a different name that the one chosen for core classes)
package fr.iutvalence.java.projet;

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
		Coordonnee C1 = new Coordonnee(0,0);
		Coordonnee C2 = new Coordonnee(10,10);
		Movable E1 = new Movable(C1,C2);
		Movable E2 = new Movable(C1,C2);
		
		System.out.println(E1+"\n"+E2); //$NON-NLS-1$
		
		E1.move(241, 241);
		System.out.println(E1+"\n"+E2); //$NON-NLS-1$
	}
}
