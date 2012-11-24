/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import fr.iutvalence.java.projet.spaceinvaders.enumerations.Etat;
import fr.iutvalence.java.projet.spaceinvaders.exceptions.NegativeSizeException;
import fr.iutvalence.java.projet.spaceinvaders.exceptions.OutOfGridException;
import fr.iutvalence.java.projet.spaceinvaders.interfaces.Display;

/**
 * This is abstract class who regroup all tools' methods and variable. This Generalize all SpaceInvadersMxVx games.
 * 
 * @author Gallet Guyon
 */
public abstract class SpaceInvaders
{
	// ************* Constant *************//

	// [[[[[[[ Grid ]]]]]]]
	/**
	 * It defines the maximum (default) of X axis, if it's not set in constructor.
	 */
	private static final int X_GRID = 100;

	/**
	 * It defines the maximum (default) of Y axis, if it's not set in constructor.
	 */
	private static final int Y_GRID = 100;

	// [[[[[[[ Movable ]]]]]]]
	/**
	 * Default size of element
	 * @see Movable
	 */
	private static final Coordinates DEFAULT_SIZE = new Coordinates(5, 5);

	/**
	 * Default delta between 2 monsters
	 */
	private static final int DEFAULT_DELTA = 2;

	/**
	 * This constant defines the step on the grid of a move
	 */
	private static final Coordinates DEFAULT_MOVE = new Coordinates(5, 5);

	// [[[[[[[ Shoots ]]]]]]]
	/**
	 * This constant defines the step on the grid of a move
	 */
	private static final Coordinates DEFAULT_MOVE_SHOOTS = new Coordinates(0, 1);

	/**
	 * This constant defines the size of shoot
	 */
	private static final Coordinates DEFAULT_SIZE_SHOOT = new Coordinates(2, 2);

	// [[[[[[[ Numerous ]]]]]]]
	/**
	 * It defines the number of monsters you have in tabMonster by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_MONSTERS_AMOUNT = 10;

	/**
	 * It defines the number of tank you have in tabTank by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_TANKS_AMOUNT = 1;

	// [[[[[[[ Time ]]]]]]]
	/**
	 * This constant defines the default sleep time between each move of Invaders
	 */
	private static final int DEFAULT_SLEEP_TIME = 800;
	
	/**
	 * This is the minimum time between each move of Invaders
	 */
	private static final int DEFAULT_TIME_DIFFICULTY = 300;

	/**
	 * This constant is the default acceleration (Not used for now)
	 */
	private static final int DEFAULT_ACCELERATION = 2;

	// [[[[[[[ Grid ]]]]]]]
	/**
	 * The maximum size of the area
	 */
	protected final Coordinates maxSize;

	// [[[[[[[ Movable ]]]]]]]
	/**
	 * Size of Movable (e.g. Doc Movable)
	 */
	private Coordinates sizeMovable;

	/**
	 * Delta between 2 Invaders
	 */
	private int delta;

	/**
	 * This constant defines the step on the grid of a move
	 */
	protected Coordinates coorMove;

	// [[[[[[[ Shoots ]]]]]]]
	/**
	 * Defines the step on the grid of a move
	 */
	protected Coordinates moveShoots;

	/**
	 * Defines the size of shoot
	 */
	protected Coordinates sizeShoots;

	// [[[[[[[ Numerous ]]]]]]]
	/**
	 * It defines the number of monsters you have in tabMonster.
	 */
	protected int monstersAmount;

	/**
	 * It defines the number of tank you have in tabTank.
	 */
	protected int tanksAmount;

	// [[[[[[[ Time ]]]]]]]
	/**
	 * This variable is used to wait sleepTime millisecond between each loop
	 */
	protected int sleepTime;
	
	/**
	 * This is the minimum time between each move of Invaders
	 */
	protected int timeDifficulty = 300;

	// TODO acceleration
	/**
	 * Not implemented yet It uses to accelerate sleepTime when invaders are less numerous
	 */
	@SuppressWarnings("unused")
	private int acceleration;

	// [[[[[[[ Table ]]]]]]]
	/**
	 * Array containing all monsters
	 */
	protected Movable[] monsters;

	/**
	 * Array containing all tanks.
	 */
	protected Movable[] tanks;

	/**
	 * Array containing all shoots.
	 */
	protected Movable[] shoots;

	// [[[[[[[ Others ]]]]]]]
	/**
	 * This variable is the state of invaders
	 */
	protected Etat etat;

	/**
	 * Boolean to know if the game is finished
	 */
	protected boolean work;
	
	/**
	 * 
	 */
	protected Display display;

