/**
 * 
 */
package fr.iutvalence.java.projet;

/**
 * @author Gallet Guyon
 *
 */
public class Elements
{
	private Coordonnee position;
	private Coordonnee taille;
	
	/**
	 * @param i Set the postion of the element
	 * @param j Set the size of the element
	 */
	public Elements(Coordonnee i,Coordonnee  j)
	{
		super();
		this.position = i;
		this.taille = j;
	}
	
	/**
	 * Constructeur par defaut
	 */
	public Elements()
	{
		super();
		this.position = new Coordonnee(10,10);
		this.taille = new Coordonnee(10,10);
	}
	
	/**
	 * @return return the position of the element
	 */
	public Coordonnee getPosition()
	{
		return this.position;
	}

	/**
	 * @param position set the position of the element
	 */
	public void setPosition(final Coordonnee position)
	{
		this.position = position;
	}

	/**
	 * @return get the size of the element
	 */
	public Coordonnee getTaille()
	{
		return this.taille;
	}

	/**
	 * @param taille set the size of the element
	 */
	public void setTaille(final Coordonnee taille)
	{
		this.taille = taille;
	}

	@Override
	public String toString()
	{
		return "Elements [position=" + this.position + ", taille=" + this.taille + "]";  //$NON-NLS-1$//$NON-NLS-2$ //$NON-NLS-3$
	}
	
	
}
