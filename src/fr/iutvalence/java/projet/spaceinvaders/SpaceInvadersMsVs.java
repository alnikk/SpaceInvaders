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
	
	/**
	 * It defines the maximum (default) of X axis, if it's not set in constructor.
	 */
	private static final int X_GRID = 100;

	/**
	 * It defines the maximum (default) of Y axis, if it's not set in constructor.
	 */
	private static final int Y_GRID = 30;

	/**
	 * Default size of element (e.g. Doc Movable)
	 */
	private static final int DEFAULT_SIZE = 5;
	
	/**
	 * Default delta between 2 monsters
	 */
	private static final int DEFAULT_DELTA = 2;
	
	/**
	 * This constant defines the step X on the grid of a move
	 */
	private static final int DEFAULT_X_MOVE = 5;
	
	/**
	 * This constant defines the step Y on the grid of a move
	 */
	private static final int DEFAULT_Y_MOVE = 5;

	/**
	 * This constant defines the size of shoot
	 */
	private static final Coordinates DEFAULT_SIZE_SHOOT = new Coordinates(2,5);
	
	/**
	 * It defines the number of monsters you have in tabMonster by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_MONSTERS_AMOUNT = 10;

	/**
	 * It defines the number of tank you have in tabTank by default, if it's not set in constructor.
	 */
	private static final int DEFAULT_TANKS_AMOUNT = 1;
	
	/**
	 * This constant defines the default sleep time between each move of Invaders 
	 */
	private static final int DEFAULT_SLEEP_TIME = 1000;
	
	/**
	 * This constant is the default acceleration
	 * (Not used for now)
	 */
	private static final int DEFAULT_ACCELERATION = 2;
	
	//***************** Variable *************************
	
	// FIXME (SEEN) Define the enum in a separate file (same package)
	
	/**
	 * The maximum size of the area
	 */
	private final Coordinates maxSize;
	
	/**
	 * This variable is used to wait sleepTime millisecond between each loop 
	 */
	private int sleepTime;
	
	/**
	 * Not implemented yet
	 * It uses to accelerate sleepTime when invaders are less numerous
	 */
	private int acceleration;
	
	/**
	 * This variable is the state of invaders 
	 */
	private Etat etat;
	
	/**
	 * Boolean to know if the game is finished
	 */
	private boolean work;

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
	public SpaceInvadersMsVs()
	{
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
		this.work = true;
		this.etat = Etat.LEFT_UP;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.acceleration = DEFAULT_ACCELERATION;
		initTab(DEFAULT_MONSTERS_AMOUNT, DEFAULT_TANKS_AMOUNT);
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
		this.work = true;
		this.etat = Etat.LEFT_UP;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.acceleration = DEFAULT_ACCELERATION;
		initTab(nbMonsters, nbTanks);
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
		this.work = true;
		this.etat = Etat.LEFT_UP;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.acceleration = DEFAULT_ACCELERATION;
		initTab(nbMonsters, nbTanks);
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
		this.work = true;
		this.etat = Etat.LEFT_UP;
		this.sleepTime = sleepTime;
		this.acceleration = DEFAULT_ACCELERATION;
		initTab(nbMonsters, nbTanks);
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
		this.work = true;
		this.etat = Etat.LEFT_UP;
		this.sleepTime = sleepTime;
		this.acceleration = acceleration;
		initTab(nbMonsters, nbTanks);
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
			this.tanks[0] = new Movable(tank_position, new Coordinates(DEFAULT_SIZE,DEFAULT_SIZE));
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
					this.monsters[i] = new Movable(monster_position, new Coordinates(DEFAULT_SIZE,DEFAULT_SIZE));
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
	
	/**
	 * Search an empty cell in table given in argument.
	 * @param table Table to search empty cell
	 * @return return the index of empty cell in table. if it equals to -1 it didn't find
	 */
	private int searchEmptyCellFromMovableTable(Movable table[])
	{
		int i;
		int nbCell = table.length;
		
		for(i = 0; i < nbCell; i++)
		{
			if(table[i] != null)
			{
				if(!table[i].isAlive())
					return i;
			}
			else
			{
				return i;
			}
		}
		return -1;
	}
	
	//********************* Main ************************
	
	/**
	 * Main of the thread.
	 * It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		testCollision();
		while(this.work)
		{
			// TODO remove Debug msg
			//System.out.println(Arrays.toString(this.monsters));
			try
			{
				move();
			}
			catch (OutOfGridException e1)
			{
				// Stop Game ?
				// No ^^, Kill him hahaha >< x)
				e1.kill();
				System.out.println("OutOfGrid : " + e1.getOutOfGridException());
			}
			
			testCollision();
			
			shoot();
			
			// TODO Print screen
			showGrid();
			
			waitMonsters();
			
			randomMove();
			
			//TODO Remove debug
			//kill();
		}
	}
	
	//******************** Method ***********************
	
	// test method
	// TODO think to remove
	/**
	 * Test for acceleration
	 */
	private void kill()
	{
		int i = 0, nbMonsters= this.monsters.length;
		
		while(i < nbMonsters && (!this.monsters[i].isAlive()))
			i++;
		this.monsters[i].setAlive(false);
	}
	
	/**
	 * This method tests if there is any collisions in all table declared.<br/>
	 * Collision are tested between each table and not between elements of the same table.<br/>
	 * If a Tank is touched by an enemy, work is set to false and the game is stopped by the main iteration.
	 */
	private void testCollision()
	{
		int nbMonsters, nbTanks, i, j;
		
		nbTanks = this.tanks.length;
		nbMonsters = this.monsters.length;
		
		for(i=0;i < nbTanks; i++)
		{ // TODO Tank alive?
			for(j=0; j < nbMonsters; j++)
			{
				if(this.monsters[j].isAlive())
				{
					if(this.tanks[i].overlapping(this.monsters[j]) != null)
					{
						this.tanks[i].setAlive(false);
						this.monsters[j].setAlive(false);
						this.work = false;
						// TODO remove Debug msg
						//System.out.println("Collision : " + this.tanks[i].overlapping(this.monsters[j]));
					}
				}
			}
		}	
	}
	
	// FIXME (SEEN) prefer using moveTab(Coordinate) rather than moveTab(int, int)
	/**
	 * This method allows to move Invaders table of delta coordinates.
	 * @param delta The delta coordinates to move Invaders
	 * @throws OutOfGridException This method can return OutOfgridException if monsters does'nt be anymore in the grid.  
	 */
	private void moveTab(Coordinates delta) throws OutOfGridException
	{
		int i, nbMonsters;
		nbMonsters = this.monsters.length;
		for(i=0; i < nbMonsters; i++)
		{
			try
			{
				if(this.monsters[i].getArea().getPosition().getX() + 
						this.monsters[i].getArea().getSize().getX() + delta.getX() > this.maxSize.getX()
					|| this.monsters[i].getArea().getPosition().getY() + 
						this.monsters[i].getArea().getSize().getY() + delta.getY() > this.maxSize.getY()
					|| this.monsters[i].getArea().getPosition().getX() + delta.getX()< 0
					|| this.monsters[i].getArea().getPosition().getY() + delta.getY() < 0)
				{
					// Kill when Y coordinates is less than 0?
					throw new OutOfGridException(this.monsters[i]);
				}
				this.monsters[i].move(delta);
			
			}
			catch (NegativeSizeException e)
			{
				System.out.println(e.getNegativeCoordinatesException());
				System.out.println(this.monsters[i] + " " + delta);
				e.printStackTrace();
			}
		}
	}
		
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
	 * @throws OutOfGridException If Invaders are OutOfGrid then ther's exception.
	 */
	private void move() throws OutOfGridException
	{
		switch(this.etat)
		{
			case LEFT_UP:
				try
				{
					moveTab(new Coordinates(DEFAULT_X_MOVE, 0));
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.RIGHT_UP;
					move();
				}
				break;
			case RIGHT_UP:
				moveTab(new Coordinates(0, -DEFAULT_Y_MOVE));
				this.etat = Etat.RIGHT_BOTTOM;
				break;
			case RIGHT_BOTTOM:
				try
				{
					moveTab(new Coordinates(-DEFAULT_X_MOVE, 0));
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.LEFT_BOTTOM;
					move();
				}
				break;
			case LEFT_BOTTOM:
				moveTab(new Coordinates(0, -DEFAULT_Y_MOVE));
				this.etat = Etat.LEFT_UP;
				break;
		}
	}
	
	/**
	 * This method count the number of alive Invaders.
	 * @return The number of alive Invaders.
	 */
	private int countMonsters()
	{
		int nbInvaders = this.monsters.length, nbAlive = 0, i;
		
		for(i = 0; i < nbInvaders; i++)
		{
			if(this.monsters[i].isAlive())
				nbAlive++;
		}
		// TODO is this go here?
		if(nbAlive == 0) // we stop game if there's no Invaders
			this.work = false;
		return nbAlive;
	}
	
	/**
	 * This method wait a time in function of sleepTime value and of monster alive's number
	 */
	private void waitMonsters()
	{
		try
		{			
			// expression is a.x type. Add a.x + c with c playable. It have to don't affect sleepTime
			Thread.sleep((long) (Math.sqrt(((double) countMonsters()/this.monsters.length)) * this.sleepTime));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * Make invader given in arguments shoot
	 * @param invader Invaders who have to shoot
	 */
	private void shootFrom(Movable invader)
	{
		int index;
		
		if(invader != null)
		{
			index = searchEmptyCellFromMovableTable(this.shoots);
			if (index != -1)
			{
				// TODO remove debug
				//System.out.println("Shoot is from : " + invader);
					// TODO Add acceleration to shoot
				try
				{
					this.shoots[index] = invader.fire(-1, DEFAULT_SIZE_SHOOT);
				}
				catch (NegativeSizeException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//else	// TODO Remove debug
				///System.out.println("Issue : don't find free place for shoot");
		}
	}
	
	/**
	 * Method for shoot on tanks.
	 * It search the invaders just above tanks and shoot.
	 */
	private void shoot()
	{
		int nbMonsters = this.monsters.length;
		int nbTanks = this.tanks.length;
		int i,j;
		Movable invaderAbove = null;
		
		for(i = 0; i < nbTanks; i++)
		{
			if(this.tanks[i].isAlive())
			{
				for(j = nbMonsters - 1; j > 0 ; j--)
				{
					if(this.monsters[j].isAlive())
					{
						if(((this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) - (DEFAULT_SIZE_SHOOT.getX() / 2) < (this.tanks[i].getArea().getPosition().getX() + this.tanks[i].getArea().getSize().getX())
								&& (this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) - (DEFAULT_SIZE_SHOOT.getX() / 2) > (this.tanks[i].getArea().getPosition().getX()))
								|| ((this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) + (DEFAULT_SIZE_SHOOT.getX() / 2) < (this.tanks[i].getArea().getPosition().getX() + this.tanks[i].getArea().getSize().getX())
								&& (this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2) + (DEFAULT_SIZE_SHOOT.getX() / 2)  > (this.tanks[i].getArea().getPosition().getX())))
						{
							if(invaderAbove != null)
							{
								if(invaderAbove.getArea().getPosition().getY() > this.monsters[j].getArea().getPosition().getY())
								{
									invaderAbove = this.monsters[j];
								}
							}
							else
								invaderAbove = this.monsters[j];
						}
					}
				}
			}
			shootFrom(invaderAbove);
		}
	}
		
	/**
	 * Create grid image to table of character
	 * @return 2D table of character
	 */
	private char[][] gridImage()
	{
		int i,x,y;
		int nbTanks = this.tanks.length, nbMonsters = this.monsters.length, 
				nbShoots = this.shoots.length;
		char grid[][] = new char[this.maxSize.getX()][this.maxSize.getY()];
		
		for(y = 0; y < this.maxSize.getY(); y++)
		{
			for(x = 0; x < this.maxSize.getX(); x++)
			{
				grid[x][y] = 'x';
			}
		}
		
		for(i = 0; i < nbTanks; i++)
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
		
		for(i = 0; i < nbMonsters; i++)
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

		for(i = 0; i < nbShoots; i++)
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
			for(x = this.maxSize.getX() - 1; x >= 0; x--)
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
	
	private void randomMove()
	{
		try
		{
			this.tanks[0].move(new Coordinates((int) (Math.random() * 10),0));
		}
		catch (NegativeSizeException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		return "SpaceInvaders [tabMonster=" + Arrays.toString(this.monsters) + "tabTank="
				+ Arrays.toString(this.tanks) + "]";
	}
}
