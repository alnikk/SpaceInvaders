// FIXME remove FIXME once fixed ;-)
// FIXME rename the package
/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

// FIXME finish writing the comment
/**
 * @author Gallet Guyon
 *
 */
public class Elements
{
	//FIXME write a comment
	private Coordonnee position;
	
	//FIXME write a comment
	private Coordonnee taille;
	
	//FIXME improve the comment
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
	
	//FIXME improve the comment
	/**
	 * Constructeur par defaut
	 */
	public Elements()
	{
		super();
		// FIXME define default values as constants 
		this.position = new Coordonnee(10,10);
		this.taille = new Coordonnee(10,10);
	}
	
	// FIXME improve the comment
	/**
	 * @return return the position of the element
	 */
	public Coordonnee getPosition()
	{
		return this.position;
	}

	// FIXME improve the comment
	/**
	 * @param position set the position of the element
	 */
	public void setPosition(final Coordonnee position)
	{
		this.position = position;
	}

	// FIXME improve the comment
	/**
	 * @return get the size of the element
	 */
	public Coordonnee getTaille()
	{
		return this.taille;
	}

	// FIXME improve the comment
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
