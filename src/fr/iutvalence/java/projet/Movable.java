// FIXME rename the package
package fr.iutvalence.java.projet;


// FIXME finish writing the comment
/**
 * @author Gallet Guyon
 *
 * This class allow you to create a movable object.
 * This is the mother class of all the movable object you can instantiate.
 */
public class Movable
{
	// FIXME ToDo in SpaceInvaders' class
	// FIXME define this as "true" constant 
	private final int X = 300;

	// FIXME ToDo in SpaceInvaders' class
	// FIXME define this as "true" constant 
	private final int Y = 300;
	
	// While the object is on the screen this boolean is true
	private boolean  alive;

	// The position of the movable on the screen
	private Coordonnee position;
	
	// The size of the movable on the screen 
	private Coordonnee taille;
	
	
	/**
	 * Initialize the movable object with position and size
	 * 
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
	 * Return if the object is still alive
	 * @return the life status
	 */
	public boolean isAlive()
	{
		return this.alive;
	}

	/**
	 * Set if the object have to still be alive ^^
	 * @param alive the alive to set
	 */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	/**
	 * This method returns the position of the element on the screen
	 * @return return the position of the element
	 */
	public Coordonnee getPosition()
	{
		return this.position;
	}

	/**
	 * This method sets the position of the element on the screen
	 * @param position set the position of the element
	 */
	public void setPosition(final Coordonnee position)
	{
		this.position = position;
	}

	// FIXME improve the comment
	/**
	 * This method returns the size of the element on the screen
	 * @return get the size of the element
	 */
	public Coordonnee getTaille()
	{
		return this.taille;
	}

	/**
	 * This method sets the size of the element on the screen
	 * @param taille set the size of the element
	 */
	public void setTaille(final Coordonnee taille)
	{
		this.taille = taille;
	}
	
	/**
	 * The move method changes the position of the object (the size is unchanged).
	 * It add x parameters to x coordinated and do the same with y.
	 * The coordinated can NOT be over the size+position of the movable on the screen 
	 * It returns false when it can not changes the position
	 * 
	 * @param x new coordinated relative on x axis
	 * @param y new coordinated relative on y axis
	 * @return true when coordinated changes and false if it fails
	 */
	public boolean move(int x, int y)
	{
		if(this.position.getX()+this.taille.getX()+x <= this.X && this.position.getY()+this.taille.getX()+y <= this.Y)
		{
			this.position = new Coordonnee(this.position.getX()+x,this.position.getY()+y);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String toString()
	{
		return "Movable [alive=" + this.alive + ", position=" + this.position + ", taille=" + this.taille + "]";   //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.X;
		result = prime * result + this.Y;
		result = prime * result + (this.alive ? 1231 : 1237);
		result = prime * result
				+ ((this.position == null) ? 0 : this.position.hashCode());
		result = prime * result
				+ ((this.taille == null) ? 0 : this.taille.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Movable other = (Movable) obj;
		if (this.X != other.X) {
			return false;
		}
		if (this.Y != other.Y) {
			return false;
		}
		if (this.alive != other.alive) {
			return false;
		}
		if (this.position == null) {
			if (other.position != null) {
				return false;
			}
		} else if (!this.position.equals(other.position)) {
			return false;
		}
		if (this.taille == null) {
			if (other.taille != null) {
				return false;
			}
		} else if (!this.taille.equals(other.taille)) {
			return false;
		}
		return true;
	}	
}
