/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.util.Arrays;

/**
 * A space invader game.<br/>
 * 
 * @author Gallet Guyon
 */
public class SpaceInvaders
{
	// ************* Constant *************//
	/**
	 * It defines the number of monsters you have in tabMonster by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_MONSTERS_AMOUNT = 20;

	/**
	 * It defines the number of tank you have in tabTank by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_TANKS_AMOUNT = 1;

	/**
	 * It defines the maximum (default) of X axis, if it's not set in constructor.
	 */
	private static final int X_GRID = 300;

	/**
	 * It defines the maximum (default) of Y axis, if it's not set in constructor.
	 */
	private static final int Y_GRID = 300;

	/**
	 * Default delta between 2 monsters
	 */
	private static final int DEFAULT_DELTA = 2;

	/**
	 * Default size of element (e.g. Doc Movable)
	 */
	private static final int DEFAULT_SIZE = 10;

	// ************* Variable *************//
	/**
	 * Boolean to know if the game is finished
	 */
	private Boolean work;

	/**
	 * The maximum size of the area
	 */
	private final Coordinates maxSize;

	/**
	 * Array containing all monsters
	 */
	private Movable[] monsters;

	/**
	 * Array containing all tanks.
	 */
	private Movable[] tanks;
	
	/**
	 * Array containing all shoots.
	 */
	private Movable[] shoots;

	// ************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the number of tanks to 1, the number of monsters to 20, the X axis to
	 * 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructor
	 */
	public SpaceInvaders()
	{
		this.work = new Boolean(true);
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
		initTab(DEFAULT_MONSTERS_AMOUNT, DEFAULT_TANKS_AMOUNT);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor sets the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors
	 * 
	 * @param nbMonster
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 */
	public SpaceInvaders(int nbMonster, int nbTank)
	{
		this.work = new Boolean(true);
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
		initTab(nbMonster, nbTank);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor no default value.
	 * 
	 * @param nbMonster
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 * @param Max
	 *            Set the Max point of the grid (Coordinates) 
	 */
	public SpaceInvaders(int nbMonster, int nbTank, Coordinates Max)
	{
		this.work = new Boolean(true);
		this.maxSize = Max;
		initTab(nbMonster, nbTank);
	}

	// ************************** Methods **************************//

	// FIXME write a first version of the game like an automata (no threading) (to discuss)
	/**
	 * This method begins the game. It's the only entry point.
	 */
	public void start()
	{
		MonstersBehaviorThread monsters = new MonstersBehaviorThread("Monsters", 1000, this.monsters, this.tanks, this.shoots, this.work, this.maxSize);
		monsters.start();
		try
		{
			monsters.join();
		}
		catch (InterruptedException e)
		{
			// FIXME (QUEST) What I have to write here?
			// FIXME (ANSWER) nothing special (to discuss)
			e.printStackTrace();
		}
	}

	/**
	 * Initialize the table of movable elements.<br/>
	 * Algorithm for set-up the monsters' position on the grid, and also Tank. It positions the tank of the middle of
	 * the grid and the monster from the top left to the bottom right (like writing in English or French)
	 * 
	 * @param nbMonsters
	 *            Set the number of monster (The maximum is set (to my mind) to 250, after I'm offload one's
	 *            responsibilities)
	 * @param nbTanks
	 *            Set the number of tank (not implemented yet, so the maximum is 1 and minimum too ;-))
	 */
	private void initTab(int nbMonsters, int nbTanks)
	{
		// TODO improve with tank
		
		// local variable
		Coordinates tank_position = new Coordinates((this.maxSize.getX() / 2) - (DEFAULT_SIZE / 2),0);
		Coordinates monster_position = new Coordinates(DEFAULT_DELTA, this.maxSize.getY() - (DEFAULT_SIZE + DEFAULT_DELTA));
		int i = 0;
		// Allocations
		this.monsters = new Movable[nbMonsters];
		this.tanks = new Movable[nbTanks];
		this.shoots = new Movable[nbTanks + nbMonsters];

		// Set-up Tabs
		try
		{
			this.tanks[0] = new Movable(tank_position);
		}
		catch (NegativeSizeException e1)
		{
			System.out.println(e1);
		}

		while (i < nbMonsters)
		{
			while (i < nbMonsters && monster_position.getX() + (DEFAULT_DELTA + DEFAULT_SIZE) <= this.maxSize.getX())
			{
				try
				{
					this.monsters[i] = new Movable(monster_position);
				}
				catch (NegativeSizeException e)
				{
					System.out.println(e);
				}
				monster_position = new Coordinates(monster_position.getX() + (DEFAULT_DELTA + DEFAULT_SIZE),
						monster_position.getY());
				i = i + 1;
			}
			monster_position = new Coordinates(DEFAULT_DELTA, monster_position.getY() - (DEFAULT_DELTA + DEFAULT_SIZE));
		}
		// Check?
		//testCollision();
	}
	
	@Override
	public String toString()
	{
		return "SpaceInvaders [tabMonster=" + Arrays.toString(this.monsters) + "tabTank="
				+ Arrays.toString(this.tanks) + "]";
	}
}
