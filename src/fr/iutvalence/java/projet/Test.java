/**
 * 
 */
package fr.iutvalence.java.projet;

/**
 * @author alexandre
 *
 */
public class Test
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//****Declaration****
		Coordonnee position = new Coordonnee(0,0);
		Coordonnee taille = new Coordonnee(10,10);
		Movable E1 = new Movable(position,taille);
		Movable E2 = new Movable(position,taille);
		Movable E3 = new Movable(position,taille);
				
		Liste T = new Liste();
		Liste A;
				
		//Fabrication de la chaine
		T.setObjet(E1);
		T.setNom("E1"); //$NON-NLS-1$
		A = T.setSuivant();
		A.setObjet(E2);
		A.setNom("E2"); //$NON-NLS-1$
		A = A.setSuivant();
		A.setObjet(E3);
		A.setNom("E3"); //$NON-NLS-1$
		A = A.suivant();
		if(A!=null)
		{
			A.setObjet(E3);
			A.setNom("E3"); //$NON-NLS-1$
		}
				
		//Differentiation des objets
		E1.move(10,10);
		E2.move(20,20);
		E3.move(30,30);				
		
		//Debug
		System.out.println(E1+"\n"+E2+"\n"+E3); //$NON-NLS-1$ //$NON-NLS-2$
		System.out.println(T);
	}
}
