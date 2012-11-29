package fr.iutvalence.java.projet.spaceinvaders;

import fr.iutvalence.java.projet.spaceinvaders.enumerations.Type;

public class FiringMovable extends Movable
{
	/**
	 * Set the direction of the shoot when FiringMovable fire.
	 */
	private int shootDirection;

	/**
	 * This constructor creates a new living <tt>Movable</tt> object taking its coordinates and size as parameters.<br/>
	 * Do not use this constructor by yourself, its used only by fire method for create shoot.
	 * 
	 * @param i
	 *            the initial position, as a Coordinate object
	 * @param j
	 *            the size, as a Coordinate object whose x means width and y means height.
	 * @param direction
	 *            the direction of the movable object (shoot). For non shoot it sets to 0. for others negative is for
	 *            down shoot and positive otherwise.
	 * @param t The type of the Movable element. It cannot be Type.Bunker
	 * @throws NegativeSizeException
	 *             Throws Exception when the size coordinates are negative
	 */
	public FiringMovable(Coordinates i, Coordinates j,  Type t, int direction, int firingDirection) throws NegativeSizeException
	{
		super(i, j, t, direction);
		this.shootDirection = firingDirection;
	}

	/**
	 * Method to create new movable object who moves by itself in given direction [UP|DOWN]
	 * 
	 * @param direction
	 *            The direction of the shoot (if it negative the direction is down, up otherwise). If it's equal to 0
	 *            The function return null.
	 * @param size
	 *            This defined the size of the movable object to create
	 * @return Return new shoot (Movable) or null if it failed.
	 * @throws NegativeSizeException
	 *             If the size given is negative
	 */
	/**
	 * Method to create new movable object who moves by itself in given direction [UP|DOWN]
	 * 
	 * @param size
	 *            This defined the size of the movable object to create
	 * @return Return new shoot (Movable) or null if it failed.
	 * @throws NegativeSizeException
	 *             If the size given is negative
	 */
	public synchronized Movable fire(Coordinates size) throws NegativeSizeException
	{
		if (shootDirection != 0)
		{
			Coordinates coorShoot = null;

			if (shootDirection < 0)
			{
				coorShoot = new Coordinates(
						(this.getArea().getPosition().getX() + (this.getArea().getSize().getX() / 2))
								- (size.getX() / 2), (this.getArea().getPosition().getY() - size.getY()));
			}
			else if (shootDirection > 0)
			{
				coorShoot = new Coordinates(
						(this.getArea().getPosition().getX() + (this.getArea().getSize().getX()) / 2)
								- (size.getX() / 2), (this.getArea().getPosition().getY() + this.getArea().getSize()
								.getX()));
			}
			return new Movable(coorShoot, size, Type.SHOOT, this.shootDirection);
		}
		return null;
	}
	
	
	/**
	 * @return the direction
	 */
	public int getShootDirection()
	{
		return shootDirection;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(int direction)
	{
		this.shootDirection = direction;
	}

	@Override
	public String toString()
	{
		return "FiringMovable [alive=" + this.isAlive() + ", position=" + this.getArea().getPosition() + ", taille=" + this.getArea().getSize() + " direction=" + this.shootDirection + " type=" + this.getType() + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$//$NON-NLS-4$"
	}

}
