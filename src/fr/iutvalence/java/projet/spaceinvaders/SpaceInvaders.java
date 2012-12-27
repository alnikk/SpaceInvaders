/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;
import java.util.Arrays;

import fr.iutvalence.java.projet.spaceinvaders.enumerations.Etat;
import fr.iutvalence.java.projet.spaceinvaders.enumerations.Type;
/**
 * This is abstract class who regroup 
 * all tools' methods and variable. 
 * This Generalize all SpaceInvadersMxVx games.
 * 
 * @author Gallet Guyon
 */
public abstract class SpaceInvaders
{
	// ************* Constant *************//

	// [[[[[[[ Grid ]]]]]]]
	/**
	 * It defines the maximum (default) of X axis, 
	 * if it's not set in constructor.
	 */
	private static final int X_GRID = 100;

	/**
	 * It defines the maximum (default) of Y axis, 
	 * if it's not set in constructor.
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
	 * This sets the spacing between
	 * monsters and the bound at the
	 * Beginning.
	 */
	private static final int DEFAULT_BEGIN_SPACING_MONSTERS = 10;

	/**
	 * This constant defines the step on 
	 * the grid of a move
	 */
	private static final Coordinates DEFAULT_MOVE = new Coordinates(5, 5);
	
	/**
	 * This sets the number of shoots tanks can fire
	 */
	protected static final int DEFAULT_NB_SHOOTS_TANK = 10;

	// [[[[[[[ Shoots ]]]]]]]
	/**
	 * This constant defines the step on 
	 * the grid of a move
	 */
	private static final Coordinates DEFAULT_MOVE_SHOOTS = new Coordinates(0, 2);

	/**
	 * This constant defines the size of shoot
	 */
	private static final Coordinates DEFAULT_SIZE_SHOOT = new Coordinates(1, 5);

	// [[[[[[[ Numerous ]]]]]]]
	/**
	 * It defines the number of monsters you 
	 * have in tabMonster by default, if it's 
	 * not set in constructor.
	 */
	private static final int DEFAULT_MONSTERS_AMOUNT = 39;

	/**
	 * It defines the number of tank you have 
	 * in tabTank by default, if it's not set 
	 * in constructor.
	 */
	private static final int DEFAULT_TANKS_AMOUNT = 1;

	// [[[[[[[ Time ]]]]]]]
	/**
	 * This constant defines the default sleep 
	 * time between each move of Invaders
	 */
	private static final int DEFAULT_SLEEP_TIME = 1000;

	/**
	 * This is the minimum time between each move 
	 * of Invaders
	 */
	private static final int DEFAULT_TIME_DIFFICULTY = 500; 

	/**
	 * This constant is the default acceleration 
	 * (Not used for now)
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
	protected Coordinates sizeMovable;

	/**
	 * Delta between 2 Invaders
	 */
	private int delta;

	/**
	 * This constant defines the step on the grid 
	 * of a move
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
	 * It defines the number of monsters you have
	 * in tabMonster.
	 */
	protected int monstersAmount;

	/**
	 * It defines the number of tank you have in 
	 * tabTank.
	 */
	protected int tanksAmount;

	// [[[[[[[ Time ]]]]]]]
	/**
	 * This variable is used to wait sleepTime 
	 * millisecond between each loop
	 */
	protected int sleepTime;

	/**
	 * This is the minimum time between each 
	 * move of Invaders
	 */
	protected int timeDifficulty;

	// TODO acceleration
	/**
	 * Not implemented yet It uses to accelerate 
	 * sleepTime when invaders are less numerous
	 */
	@SuppressWarnings("unused")
	private int acceleration;

	// [[[[[[[ Table ]]]]]]]

	/**
	 * Array containing all monsters
	 */
	protected Movable[] elements;

	/**
	 * Array containing all monsters
	 */
	//protected Movable[] monsters;

	/**
	 * Array containing all tanks.
	 */
	//protected Movable[] tanks;

	/**
	 * Array containing all shoots.
	 */
	//protected Movable[] shoots;

	// [[[[[[[ Others ]]]]]]]
	
	/**
	 * The name of the player
	 */
	protected String name;
	
	/**
	 * It stores the time at begin of game, for save the score later
	 */
	protected long time; 
	
