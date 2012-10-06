/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.util.Arrays;

/**
 * The main parts of the game.<br/>
 * It provides the initializations and all objects are referenced in it. 
 * 
 * @author Gallet Guyon
 */
public class SpaceInvaders
{
	//************* Variable *************//
	/**
	 * Boolean to know if the game is finished
	 */
	private boolean work;
	
	/**
	 * The maximum size of the area
	 */
	private final Coordinates maxSize;

	//************* Tableau *************//
	/**
	 * Table of all monsters' instance variable
	 */
	private Monster[] tabMonster;

	/**
	 * Table of all tanks' instance variable
	 */
	private Tank[] tabTank;

	//************* Constant *************//
	/**
	 * It defines the number of monster you have in tabMonster by default,
	 * if it's not set in constructor. 
	 */
	private final int nbMonsterDefault = 20;

	/**
	 * It defines the number of tank you have in tabTank by default,
	 * if it's not set in constructor.
	 */
	private final int nbTankDefault = 1;
	
	/**
	 * It defines the maximum (default) of X axis,
	 * if it's not set in constructor.
	 */
	private final int XGrid = 300;
	
	/**
	 * It defines the maximum (default) of Y axis,
	 * if it's not set in constructor.
	 */
	private final int YGrid = 300;
	
	/**
	 * Default delta between 2 monsters
	 */
	private final int defaultDelta = 2;
	
	/**
	 * Default size of element (e.g. Doc Movable)
	 */
	private final int defaultSize = 10;

	
	//************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the number of tank to 1, the number of monster to 20,
	 * the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors 
	 */
	public SpaceInvaders()
	{
		this.work = true;
		this.maxSize = new Coordinates(this.XGrid, this.YGrid);
		initTab(this.nbMonsterDefault, this.nbTankDefault);
		iteration();
	}
	
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors
	 * 
	 * @param nbMonster Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 */
	public SpaceInvaders(int nbMonster, int nbTank)
	{
		this.work = true;
		this.maxSize = new Coordinates(this.XGrid, this.YGrid);
		initTab(nbMonster, nbTank);
		iteration();
	}
	
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It uses no default value.
	 * 
	 * @param nbMonster Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank Set the number of Tank you want instantiate (with default constructors, it sets to 20)
 	 * @param nbTank Set the X axis (with default constructors, it sets to 300)
 	 * @param nbTank Set the Y axis (with default constructors, it sets to 300)
	 */
	public SpaceInvaders(int nbMonster, int nbTank, Coordinates Max)
	{
		this.work = true;
		this.maxSize = Max;
		initTab(nbMonster, nbTank);
		iteration();
	}

	//************************** Methods **************************//
	
	/**
	 * Initialize the table of movable elements.<br/>
	 * Algorithm for set-up the monsters' position on the grid, and also Tank.
	 * 
	 * @param nbMonstre Set the number of monster (The maximum is set (to my mind) to 250, after I'm offload one's responsibilities) 
	 * @param nbTank Set the number of tank (not implemented yet, so the maximum is 1)
	 */
	private void initTab(int nbMonstre, int nbTank)
	{
		// local variable
		Coordinates tank_position = new Coordinates((this.maxSize.getX() / 2) 
														- (this.defaultSize / 2), 
													(this.maxSize.getY() / 2)
														- (this.defaultSize / 2));
		Coordinates monster_position = new Coordinates(this.defaultDelta, 
														this.maxSize.getY() - (this.defaultSize + this.defaultDelta));
		int i = 0;
		// Allocations
		this.tabMonster = new Monster[nbMonstre];
		this.tabTank = new Tank[nbTank];

		// Set-up Tabs
		this.tabTank[0] = new Tank(tank_position);

		while(i < nbMonstre)
		{
			while(i < nbMonstre && 
					monster_position.getX() + (this.defaultDelta + this.defaultSize) <= this.maxSize.getX())
			{
				this.tabMonster[i] = new Monster(monster_position);
				monster_position = new Coordinates(monster_position.getX() + (this.defaultDelta + this.defaultSize),
													monster_position.getY());
				i = i + 1;
			}				
			monster_position = new Coordinates(this.defaultDelta,
												monster_position.getY() - (this.defaultDelta + this.defaultSize));
		}
		
	}
	
	/**
	 * Main iteration.<br/>
	 * This function call :
	 * <ul>
	 * 		<li>moveTab</li>
	 * 		<li>testCollision</li>
	 * </ul>
	 */
	private void iteration() 
	{
		//if the player lose, work = false.
		while(work)
		{
			// need same resources, so sync?
			// TODO move enemy (thread ?)
			moveTab(this.tabMonster);
			// TODO test collision (thread ?)
			testCollision();
		}
	}
	
	/**
	 * Make move down a table of enemy.<br/>
	 * The scheme of the descent is :<br/>
	 * <ul>
	 * 		<li>Right</li>
	 * 		<li>Down</li>
	 * 		<li>Left</li>
	 * 		<li>Down</li>
	 * 		<li>Right</li>
	 * 		<li>Down</li>
	 * 		<li>Etc...</li>
	 * </ul>
	 * 
	 * @param tab The table of enemy to move down
	 */
	private void moveTab(Object tab[])
	{
		// Variable
		int nb = tab.length;
		int i = 0;
		
		while(i < nb)
		{
			//Right
			//Down
			//Left
			//Down
			//Right
			//Down
			//Etc..
		}
	}
	
	/**
	 * This procedure test if there 's any collisions in all table declared.<br/>
	 * Collision are tested between each table and not between elements of the same table.<br/>
	 * If a Tank is touched by an enemy, work is set to false and the game is stopped by the main iteration.
	 */
	private void testCollision()
	{
		//Test collision of all table declared
	}
	
	
	// oldFIXME public methods ?
	// later =), or maybe not -_-...
	

	@Override
	public String toString()
	{
		return "SpaceInvaders [tabMonster=" + Arrays.toString(this.tabMonster)
				+ ", tabTank=" + Arrays.toString(this.tabTank) + "]";
	}
}
