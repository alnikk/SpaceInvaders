package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This class allow you to create a movable object.
 * This is the mother class of all the movable object you can instantiate.
 *
 * A movable object is defined by size and position on the screen and also
 * his status [alive | dead].
 * A movable object can move on the screen and so being killed by others.
 * 
 * @author Gallet Guyon
 */
public class Movable
{
	// TODO Constant classe??
	// TODO in SpaceInvaders' class
	private static final int X = 300;

	// TODO in SpaceInvaders' class
	private static final int Y = 300;
	
	/**
	 * While the object is on the screen this boolean is true.<br/>
	 * When it isn't alive he can't called move method 
	 */
	private boolean  alive;

	/**
	 * The position of the movable object on the screen
	 */
	private Coordinates position;
	
	// FIXME do not use the type that carry a location semantics to carry an area semantics
	// Don't  understand
	/**
	 * The size of the movable on the screen
	 */
	private Coordinates taille;
	
	/**
	 * Initialize the movable object with position and size given in parameters
	 * 
	 * Contrary to Coordinates, you can change the values given by calling right method
	 * 
	 * @param i Set the position of the element you create 
	 * @param j Set the size of the element you create 
	 */
	public Movable(Coordinates i,Coordinates  j)
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
	 * @param alive the alive status to set
	 */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	/**
	 * This method returns the position of the object.
	 * 
	 * 
	 * @return return the position (Coordonnee) of the element between <br/>
	 * 			0 <= X <= MAX_X<br/>
	 * 			0 <= Y <= MAX_Y<br/>
	 * 			MAX_X and MAX_Y are the size of the screen
	 */
	public Coordinates getPosition()
	{
		return this.position;
	}

	/**
	 * This method sets the position of the object.
	 * Setting position make the object move between<br/>
	 * 0 <= X <= MAX_X<br/>
	 * 0 <= Y <= MAX_Y<br/>
	 * MAX_X and MAX_Y are the size of the screen<br/>
	 * 
	 *  Move an object allow you to control its position
	 *  in this area
	 *
	 * @param position the position of the element
	 */
	public void setPosition(final Coordinates position)
	{
		this.position = position;
	}

	/**
	 * This method returns the size of the object.<br/>
	 * 
	 * @return get the size (Coordonnee) of the object.
	 */
	public Coordinates getTaille()
	{
		return this.taille;
	}

	/**
	 * This method sets the size of the element on the screen
	 * @param taille the size of the element
	 */
	public void setTaille(final Coordinates taille)
	{
		this.taille = taille;
	}
	
	/**
	 * The move method changes the position of the object (the size is unchanged).
	 * It translates the coordinates by deltas given as x and y.
	 * The coordinated can NOT be over the size+position of the movable :<br/>
	 * between  0 <= X <= MAX_X<br/>
	 * 			0 <= Y <= MAX_Y<br/>
	 * 			MAX_X and MAX_Y are the size of the screen<br/>
	 * 
	 * @param x new coordinate relative on x axis
	 * @param y new coordinate relative on y axis
	 * @return true when coordinates can be translated, false if they can not.
	 */
	public boolean move(int dx, int dy)
	{
		if(this.position.getX()+this.taille.getX()+dx <= this.X && this.position.getY()+this.taille.getX()+dy <= this.Y && this.alive)
		{
			this.position = new Coordinates(this.position.getX()+dx,this.position.getY()+dy);
			return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		return "Movable [alive=" + this.alive + ", position=" + this.position + ", taille=" + this.taille + "]";   //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}

	//TODO Comment this 2 methods
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.alive ? 1231 : 1237);
		result = prime * result
				+ ((this.position == null) ? 0 : this.position.hashCode());
		result = prime * result
				+ ((this.taille == null) ? 0 : this.taille.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Movable)) {
			return false;
		}
		Movable other = (Movable) obj;
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
