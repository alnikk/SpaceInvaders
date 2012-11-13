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
public class SpaceInvadersMsVs
{	
	// ************* Constant *************//
	
		//[[[[[[[ Grid ]]]]]]]
	/**
	 * It defines the maximum (default) of X axis, if it's not set in constructor.
	 */
	private static final int X_GRID = 100;

	/**
	 * It defines the maximum (default) of Y axis, if it's not set in constructor.
	 */
	private static final int Y_GRID = 30;
	
		//[[[[[[[ Movable ]]]]]]]
	/**
	 * Default size of element (e.g. Doc Movable)
	 */
	private static final Coordinates DEFAULT_SIZE = new Coordinates(5,5);
	
	/**
	 * Default delta between 2 monsters
	 */
	private static final int DEFAULT_DELTA = 2;
	
	/**
	 * This constant defines the step on the grid of a move
	 */
	private static final Coordinates DEFAULT_MOVE = new Coordinates(5,5);
	
		//[[[[[[[ Shoots ]]]]]]]
	/**
	 * This constant defines the step on the grid of a move
	 */
	private static final Coordinates DEFAULT_MOVE_SHOOTS = new Coordinates(0,2);
	
	/**
	 * This constant defines the size of shoot
	 */
	private static final Coordinates DEFAULT_SIZE_SHOOT = new Coordinates(2,5);
	
		//[[[[[[[ Numerous ]]]]]]]
	/**
	 * It defines the number of monsters you have in tabMonster by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_MONSTERS_AMOUNT = 10;

	/**
	 * It defines the number of tank you have in tabTank by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_TANKS_AMOUNT = 4;
	
		//[[[[[[[ Time ]]]]]]]
	/**
	 * This constant defines the default sleep time between each move of Invaders 
	 */
	private static final int DEFAULT_SLEEP_TIME = 800;
	
	/**
	 * This constant is the default acceleration
	 * (Not used for now)
	 */
	private static final int DEFAULT_ACCELERATION = 2;
	
	//***************** Variable *************************
	
	// FIXME (SEEN) Define the enum in a separate file (same package)
	
		//[[[[[[[ Grid ]]]]]]]
	/**
	 * The maximum size of the area
	 */
	private final Coordinates maxSize;
	
	//[[[[[[[ Movable ]]]]]]]
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
	private Coordinates coorMove;
	
	//[[[[[[[ Shoots ]]]]]]]
	/**
	 * Defines the step on the grid of a move
	 */
	private Coordinates moveShoots;

	/**
	 * Defines the size of shoot
	 */
	private Coordinates sizeShoots;
	
	//[[[[[[[ Numerous ]]]]]]]
	/**
	 * It defines the number of monsters you have in tabMonster.
	 */
	private int monstersAmount;

	/**
	 * It defines the number of tank you have in tabTank.
	 */
	private int tanksAmount;
	
	//[[[[[[[ Time ]]]]]]]
	/**
	 * This variable is used to wait sleepTime millisecond between each loop 
	 */
	private int sleepTime;

	/**
	 * Not implemented yet
	 * It uses to accelerate sleepTime when invaders are less numerous
	 */
	private int acceleration;

		//[[[[[[[ Table ]]]]]]]
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
		
		//[[[[[[[ Others ]]]]]]]
	/**
	 * This variable is the state of invaders 
	 */
	private Etat etat;
	
	/**
	 * Boolean to know if the game is finished
	 */
	private boolean work;

