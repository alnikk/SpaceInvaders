package fr.iutvalence.java.projet;

/**
 * @author alexandre
 *
 */
public class Movable
{
	private final int X = 300;
	private final int Y = 300;
	private boolean  alive;
	private Coordonnee position;
	private Coordonnee taille;
	
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
	
	/**
	 * Constructeur par defaut
	 */
	public Movable()
	{
		super();
		this.position = new Coordonnee(10,10);
		this.taille = new Coordonnee(10,10);
		this.alive = true;
	}
	
	/**
	 * @return the alive
	 */
	public boolean isAlive()
	{
		return this.alive;
	}

	/**
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
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
	
	/**
	 * @param x nouvelle coordonée _RELATIVE_ en x
	 * @param y nouvelle coordonée _RELATIVE_ en y
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
