/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.util.Arrays;

import fr.iutvalence.java.projet.unused.Monster;
import fr.iutvalence.java.projet.unused.Tank;

/**
 * A space invader game.<br/>
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
	// FIXME why not rename it just "monsters" ?
	private Movable[] tabMonster;

	/**
	 * Table of all tanks' instance variable
	 */
	// FIXME why not rename it just "tanks" ?
	private Movable[] tabTank;

	//************* Constant *************//
	/**
	 * It defines the number of monsters you have in tabMonster by default,
	 * if it's not set in constructor. 
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int nbMonsterDefault = 20;

	/**
	 * It defines the number of tank you have in tabTank by default,
	 * if it's not set in constructor.
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int nbTankDefault = 1;
	
	/**
	 * It defines the maximum (default) of X axis,
	 * if it's not set in constructor.
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int XGrid = 300;
	
	/**
	 * It defines the maximum (default) of Y axis,
	 * if it's not set in constructor.
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int YGrid = 300;
	
	/**
	 * Default delta between 2 monsters
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int defaultDelta = 2;
	
	/**
	 * Default size of element (e.g. Doc Movable)
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int defaultSize = 10;

	
	//************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the number of tanks to 1, the number of monsters to 20,
	 * the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructor 
	 */
	public SpaceInvaders()
	{
		this.work = true;
		this.maxSize = new Coordinates(this.XGrid, this.YGrid);
		initTab(this.nbMonsterDefault, this.nbTankDefault);
		
		// FIXME make the call to start outside of the constructor. A constructor must return as soon as possible
		start();
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

		// FIXME make the call to start outside of the constructor. A constructor must return as soon as possible
		start();
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
	}

	//************************** Methods **************************//
	
	
	// FIXME write a comment
	public void start()
	{
		try
		{
			iteration();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Initialize the table of movable elements.<br/>
	 * Algorithm for set-up the monsters' position on the grid, and also Tank.
	 * It positions the tank of the middle of the grid and the monster
	 * from the top left to the bottom right (like writing in English or French) 
	 * 
	 * @param nbMonstre Set the number of monster (The maximum is set (to my mind) to 250, after I'm offload one's responsibilities) 
	 * @param nbTank Set the number of tank (not implemented yet, so the maximum is 1)
	 */
	// FIXME rename parameters
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
	// FIXME why returning InterruptedException ?
	private void iteration() throws InterruptedException 
	{
		// TODO remove Debug message
		System.out.println("Begin");
		//if the player lose, work = false.
		while(work)
		{
			// TODO remove Debug message
			System.out.println("Boucle");
			
			Thread.sleep(1000); // Clock
			
			// need same resources, so sync?
			// TODO test collision (thread ? every time check)
			testCollision();
			// TODO move enemy (thread ? no-yes, clock mechanism)
			moveTab(this.tabMonster);
		}
		// TODO remove Debug message
		System.out.println("Don't work anymore ;)");
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
	private void moveTab(Movable tab[])
	{
		// Variable
		int nb = tab.length;
		int i = 0;
		
		//Down
		//Left
		//Down
		//Right
		//Down
		
		//Right
		for(i=0; i < nb; i++)
		{
			tab[i].move(-10, 0);
		}
		//Wait
		//Down
		for(i=0; i < nb; i++)
		{
			tab[i].move(0, -10);
		}
		//Wait
		//Left
		for(i=0; i < nb; i++)
		{
			tab[i].move(10, 0);
		}
		//Wait
		//Down
		for(i=0; i < nb; i++)
		{
			tab[i].move(10, 0);
		}
		//Wait
	}
	
	/**
	 * This procedure test if there is any collisions in all table declared.<br/>
	 * Collision are tested between each table and not between elements of the same table.<br/>
	 * If a Tank is touched by an enemy, work is set to false and the game is stopped by the main iteration.
	 */
	private void testCollision()
	{
		// Test collision of all tables declared
		// Variable
		int i=0;
		// Coordinates for monsters
		int x1,y1,x2,y2;
		// Coordinates for tank
		int tx1,tx2,ty1,ty2;
		
		// Initialize tank's coordinates
		tx1 = this.tabTank[0].getPosition().getX();
		ty1 = this.tabTank[0].getPosition().getY();
		tx2 = this.tabTank[0].getSize().getX() + tx1;
		ty2 = this.tabTank[0].getSize().getY() + ty1;
		
		
		//	Area :
		//
		//
		//	Y
		//	^
		//	|
		//	|
		//	|
		//	|	 (x1,y2)__________(x2,y2)
		//	|		|				 |
		//	|		|				 |
		//	|		|				 |
		//	|		|				 |
		//	|		|				 |
		//	|		|				 |
		//	|		|				 |
		//	|	 (x1,y1)__________(x2,y1)
		//	|
		//	|
		//	0-------------------------------------------------> X
		
		for(i=0; i < this.tabMonster.length;i++)
		{
			// Initialize coordinates
			x1 = this.tabMonster[i].getPosition().getX();
			y1 = this.tabMonster[i].getPosition().getY();
			x2 = this.tabMonster[i].getSize().getX() + x1;
			y2 = this.tabMonster[i].getSize().getY() + y1;
			
			// Check if any points of the tank touch enemy
			if(tx1 > x1 && ty1 > y1 && tx1 < x2 && ty1 < y2)
			{
				this.tabTank[0].setAlive(false);
				this.work = false;
			}
			else if(tx2 > x1 && ty2 > y1 && tx2 < x2 && ty2 < y2)
			{
				this.tabTank[0].setAlive(false);
				this.work = false;
			}
			else if(tx1 > x1 && ty2 > y1 && tx1 < x2 && ty2 < y2)
			{
				this.tabTank[0].setAlive(false);
				this.work = false;
			}
			else if(tx2 > x1 && ty1 > y1 && tx2 < x2 && ty1 < y2)
			{
				this.tabTank[0].setAlive(false);
				this.work = false;
			}				
		}
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
