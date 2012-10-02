// FIXME rename the package
package fr.iutvalence.java.projet;


// FIXME finish writing the comment
/**
 * @author alexandre
 *
 */
public class Movable
{
	// FIXME write a comment
	// FIXME define this as "true" constant 
	private final int X = 300;

	// FIXME write a comment
	// FIXME define this as "true" constant 
	private final int Y = 300;
	
	// FIXME write a comment
	private boolean  alive;

	// FIXME write a comment
	private Coordonnee position;
	
	// FIXME write a comment
	private Coordonnee taille;
	
	
	// FIXME finish writing the comment
	/**
	 * @param i Set the position of the element
	 * @param j Set the size of the element
	 */
	public Movable(Coordonnee i,Coordonnee  j)
	{
		super();
		this.position = i;
		this.taille = j;
		this.alive = true;
	}
	
	// FIXME improve the comment
	/**
	 * Constructeur par defaut
	 */
	public Movable()
	{
		super();
		
		// FIXME define default values as constants
		this.position = new Coordonnee(10,10);
		this.taille = new Coordonnee(10,10);
		this.alive = true;
	}

	// FIXME improve the comment
	/**
	 * @return the alive
	 */
	public boolean isAlive()
	{
		return this.alive;
	}

	// FIXME improve the comment
	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
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
	
	// FIXME improve the comment
	/**
	 * @param x nouvelle coordon√©e _RELATIVE_ en x
	 * @param y nouvelle coordon√©e _RELATIVE_ en y
	 */
	public void move(int x, int y)
	{
		if(this.position.getX()+this.taille.getX()+x <= this.X && this.position.getY()+this.taille.getX()+y <= this.Y)
		{
			this.position = new Coordonnee(this.position.getX()+x,this.position.getY()+y);
		}
	}

	@Override
	public String toString()
	{
		return "Movable [alive=" + this.alive + ", position=" + this.position + ", taille=" + this.taille + "]";   //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
	


	
}