	/**
	 * This variable is the state of invaders
	 */
	protected Etat etat;

	/**
	 * Boolean to know if the game is finished
	 */
	protected boolean work;

	/**
	 * Interface for controlling display.
	 */
	protected Display display;

	/**
	 * Interface for controlling tank.
	 */
	protected KeyListener listenController;
	
	/**
	 * Interface to save score.
	 */
	protected Score score;

	// ************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all 
	 * to default value. If you don't want to use 
	 * this default characteristic use another constructor
	 * @param name The name of score
	 * @param score The interface of score
	 * @param d The display object to use.
	 */
	public SpaceInvaders(String name, Score score, Display d)
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
		this.name = name;
		this.score = score;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all 
	 * to default value. If you don't want to use 
	 * this default characteristic use another constructor
	 * @param name The name of score
	 * @param score The interface of score
	 * @param d The display object to use.
	 * @param nbMonsters Number of monsters
	 * @param nbTanks Number of Tanks
	 */
	public SpaceInvaders(String name, Score score, Display d, int nbMonsters, int nbTanks)
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
		this.name = name;
		this.score = score;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all 
	 * to default value. If you don't want to use 
	 * this default characteristic use another constructor
	 * @param name The name of score
	 * @param score The interface of score
	 * @param d The display object to use.
	 * @param nbMonsters Number of monsters
	 * @param nbTanks Number of Tanks
	 * @param sizeMax Set the max size of the grid
	 */
	public SpaceInvaders(String name, Score score, Display d, int nbMonsters, int nbTanks, Coordinates sizeMax)
	{
		this.maxSize = sizeMax;
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
		this.name = name;
		this.score = score;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all 
	 * to default value. If you don't want to use 
	 * this default characteristic use another constructor
	 * @param name The name of score
	 * @param score The interface of score
	 * @param d The display object to use.
	 * @param nbMonsters Number of monsters
	 * @param nbTanks Number of Tanks
	 * @param sizeMax Set the max size of the grid
	 * @param sleep set the wait before monsters' actions
	 */
	public SpaceInvaders(String name, Score score, Display d, int nbMonsters, int nbTanks, Coordinates sizeMax, int sleep)
	{
		this.maxSize = sizeMax;
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = nbMonsters;
		this.tanksAmount = nbTanks;
		this.sleepTime = sleep;
		this.acceleration = DEFAULT_ACCELERATION;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		this.name = name;
		this.score = score;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all 
	 * to default value. If you don't want to use 
	 * this default characteristic use another constructor
	 * @param name The name of score
	 * @param score The interface of score
	 * @param d The display object to use.
	 * @param nbMonsters Number of monsters
	 * @param nbTanks Number of Tanks
	 * @param sizeMax Set the max size of the grid
	 * @param sleep set the wait before monsters' actions
	 * @param acceleration Set the accelerations of the shoots
	 */
	public SpaceInvaders(String name, Score score, Display d, int nbMonsters, int nbTanks, Coordinates sizeMax, int sleep, int acceleration)
	{
		this.maxSize = sizeMax;
		this.sizeMovable = DEFAULT_SIZE;
		this.delta = DEFAULT_DELTA;
		this.coorMove = DEFAULT_MOVE;
		this.moveShoots = DEFAULT_MOVE_SHOOTS;
		this.sizeShoots = DEFAULT_SIZE_SHOOT;
		this.monstersAmount = nbMonsters;
		this.tanksAmount = nbTanks;
		this.sleepTime = sleep;
		this.acceleration = acceleration;
		this.timeDifficulty = DEFAULT_TIME_DIFFICULTY;
		this.display = d;
		this.name = name;
		this.score = score;
		initTab(this.monstersAmount, this.tanksAmount);
	}

	/**
	 * Initialize the table of movable elements.<br/>
	 * Algorithm for set-up the monsters' position 
	 * on the grid, and also Tank. It positions the 
	 * tank of the middle of the grid and the monster 
	 * from the top left to the bottom right 
	 * (like writing in English or French)
	 * 
	 * @param nbMonsters Set the number of monster 
	 * 					(The maximum is set (to my mind) 
	 * 					to 250, after I'm offload one's
	 *            		responsibilities)
	 * @param nbTanks Set the number of tank [1-4]
	 */
	private void initTab(int nbMonsters, int nbTanks)
	{
		// local variable
		int i;

		// Allocations
		this.elements = new Movable[(nbMonsters + nbTanks) * 2];

		// Set-up tank table
		for (i = 0; i < nbTanks; i++)
		{
			try
			{
				this.elements[i] = new FiringMovable(new Coordinates(((this.maxSize.getX() / 4) - (this.sizeMovable.getX() / 2))
						* i, 0), new Coordinates(this.sizeMovable.getX(), this.sizeMovable.getY()),Type.TANK, 0, 1);
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
		for (i = nbTanks ; i < nbMonsters; i++)
		{
			if (monster_position.getX() + (this.delta + this.sizeMovable.getX()) <= this.maxSize.getX() - DEFAULT_BEGIN_SPACING_MONSTERS)
			{
				try
				{
					this.elements[i] = new FiringMovable(monster_position, new Coordinates(this.sizeMovable.getX(),
							this.sizeMovable.getY()), Type.MONSTER, 0, -1);
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
	 * Method for know if any movable objects is 
	 * out of grid.
	 * @param el Movable element to check
	 * @return If return false, the element is in 
	 * the grid.
	 * @throws OutOfGridException If the element is 
	 * 				out of grid, new exception raise.
	 */
	protected boolean isOutOfGrid(Movable el) throws OutOfGridException
	{
		if (el.getArea().getPosition().getX() + el.getArea().getSize().getX() > this.maxSize.getX()
				|| el.getArea().getPosition().getY() + el.getArea().getSize().getY() > this.maxSize.getY()
				|| el.getArea().getPosition().getX() < 0
				|| el.getArea().getPosition().getY() < 0)
			throw new OutOfGridException(el);
		return false;
	}

	/**
	 * This method allows to move all instances 
	 * in table of delta coordinates.
	 * 
	 * @param delta The delta coordinates to move Invaders
	 * @param tableToMove The table to move
	 * @param t The type of elements to move
	 * @throws OutOfGridException This method can return OutOfgridException
	 *             					if monsters does'nt be anymore in the grid.
	 */
	protected void moveTab(Coordinates delta, Movable[] tableToMove, Type t) throws OutOfGridException
	{
		int i;

		// Test if all table is movable
		for (i = 0; i < tableToMove.length; i++)
		{
			if (tableToMove[i] != null && tableToMove[i].isAlive() && tableToMove[i].getType() == t)
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
			if (tableToMove[i] != null && tableToMove[i].isAlive()  && tableToMove[i].getType() == t)
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
	 * @param table Table to search empty cell
	 * @return returns the index of empty cell in table. 
	 * 			If it equals to -1 it didn't find
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
	 * @param table The table to count alive Movable.
	 * @param t The type of elements to move
	 * @return The number of alive Invaders.
	 */
	int countAlive(Movable[] table, Type t)
	{
		int nbAlive = 0, i;

		for (i = 0; i < table.length; i++)
		{
			if (table[i] != null && table[i].isAlive() && table[i].getType() == t)
				nbAlive++;
		}
		return nbAlive;
	}

	/**
	 * Make Movable given in arguments shoot
	 * 
	 * @param movable Invaders who have to shoot
	 */
	protected void shootFrom(FiringMovable movable)
	{
		int index;

		if (movable != null)
		{
			index = searchEmptyCellFromMovableTable(this.elements);
			if (index != -1)
			{
				try
				{
					this.elements[index] = movable.fire(this.sizeShoots);
				}
				catch (NegativeSizeException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Allow to move shoot(s)
	 */
	protected void moveShoots()
	{
		int i;
		//Movable fire;
		for (i = 0; i < this.elements.length; i++)
		{
			if (this.elements[i] != null && this.elements[i].isAlive() && this.elements[i].getType() == Type.SHOOT)
			{
				if (this.elements[i].getDirection() < 0)
				{
					try
					{
						if(!this.isOutOfGrid(this.elements[i]))
						{
							try
							{
								this.elements[i].move(new Coordinates(0, -this.moveShoots.getY()));
							}
							catch (NegativeSizeException e)
							{
								e.printStackTrace();
							}
						}
					}
					catch (OutOfGridException e)
					{
						e.kill();
					}
				}
				if (this.elements[i].getDirection() > 0)
				{
					try
					{
						if(!this.isOutOfGrid(this.elements[i]))
							try
						{
								this.elements[i].move(new Coordinates(0, this.moveShoots.getY()));
								/*fire = new Movable(new Coordinates(this.elements[i].getArea().getPosition().getX() +2,this.elements[i].getArea().getPosition().getY()),
										this.elements[i].getArea().getSize(), Type.SHOOT, 1);
								int index = this.searchEmptyCellFromMovableTable(this.elements);
								if(index != -1)
									this.elements[index] = fire;
								fire = new Movable(new Coordinates(this.elements[i].getArea().getPosition().getX() -2,this.elements[i].getArea().getPosition().getY()),
										this.elements[i].getArea().getSize(), Type.SHOOT, 1);
								index = this.searchEmptyCellFromMovableTable(this.elements);
								if(index != -1)
									this.elements[index] = fire;*/
						}
						catch (NegativeSizeException e)
						{
							e.printStackTrace();
						}
					}
					catch (OutOfGridException e)
					{
						e.kill();
					}
				}
			}
		}
	}

	/**
	 * This method tests if there is any collisions 
	 * in all table declared.<br/>
	 * Collision are tested between each table and 
	 * not between elements of the same table.<br/>
	 * If a Tank is touched by an enemy, work is set 
	 * to false and the game is stopped by the main 
	 * iteration.
	 */
	protected void testCollision()
	{
		int i, j;

		for(i=0; i < this.elements.length; i++)
		{
			if(this.elements[i] != null && this.elements[i].isAlive())
			{
				for(j=0 ; j < this.elements.length; j++)
				{
					if(i == j) continue;
					if(this.elements[j] != null && this.elements[j].isAlive())
					{
						if(this.elements[i].getType() == Type.TANK && this.elements[j].getType() == Type.SHOOT
								&& this.elements[j].getDirection() >= 1) continue;
						if(this.elements[i].getType() == Type.SHOOT && this.elements[j].getType() == Type.TANK
								&& this.elements[i].getDirection() >= 1) continue;
						if(this.elements[i].getType() == Type.MONSTER && this.elements[j].getType() == Type.SHOOT
								&& this.elements[j].getDirection() <= -1) continue;
						if(this.elements[i].getType() == Type.SHOOT && this.elements[j].getType() == Type.MONSTER  
								&& this.elements[i].getDirection() <= -1) continue;
						if(this.elements[i].overlapping(this.elements[j]) != null)
						{
							this.elements[i].setAlive(false);
							this.elements[j].setAlive(false);
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


	/**
	 * This method is used for killing
	 * tank(s).
	 */
	protected void killTank()
	{
		int i;

		for(i = 0; i < this.elements.length; i++)
		{
			if(this.elements[i] != null && i <= this.tanksAmount && this.elements[i].getType() == Type.TANK)
				this.elements[i].setAlive(false);
		}
	}

	/**
	 * Allows to count the number of shoots there's
	 * in the global elements table.
	 * @return The number of shoot(s).
	 */
	public int countShoot()
	{
		int i, nb=0;

		for(i=0; i < this.elements.length; i++)
		{
			if(this.elements[i] != null
					&& this.elements[i].isAlive()
					&& this.elements[i].getType() == Type.SHOOT 
					&& this.elements[i].getDirection() > 0)
				nb++;
		}
		return nb;
	}

	@Override
	public String toString()
	{
		return "SpaceInvaders\n" +
				"Size of the grid : " + this.maxSize + "\n" +
				"Monsters amount = " + this.monstersAmount + ", Tanks amount = " + this.tanksAmount + "\n" +
				"Time between each actions of monsters : " + this.sleepTime + ", Time Difficulty=" + this.timeDifficulty + "\n" +
				"Liste of elements : " + Arrays.toString(this.elements) + "\n" +
				"State of Invaders : " + this.etat + "\n" +
				"Game finished : " + this.work + "\n" +
				"Amount of tank alive : " + this.countAlive(this.elements, Type.TANK) + "\n" +
				"Amoutn of invaders alive : " + this.countAlive(this.elements, Type.MONSTER) + "\n";
	}
	
	
	
	
	
}