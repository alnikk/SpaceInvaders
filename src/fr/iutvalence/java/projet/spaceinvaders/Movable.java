package fr.iutvalence.java.projet.spaceinvaders;

// FIXME (FIXED) fix comment
/**
 * This class defines a a movable object, that can move on a 2D grid and so being killed by others.
 * 
 * A movable object is characterized by its size and position on the screen and also its status [alive | dead].
 * 
 * @author Gallet Guyon
 */
public class Movable
{
	
	// FIXME  you need to think about how constrain the movable object to stay in a defined grid
	// - the constants (default grid bounds) have to be declared outside
	
	// TODO Constant classe??
	// TODO in SpaceInvaders' class
	private static final int X = 300;

	// TODO in SpaceInvaders' class
	private static final int Y = 300;

	// FIXME (FIXED) fix the comment 
	/**
	 * Status indicating if the movable object is still alive (a dead movable can no longer move).
	 */
	private boolean alive;

	// FIXME (FIXED) fix the comment 
	/**
	 * The position of the movable object on the 2D grid
	 */
	private Coordinates position;

	// FIXME do not use the type that carry a location semantics to carry an
	// area semantics
	// Don't understand

	// FIXME rename field
	/**
	 * The size of the movable on the screen
	 */
	private Coordinates taille;
	// FIXME (FIXED) fix the comment 	
	/**
	 * This constructor creates a new living <tt>Movable</tt> object taking its coordinates and size as parameters.
	 * 
	 * @param i the initial position, as a Coordinate object 
	 * @param j the size, as a Coordinate object whose x means width and y means height. 
	 */
	public Movable(Coordinates i, Coordinates j)
	{
		super();
		this.position = i;
		this.taille = j;
		this.alive = true;
	}

	/**
	 * This method returns if the movable object is still alive
	 * @return the life status
	 */
	public boolean isAlive()
	{
		return this.alive;
	}

	/**
	 * This method allows to modify the alive status of the movable object
	 * @param alive the new alive status
	 */
	public void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	// FIXME (FIXED) fix the comment 
	/**
	 * This method returns the location of the movable object.
	 * 
	 * @return return the location (Coordinates) of the movable object <br/>
	 * 			0 <= X <= MAX_X<br/>
	 * 			0 <= Y <= MAX_Y<br/>
	 * 			MAX_X and MAX_Y are the size of the screen
	 */
	public Coordinates getPosition()
	{
		return this.position;
	}

	/**
	 * This method allows to modify the location of the movable object.
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

	// FIXME rename method
	/**
	 * This method returns the size of the object.<br/>
	 * 
	 * @return get the size (Coordonnee) of the object.
	 */
	public Coordinates getTaille()
	{
		return this.taille;
	}

	// FIXME rename method
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
		if (this.position.getX() + this.taille.getX() + dx <= this.X
				&& this.position.getY() + this.taille.getX() + dy <= this.Y
				&& this.alive)
		{
			this.position = new Coordinates(this.position.getX() + dx,
					this.position.getY() + dy);
			return true;
		}
		return false;
	}

	@Override
	public String toString()
	{
		return "Movable [alive=" + this.alive + ", position=" + this.position + ", taille=" + this.taille + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}

	// TODO Comment this 2 methods
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.alive ? 1231 : 1237);
		result = prime * result
				+ ((this.position == null) ? 0 : this.position.hashCode());
		result = prime * result
				+ ((this.taille == null) ? 0 : this.taille.hashCode());
		return result;
	}

	// FIXME it is useless to override equals if you do not intend to compare objects
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (!(obj instanceof Movable))
		{
			return false;
		}
		Movable other = (Movable) obj;
		if (this.alive != other.alive)
		{
			return false;
		}
		if (this.position == null)
		{
			if (other.position != null)
			{
				return false;
			}
		}
		else if (!this.position.equals(other.position))
		{
			return false;
		}
		if (this.taille == null)
		{
			if (other.taille != null)
			{
				return false;
			}
		}
		else if (!this.taille.equals(other.taille))
		{
			return false;
		}
		return true;
	}
}