	// ************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. 
	 * It set all to default value.
	 * If you don't want to use this default characteristic use another constructor
	 */
	public SpaceInvadersMsVs()
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
	 */
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks)
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
	 */
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max)
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
	 */
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max, int sleepTime)
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
	 */
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, int acceleration)
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
		initTab(this.monstersAmount, this.tanksAmount);
	}

	// ************************** Generals Methods **************************//

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
		for(i = 0; i < nbTanks; i++)
		{
			try
			{		// TODO improve with tank
				this.tanks[i] = new Movable(new Coordinates(((this.maxSize.getX() / 4) - (this.sizeMovable.getX() / 2))*i,0), 
											new Coordinates(this.sizeMovable.getX(),this.sizeMovable.getY()));
			}
			catch (NegativeSizeException e1)
			{
				System.out.println(e1);
			}
		}

		// Define Invaders position
		this.etat = Etat.LEFT_UP;
		
		// Set-up Invaders table
		Coordinates monster_position = new Coordinates(this.delta, this.maxSize.getY() - (this.sizeMovable.getY() + this.delta));
		for(i = 0; i < nbMonsters; i++)
		{
			if(monster_position.getX() + (this.delta + this.sizeMovable.getX()) <= this.maxSize.getX())
			{
				try
				{
					this.monsters[i] = new Movable(monster_position, new Coordinates(this.sizeMovable.getX(),this.sizeMovable.getY()));
				}
				catch (NegativeSizeException e)
				{
					System.out.println(e);
				}
				monster_position = new Coordinates(monster_position.getX() + (this.delta + this.sizeMovable.getX()),
													monster_position.getY());
			}
			else
				monster_position = new Coordinates(this.delta, monster_position.getY() - (this.delta + this.sizeMovable.getY()));
		}
		testCollision();
	}
	
	// FIXME (SEEN) prefer using moveTab(Coordinate) rather than moveTab(int, int)
	/**
	 * This method allows to move all instances in table of delta coordinates.
	 * @param delta The delta coordinates to move Invaders
	 * @param tableToMove The table to move
	 * @throws OutOfGridException This method can return OutOfgridException if monsters does'nt be anymore in the grid.  
	 */
	private void moveTab(Coordinates delta, Movable[] tableToMove) throws OutOfGridException
	{
		int i;
		
		// Test if all table is movable
		for(i=0; i < tableToMove.length; i++)
		{
			if(tableToMove[i] != null && tableToMove[i].isAlive())
			{
				if(tableToMove[i].getArea().getPosition().getX() + 
						tableToMove[i].getArea().getSize().getX() + delta.getX() > this.maxSize.getX()
					|| tableToMove[i].getArea().getPosition().getY() + 
						tableToMove[i].getArea().getSize().getY() + delta.getY() > this.maxSize.getY()
					|| tableToMove[i].getArea().getPosition().getX() + delta.getX()< 0
					|| tableToMove[i].getArea().getPosition().getY() + delta.getY() < 0)
				{
					// TODO Kill when Y coordinates is less than 0?
					throw new OutOfGridException(tableToMove[i]);
				}
			}
		}
		
		// Next we move table
		for(i=0; i < tableToMove.length; i++)
		{
			if(tableToMove[i] != null && tableToMove[i].isAlive())
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
	 * @param table Table to search empty cell
	 * @return return the index of empty cell in table. if it equals to -1 it didn't find
	 */
	private int searchEmptyCellFromMovableTable(Movable table[])
	{
		int i;
		
		for(i = 0; i < table.length; i++)
		{
			if(table[i] != null)
			{
				if(!table[i].isAlive())
					return i;
			}
			else
				return i;
		}
		return -1;
	}
	
	/**
	 * This method count the number of alive Movable.
	 * @param table The table to count alive Movable.
	 * @return The number of alive Invaders.
	 */
	private int countAlive(Movable[] table)
	{
		int nbAlive = 0, i;
		
		for(i = 0; i < table.length; i++)
		{
			if(table[i].isAlive())
				nbAlive++;
		}
		return nbAlive;
	}
	
	/**
	 * This method wait a time in function of sleepTime value and of monster alive's number
	 */
	private void waitLoop()
	{
		try
		{		
			// TODO sleepTime constant...
			// expression is a.x type. Add a.x + c with c playable. It have to don't affect sleepTime
			Thread.sleep((long) (Math.sqrt(((double) countAlive(this.monsters)/this.monstersAmount)) * this.sleepTime));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Make invader given in arguments shoot
	 * @param movable Invaders who have to shoot
	 * @param direction The direction you want to shoot
	 */
	private void shootFrom(Movable movable, int direction)
	{
		int index;
		
		if(movable != null)
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
	
	// TODO think to remove
	/**
	 * Kill one instance of movable object
	 * @param tabToKill Table where kill instance
	 */
	private void kill(Movable[] tabToKill)
	{
		int i = 0, nbMonsters= tabToKill.length;
		
		while(i < nbMonsters && (!tabToKill[i].isAlive()))
			i++;
		tabToKill[i].setAlive(false);
	}
	
	//********************* Main ************************
	
	/**
	 * Main of the thread.
	 * It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		this.work = true;
		while(this.work)
		{			
			moveShoots();
			
			moveMonsters();
			
			monsterShoot();
			
			try
			{
				randomMove();
			}
			catch (OutOfGridException e)
			{
				java.awt.Toolkit.getDefaultToolkit().beep();
			}

			tankShoot();

			testCollision();
			
			if(this.countAlive(this.tanks) == 0 || this.countAlive(this.monsters) == 0)
				this.work = false;
			
			showGrid();
			waitLoop();
		}
	}
	
	//******************** Method ***********************

		//[[[[[[[[[[[[[ Collision ]]]]]]]]]]]]]
	// TODO Go to general section ?
	/**
	 * This method tests if there is any collisions in all table declared.<br/>
	 * Collision are tested between each table and not between elements of the same table.<br/>
	 * If a Tank is touched by an enemy, work is set to false and the game is stopped by the main iteration.
	 */
	private void testCollision()
	{
		int i, j;
		
		for(i=0;i < this.tanksAmount; i++)
		{ 
			if(this.tanks[i] != null && this.tanks[i].isAlive())
			{
				for(j=0; j < this.monstersAmount; j++)
				{
					if(this.shoots[i] != null && this.monsters[j].isAlive())
					{
						if(this.tanks[i].overlapping(this.monsters[j]) != null)
						{
							this.tanks[i].setAlive(false);
							this.monsters[j].setAlive(false);
						}
					}
				}
				
				for(j=0; j < (this.monstersAmount + this.tanksAmount); j++)
				{
					if(this.shoots[j] != null && this.shoots[j].isAlive())
					{
						if(this.tanks[i].overlapping(this.shoots[j]) != null)
						{
							this.tanks[i].setAlive(false);
							this.shoots[j].setAlive(false);
						}
					}
				}
			}
		}
		
		for(i=0; i < this.monstersAmount; i++)
		{
			if(this.monsters[i] != null && this.monsters[i].isAlive())
			{
				for(j=0; j < (this.monstersAmount + this.tanksAmount); j++)
				{
					if(this.shoots[j] != null && this.shoots[j].isAlive())
					{
						if(this.monsters[i].overlapping(this.shoots[j]) != null)
						{
							this.monsters[i].setAlive(false);
							this.shoots[j].setAlive(false);
						}						
					}
				}
			}
		}
	}
	
	
		//[[[[[[[[[[[[[ Monsters behavior ]]]]]]]]]]]]]
		
	/**
	 * This method allows to move Invaders once that is to say to right, down, or left.
	 * It follow scheme by itself :
	 * <ul>
	 * <li>right</li>
	 * <li>down</li>
	 * <li>left</li>
	 * <li>down</li>
	 * <li>right</li>
	 * </ul> 
	 */
	private void moveMonsters()
	{
		switch(this.etat)
		{
			case LEFT_UP:
				try
				{
					moveTab(new Coordinates(this.coorMove.getX(), 0), this.monsters);
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.RIGHT_UP;
					moveMonsters();
				}
				break;
			case RIGHT_UP:
				try
				{
					moveTab(new Coordinates(0, -this.coorMove.getY()), this.monsters);
				}
				catch (OutOfGridException e1)
				{
					e1.kill();
					moveMonsters();
				}
				this.etat = Etat.RIGHT_BOTTOM;
				break;
			case RIGHT_BOTTOM:
				try
				{
					moveTab(new Coordinates(-this.coorMove.getX(), 0), this.monsters);
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.LEFT_BOTTOM;
					moveMonsters();
				}
				break;
			case LEFT_BOTTOM:
				try
				{
					moveTab(new Coordinates(0, -this.coorMove.getY()), this.monsters);
				}
				catch (OutOfGridException e1)
				{
					e1.kill();
					moveMonsters();
				}
				this.etat = Etat.LEFT_UP;
				break;
		}
	}
	
	/**
	 * Method for shoot on tanks.
	 * It search the invaders just above tanks and shoot.
	 */
	private void monsterShoot()
	{
		int i,j;
		Movable invaderAbove = null;
		
		for(i = 0; i < this.tanksAmount; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
			{
				for(j = this.monstersAmount - 1; j > 0 ; j--)
				{
					if(this.monsters[i] != null && this.monsters[j].isAlive())
					{
						if(((this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) - (this.sizeShoots.getX() / 2) < (this.tanks[i].getArea().getPosition().getX() + this.tanks[i].getArea().getSize().getX())
								&& (this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) - (this.sizeShoots.getX() / 2) > (this.tanks[i].getArea().getPosition().getX()))
								|| ((this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) + (this.sizeShoots.getX() / 2) < (this.tanks[i].getArea().getPosition().getX() + this.tanks[i].getArea().getSize().getX())
								&& (this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) + (this.sizeShoots.getX() / 2)  > (this.tanks[i].getArea().getPosition().getX())))
						{
							if(invaderAbove != null)
							{
								if(invaderAbove.getArea().getPosition().getY() > this.monsters[j].getArea().getPosition().getY())
									invaderAbove = this.monsters[j];
							}
							else
								invaderAbove = this.monsters[j];
						}
					}
				}
			} // TODO Shoot's acceleration
			shootFrom(invaderAbove, -1);
		}
	}
	
		//[[[[[[[[[[[[[ Shoots behavior ]]]]]]]]]]]]]
		
	/**
	 * Allow to move shoot
	 */
	private void moveShoots()
	{
		int i;
		
		for(i = 0; i < (this.monstersAmount + this.tanksAmount); i++)
		{
			if(this.shoots[i] != null && this.shoots[i].isAlive())
			{
				try
				{
					if(this.shoots[i].getDirection() < 0)
						this.moveTab(new Coordinates(0, -this.moveShoots.getY()), this.shoots);
					if(this.shoots[i].getDirection() > 0)
						this.moveTab(new Coordinates(0, this.moveShoots.getY()), this.shoots);
				}
				catch (OutOfGridException e)
				{
					e.kill();
				}
			}
		}
	}
	
		//[[[[[[[[[[[[[ Display ]]]]]]]]]]]]]
	
	/**
	 * Create grid image to table of character
	 * @return 2D table of character
	 */
	private char[][] gridImage()
	{
		int i,x,y;
		char grid[][] = new char[this.maxSize.getX()][this.maxSize.getY()];
		
		for(y = 0; y < this.maxSize.getY(); y++)
		{
			for(x = 0; x < this.maxSize.getX(); x++)
			{
				grid[x][y] = ' ';
			}
		}
		
		for(i = 0; i < this.tanksAmount; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
			{
				y = this.tanks[i].getArea().getPosition().getY();
				while(y < (this.tanks[i].getArea().getSize().getY() + this.tanks[i].getArea().getPosition().getY()))
				{
					x = this.tanks[i].getArea().getPosition().getX();
					while(x < (this.tanks[i].getArea().getSize().getX()  + this.tanks[i].getArea().getPosition().getX()))
					{
						grid[x][y] = 'T';
						x++;
					}
					y++;
				}
			}
		}
		
		for(i = 0; i < this.monstersAmount; i++)
		{
			if(this.monsters[i] != null && this.monsters[i].isAlive())
			{
				y = this.monsters[i].getArea().getPosition().getY();
				while(y < (this.monsters[i].getArea().getSize().getY() + this.monsters[i].getArea().getPosition().getY()))
				{
					x = this.monsters[i].getArea().getPosition().getX();
					while(x < (this.monsters[i].getArea().getSize().getX()  + this.monsters[i].getArea().getPosition().getX()))
					{
						grid[x][y] = 'M';
						x++;
					}
					y++;
				}
			}
		}

		for(i = 0; i < (this.monstersAmount + this.tanksAmount); i++)
		{
			if(this.shoots[i] != null && this.shoots[i].isAlive())
			{
				y = this.shoots[i].getArea().getPosition().getY();
				while(y < (this.shoots[i].getArea().getSize().getY() + this.shoots[i].getArea().getPosition().getY()))
				{
					x = this.shoots[i].getArea().getPosition().getX();
					while(x < (this.shoots[i].getArea().getSize().getX()  + this.shoots[i].getArea().getPosition().getX()))
					{
						grid[x][y] = 'S';
						x++;
					}
					y++;
				}
			}
		}
		
		return grid;
	}
	
	/**
	 * Print the grid to the screen
	 * @param grid the grid to print
	 */
	private void printGrid(char[][] grid)
	{
		int x ,y;
		
		for(y = this.maxSize.getY() - 1; y >= 0; y--)
		{
			for(x = 0; x <this.maxSize.getX(); x++)
			{
				System.out.print(grid[x][y]);
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	/**
	 * Allows to print the game to the screen in ASCII Art
	 */
	public void showGrid()
	{
		char[][] grid = gridImage(); 
		printGrid(grid);
	}
	
	
		//[[[[[[[[[[[[[  Controls ]]]]]]]]]]]]]
	
	/**
	 * Allows random tank control
	 * @throws OutOfGridException Indicate when Tank want to go over the screen
	 */
	private void randomMove() throws OutOfGridException
	{
		int i;
		int x;
		long neg;
		
		for(i=0; i < this.tanksAmount; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
			{
				x = (int) (Math.random() * 10);
				neg = Math.round(Math.random());
				
				if(neg == 0)
					neg = -1;
				
				try
				{
					if((this.tanks[i].getArea().getPosition().getX() + (int) (x*neg)) > 0
						&& (this.tanks[i].getArea().getPosition().getX() +
						    this.tanks[i].getArea().getSize().getX() + (int) (x*neg)) < this.maxSize.getX())
					{
						this.tanks[i].move(new Coordinates((int) (x*neg),0));
					}
					else
					{
						throw new OutOfGridException(this.tanks[i]);
					}
				}
				catch (NegativeSizeException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Allow tank to shoot Invaders
	 */
	private void tankShoot()
	{
		int i;
		
		for(i=0; i < this.tanksAmount; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
				this.shootFrom(this.tanks[i], 1);
		}
	}
	
		//[[[[[[[[[[[[[  Others ]]]]]]]]]]]]]
	
	@Override
	public String toString()
	{
		return "SpaceInvaders [tabMonster=" + Arrays.toString(this.monsters) + "tabTank="
				+ Arrays.toString(this.tanks) + "]";
	}
}
