package fr.iutvalence.java.projet.spaceinvaders;

// FIXME what about grid bounds (and the respect of them during a move) 
/**
 * This class defines a movable object, that can move on a 2D grid and so being killed by others.
 * 
 * A movable object is characterized by its size and position on the grid and also its status [alive | dead].
 * 
 * @author Gallet Guyon
 */
public class Movable
{ 
	/**
	 * Status indicating if the movable object is still alive (a dead movable can no longer move).
	 */
	private boolean alive;

	/**
	 * The position of the movable object on the 2D grid
	 */
	private Coordinates position;

	/**
	 * The size of the movable on the grid.<br/>
	 * The size is defined by two values as a Coordinate object whose x means width and y means height.
	 */
	private Coordinates size;
	
	
	// FIXME comments have to be related to only one declaration
	/**
	 * The size by default of the movable on the grid.<br/>
	 * The size is defined by two values (width,height)
	 */
	// FIXME if it is a constant, it must be defined as a real one. Else, initialize it in a constructor
	private final int height = 10;
	
	// FIXME if it is a constant, it must be defined as a real one. Else, initialize it in a constructor
	private final int width = 10;
	
	/**
	 * This constructor creates a new living <tt>Movable</tt> object taking its coordinates.<br/>
	 * Size is set by the default couple of (10,10)
	 * 
	 * @param i the initial position, as a Coordinate object  
	 */
	public Movable(Coordinates i)
	{
		super();
		this.position = i;
		this.size = new Coordinates(this.width,this.height);
		this.alive = true;
	}
	
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
		this.size = j;
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

	/**
	 * This method returns the location of the movable object.
	 * 
	 * @return return the location (Coordinates) of the movable object <br/>
	 */
	public Coordinates getPosition()
	{
		return this.position;
	}

	/**
	 * This method allows to modify the location of the movable object.
	 * Setting position make the object move between<br/>
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
	public Coordinates getSize()
	{
		return this.size;
	}

	/**
	 * This method sets the size of the element on the screen
	 * @param taille the size of the element
	 */
	public void setSize(final Coordinates taille)
	{
		this.size = taille;
	}

	/**
	 * The move method changes the position of the object (the size is unchanged).<br/>
	 * It translates the coordinates by deltas given as x and y.<br/>
	 * 
	 * @param dx new coordinate relative on x axis
	 * @param dy new coordinate relative on y axis
	 */
	public void move(int dx, int dy)
	{
		if(this.alive)
		{
			this.position = new Coordinates(this.position.getX() + dx,
											this.position.getY() + dy);
		}
	}

	@Override
	public String toString()
	{
		return "Movable [alive=" + this.alive + ", position=" + this.position + ", taille=" + this.size + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
}
