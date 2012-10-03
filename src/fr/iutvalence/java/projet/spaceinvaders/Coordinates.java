package fr.iutvalence.java.projet.spaceinvaders;
/*
 * This class allow you to use couple of to integer
 * as coordinates.
 * 
 * @author Gallet Guyon
 */
public class Coordinates
{	
	// The X coordinate
	private final int x;
	
	// The Y coordinate
	private final int y;
	
	/**
	 * Instantiate new object who brings you coordinated.
	 * 
	 * You can't change the coordinates of the object once it instantiated.<br/>
	 * For that create new one.
	 * 
	 * @param x the X coordinate of the object you create  
	 * @param y the Y coordinate of the object you create
	 */
	public Coordinates(final int x, final int y)
	{
		super();
		this.x = x;
		this.y = y;
	}
	
	/**
	 * This method return the value of the X object's coordinate. 
	 * 
	 * @return Return the X coordinated of the object
	 */
	public int getX()
	{
		return this.x;
	}

	/**
	 * This method return the value of the Y object's coordinate. 
	 * 
	 * @return Return the Y coordinated of the object
	 */
	public int getY()
	{
		return this.y;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Coordonnee [x=" + this.x + ", y=" + this.y + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	/**
	 * ???
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.x;
		result = prime * result + this.y;
		return result;
	}

	/**
	 * Indicates whether some other object is "equal to" this one.<br/>
	 * That is to say, the coordinates have to be the same :<br/>
	 * x1 = x2
	 * y1 = y2
	 * 
	 * @param Coordinates - the reference object with which to compare.
	 * @return true if this object is the same as the obj argument; false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) { //if they two have the same references
			return true;
		}
		if (obj == null) { //if one is null
			return false;
		}
		if (!(obj instanceof Coordinates)) { //if they two haven't the same instance
			return false;
		}
		Coordinates other = (Coordinates) obj; //Cast obj
		if (this.x != other.x) { //if they have differences return false 
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return true; //else return true
	}		
}