	// ************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all to default value. If you don't want to use this default
	 * characteristic use another constructor
	 * @param d The display object to use.
	 */
	public SpaceInvaders(Display d)
	{
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = DEFAULT_MONSTERS_AMOUNT;
		this.tanksAmount = DEFAULT_TANKS_AMOUNT;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.acceleration = DEFAULT_ACCELERATION;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor sets the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors
	 * 
	 * @param nbMonsters
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTanks
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 * @param d The display object to use.
	 */
	public SpaceInvaders(int nbMonsters, int nbTanks, Display d)
	{
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = nbMonsters;
		this.tanksAmount = nbTanks;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.acceleration = DEFAULT_ACCELERATION;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor uses default value of acceleration
	 * 
	 * @param nbMonsters
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTanks
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 * @param max
	 *            Set the Max point of the grid (Coordinates)
	 * @param d The display object to use.
	 */
	public SpaceInvaders(int nbMonsters, int nbTanks, Coordinates max, Display d)
	{
		this.maxSize = max;
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = nbMonsters;
		this.tanksAmount = nbTanks;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.acceleration = DEFAULT_ACCELERATION;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor no default value.
	 * 
	 * @param nbMonsters
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTanks
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 * @param max
	 *            Set the Max point of the grid (Coordinates)
	 * @param sleepTime
	 *            Set the time between each move of monster (in milliseconds)
	 * @param d The display object to use.
	 */
	public SpaceInvaders(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, Display d)
	{
		this.maxSize = max;
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = nbMonsters;
		this.tanksAmount = nbTanks;
		this.sleepTime = sleepTime;
		this.acceleration = DEFAULT_ACCELERATION;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor uses no default value.
	 * 
	 * @param nbMonsters
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTanks
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 * @param max
	 *            Set the Max point of the grid (Coordinates)
	 * @param sleepTime
	 *            Set the time between each move of monster (in milliseconds)
	 * @param acceleration
	 *            Set the acceleration of Invaders. (not uses for now)
	 * @param d The display object to use.
	 */
	public SpaceInvaders(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, int acceleration, Display d)
	{
		this.maxSize = max;
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = nbMonsters;
		this.tanksAmount = nbTanks;
		this.sleepTime = sleepTime;
		this.acceleration = acceleration;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		initTab(this.monstersAmount, this.tanksAmount);
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
	 *            Set the number of tank [1-4]
	 */
	private void initTab(int nbMonsters, int nbTanks)
	{
		// local variable
		int i;

		// Allocations
		this.monsters = new Movable[nbMonsters];
		this.tanks = new Movable[nbTanks];
		this.shoots = new Movable[nbTanks + nbMonsters];

		// Set-up tank table
		for (i = 0; i < nbTanks; i++)
		{
			try
			{
				this.tanks[i] = new Movable(new Coordinates(((this.maxSize.getX() / 4) - (this.sizeMovable.getX() / 2))
						* i, 0), new Coordinates(this.sizeMovable.getX(), this.sizeMovable.getY()));
			}
			catch (NegativeSizeException e1)
			{
				System.out.println(e1);
			}
		}
		// Define Invaders position
		this.etat = Etat.LEFT_UP;

		// Set-up Invaders table
		Coordinates monster_position = new Coordinates(this.delta, this.maxSize.getY()
				- (this.sizeMovable.getY() + this.delta));
		for (i = 0; i < nbMonsters; i++)
		{
			if (monster_position.getX() + (this.delta + this.sizeMovable.getX()) <= this.maxSize.getX())
			{
				try
				{
					this.monsters[i] = new Movable(monster_position, new Coordinates(this.sizeMovable.getX(),
							this.sizeMovable.getY()));
				}
				catch (NegativeSizeException e)
				{
					System.out.println(e);
				}
				monster_position = new Coordinates(monster_position.getX() + (this.delta + this.sizeMovable.getX()),
						monster_position.getY());
			}
			else
				monster_position = new Coordinates(this.delta, monster_position.getY()
						- (this.delta + this.sizeMovable.getY()));
		}
		testCollision();
	}

	/**
	 * This method allows to move all instances in table of delta coordinates.
	 * 
	 * @param delta
	 *            The delta coordinates to move Invaders
	 * @param tableToMove
	 *            The table to move
	 * @throws OutOfGridException
	 *             This method can return OutOfgridException if monsters does'nt be anymore in the grid.
	 */
	protected void moveTab(Coordinates delta, Movable[] tableToMove) throws OutOfGridException
	{
		int i;

		// Test if all table is movable
		for (i = 0; i < tableToMove.length; i++)
		{
			if (tableToMove[i] != null && tableToMove[i].isAlive())
			{
				if (tableToMove[i].getArea().getPosition().getX() + tableToMove[i].getArea().getSize().getX()
						+ delta.getX() > this.maxSize.getX()
						|| tableToMove[i].getArea().getPosition().getY() + tableToMove[i].getArea().getSize().getY()
								+ delta.getY() > this.maxSize.getY()
						|| tableToMove[i].getArea().getPosition().getX() + delta.getX() < 0
						|| tableToMove[i].getArea().getPosition().getY() + delta.getY() < 0)
				{
					throw new OutOfGridException(tableToMove[i]);
				}
			}
		}

		// Next we move table
		for (i = 0; i < tableToMove.length; i++)
		{
			if (tableToMove[i] != null && tableToMove[i].isAlive())
			{
				try
				{
					tableToMove[i].move(delta);
				}
				catch (NegativeSizeException e)
				{
					System.out.println(e.getNegativeCoordinatesException());
					System.out.println(tableToMove[i] + " " + delta);
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Search an empty cell in table given in argument.
	 * 
	 * @param table
	 *            Table to search empty cell
	 * @return return the index of empty cell in table. if it equals to -1 it didn't find
	 */
	private int searchEmptyCellFromMovableTable(Movable table[])
	{
		int i;

		for (i = 0; i < table.length; i++)
		{
			if (table[i] != null)
			{
				if (!table[i].isAlive())
					return i;
			}
			else
				return i;
		}
		return -1;
	}

	/**
	 * This method count the number of alive Movable.
	 * 
	 * @param table
	 *            The table to count alive Movable.
	 * @return The number of alive Invaders.
	 */
	int countAlive(Movable[] table)
	{
		int nbAlive = 0, i;

		for (i = 0; i < table.length; i++)
		{
			if (table[i] != null && table[i].isAlive())
				nbAlive++;
		}
		return nbAlive;
	}

	/**
	 * Make Movable given in arguments shoot
	 * 
	 * @param movable
	 *            Invaders who have to shoot
	 * @param direction
	 *            The direction you want to shoot
	 */
	protected void shootFrom(Movable movable, int direction)
	{
		int index;

		if (movable != null)
		{
			index = searchEmptyCellFromMovableTable(this.shoots);
			if (index != -1)
			{
				try
				{
					this.shoots[index] = movable.fire(direction, this.sizeShoots);
				}
				catch (NegativeSizeException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * This method tests if there is any collisions in all table declared.<br/>
	 * Collision are tested between each table and not between elements of the same table.<br/>
	 * If a Tank is touched by an enemy, work is set to false and the game is stopped by the main iteration.
	 */
	protected void testCollision()
	{
		int i, j;

		for (i = 0; i < this.tanksAmount; i++)
		{
			if (this.tanks[i] != null && this.tanks[i].isAlive())
			{
				for (j = 0; j < this.monstersAmount; j++)
				{
					if (this.shoots[i] != null && this.monsters[j].isAlive())
					{
						if (this.tanks[i].overlapping(this.monsters[j]) != null)
						{
							this.tanks[i].setAlive(false);
							this.monsters[j].setAlive(false);
						}
					}
				}

				for (j = 0; j < (this.monstersAmount + this.tanksAmount); j++)
				{
					if (this.shoots[j] != null && this.shoots[j].isAlive())
					{
						if (this.tanks[i].overlapping(this.shoots[j]) != null)
						{
							this.tanks[i].setAlive(false);
							this.shoots[j].setAlive(false);
						}
					}
				}
			}
		}

		for (i = 0; i < this.monstersAmount; i++)
		{
			if (this.monsters[i] != null && this.monsters[i].isAlive())
			{
				for (j = 0; j < (this.monstersAmount + this.tanksAmount); j++)
				{
					if (this.shoots[j] != null && this.shoots[j].isAlive())
					{
						if (this.monsters[i].overlapping(this.shoots[j]) != null)
						{
							this.monsters[i].setAlive(false);
							this.shoots[j].setAlive(false);
						}
					}
				}
			}
		}
	}

	/**
	 * Begin a game
	 */
	public abstract void run();

	// TODO Debug
	/**
	 * Kill one instance of movable object
	 * 
	 * @param tabToKill
	 *            Table where kill instance
	 */
	protected void kill(Movable[] tabToKill)
	{
		int i = 0, nbMonsters = tabToKill.length;

		while (i < nbMonsters && (!tabToKill[i].isAlive()))
			i++;
		tabToKill[i].setAlive(false);
	}
}