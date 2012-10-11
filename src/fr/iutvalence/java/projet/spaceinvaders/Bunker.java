package fr.iutvalence.java.projet.spaceinvaders;
/**
 * This class allow you to create bunker on the grid.<br/>
 * The bunker protect the tanks when it attacked by enemy. The bunker is destroyable.
 * 
 * @author Gallet Guyon
 */
public class Bunker
{
	/**
	 * Constant for the height and the width of the 2D table <tt>struct</tt>.
	 */
	private final static Coordinates max = new Coordinates(10,20);
	
	/**
	 * This is the main structure of the bunker.<br/>
	 * When in the 2D tab there's true means it's not (yet) destroy.
	 * So the tank can be protected if it is under it. 
	 */
	private final static boolean struct[][] = new boolean[max.getX()][max.getY()];
	
	
	public Bunker()
	{
		
	}
}