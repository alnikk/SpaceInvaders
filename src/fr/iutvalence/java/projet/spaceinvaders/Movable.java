package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This class defines a movable object, that can move on a 2D grid and so being killed by others.<br/>
 * A movable object is characterized by its size and position on the grid and also its status [alive | dead]. Once a
 * movable object is touched by another one, it's killed. The bounds of the 2D grid is defined in ....(SpaceInvaders for
 * the moment), and movable objects can't move over without exception (not now).
 * 
 * @author Gallet Guyon
 */
public class Movable extends Element
{
	/**
	 * Status indicating if the movable object is still alive (a dead movable can no longer move).
	 */
	private boolean alive;

	/**
	 * The default height of the movable on the grid.<br/>
	 */
	private static final int HEIGHT = 10;

	/**
	 * The default width of the movable on the grid.<br/>
	 */
	private static final int WIDTH = 10;

	// *************** Constructor *****************
	// TODO Exception move when it go over.
	// to do that :
	// TODO Move XGridMax and YGridMax
	// but this is already in SpaceInvaders class
	// Create Grid Class?
	// TODO throw Exception in Space invaders class, with XGridMax and YGridMax  

	/**
	 * This constructor creates a new living <tt>Movable</tt> object taking its coordinates.<br/>
	 * Size is set by the default couple of (10,10)
	 * 
	 * @param i
	 *            the initial position, as a Coordinate object
	 * @throws NegativeCoordinatesException
	 *             Throws Exception when the size coordinates are negative
	 */
	public Movable(Coordinates i) throws NegativeCoordinatesException
	{
		super(new BoundingBox(i, new Coordinates(WIDTH, HEIGHT)));
		this.alive = true;
	}

	/**
	 * This constructor creates a new living <tt>Movable</tt> object taking its coordinates and size as parameters.
	 * 
	 * @param i
	 *            the initial position, as a Coordinate object
	 * @param j
	 *            the size, as a Coordinate object whose x means width and y means height.
	 * @throws NegativeCoordinatesException
	 *             Throws Exception when the size coordinates are negative
	 */
	public Movable(Coordinates i, Coordinates j) throws NegativeCoordinatesException
	{
		super(new BoundingBox(i, j));
		this.alive = true;
	}

	// *************** Method *****************

	/**
	 * The move method changes the position of the object (the size is unchanged).<br/>
	 * It translates the coordinates by deltas given as x and y.<br/>
	 * 
	 * @param dx
	 *            new coordinate relative on x axis
	 * @param dy
	 *            new coordinate relative on y axis
	 * @throws NegativeCoordinatesException
	 *             If position is negative.
	 */
	public synchronized void move(int dx, int dy) throws NegativeCoordinatesException
	{
		if (this.alive)
		{
			getArea().translate(new Coordinates(dx, dy));
		}
	}

	/**
	 * Method to move element to specific coordinates on the 2D grid.
	 * 
	 * @param x
	 *            the X coordinates to move the element.
	 * @param y
	 *            the Y coordinates to move the element.
	 * @throws NegativeCoordinatesException
	 *             If position is negative.
	 */
	public synchronized void moveTo(int x, int y) throws NegativeCoordinatesException
	{
		if (this.alive)
		{
			getArea().moveTo(new Coordinates(x, y));
		}
	}

	// *************** Getters and Setters *****************

	/**
	 * This method returns if the movable object is still alive
	 * 
	 * @return the life status
	 */
	public boolean isAlive()
	{
		return this.alive;
	}

	/**
	 * This method allows to modify the alive status of the movable object
	 * 
	 * @param alive
	 *            the new alive status
	 */
	public synchronized void setAlive(boolean alive)
	{
		this.alive = alive;
	}

	@Override
	public String toString()
	{
		return "Movable [alive=" + this.alive + ", position=" + this.getArea().getPosition() + ", taille=" + this.getArea().getSize() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$
	}
}
