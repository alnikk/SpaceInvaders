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
	 * This constant defines the default sleep time between each move of Invaders 
	 */
	private static final int DEFAULT_SLEEP_TIME = 100;
	
	/**
	 * This constant is the default acceleration
	 * (Not used for now)
	 */
	private static final int DEFAULT_ACCELERATION = 2;
	
	/**
	 * This constant defines the step X on the grid of a move
	 */
	private static final int DEFAULT_X_MOVE = 10;
	
	/**
	 * This constant defines the step Y on the grid of a move
	 */
	private static final int DEFAULT_Y_MOVE = 10;
	
	/**
	 * This constant defines the size of shoot
	 */
	private static final Coordinates DEFAULT_SIZE_SHOOT = new Coordinates(5,10);
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
	
	//***************** Variable *************************
	
	// FIXME (SEEN) Define the enum in a separate file (same package)
	
	/**
	 * This variable is the state of invaders 
	 */
	private Etat etat;
	
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
	 * Boolean to know if the game is finished
	 */
	private boolean work;

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
	public SpaceInvadersMsVs()
	{
		this.work = true;
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
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
		this.work = true;
		this.maxSize = new Coordinates(X_GRID, Y_GRID);
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
	 */
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max)
	{
		this.work = true;
		this.maxSize = max;
		initTab(nbMonsters, nbTanks);
	}

	// ************************** Methods **************************//

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

	/**
	 * This constructors set the variable needed by the thread.
	 * @param sleepTime Number of millisecond between each move
	 * @param acceleration Acceleration of sleepTime when less Invaders
	 * @param monsters The table of monsters to move
	 * @param tanks The table of tank to check collision
	 * @param shoots The table of shoots to create new one
	 * @param work The stop loop value 
	 */
	private void MonstersBehavior(int sleepTime, int acceleration, Movable monsters[], Movable tanks[], Movable[] shoots, Boolean work)
	{
		this.sleepTime = sleepTime;
		this.acceleration = acceleration;
		this.monsters = monsters;
		this.tanks = tanks;
		this.shoots = shoots;
		this.work = work;
		this.etat = Etat.LEFT_UP;
		run();
	}

	/**
	 * This constructors set the variable needed by the thread.
	 * @param sleepTime Number of millisecond between each move
	 * @param monsters The table of monsters to move
	 * @param tanks The table of tank to check collision
	 * @param shoots The table of shoots to create new one
	 * @param work The stop loop value
	 */
	private void MonstersBehavior(int sleepTime, Movable monsters[], Movable tanks[], Movable[] shoots, Boolean work)
	{
		this.sleepTime = sleepTime;
		this.monsters = monsters;
		this.tanks = tanks;
		this.shoots = shoots;
		this.work = work;
		this.acceleration = DEFAULT_ACCELERATION;
		this.etat = Etat.LEFT_UP;
		run();
	}

	/**
	 * This constructors set the variable needed by the thread.
	 * @param monsters The table of monsters to move
	 * @param tanks The table of tank to check collision
	 * @param shoots The table of shoots to create new one
	 * @param work The stop loop value
	 */
	private void MonstersBehavior(Movable monsters[], Movable tanks[], Movable[] shoots, Boolean work)
	{
		this.monsters = monsters;
		this.tanks = tanks;
		this.shoots = shoots;
		this.work = work;
		this.acceleration = DEFAULT_ACCELERATION;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.etat = Etat.LEFT_UP;
		run();
	}
	
	/**
	 * Main of the thread.
	 * It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		// TODO remove Debug msg
		System.out.println("\nBegin MoveMonstersThread");
		testCollision();
		while(this.work)
		{
			// TODO remove Debug msg
			System.out.println(Arrays.toString(this.monsters));
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
			
			waitMonsters();
			//TODO Remove debug
			//kill();
		}
		// TODO remove Debug msg
		System.out.println("End MoveMonstersThread\n");
	}
	
	//******************** Method ***********************
	
	// methote de test
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
						System.out.println("Collision : " + this.tanks[i].overlapping(this.monsters[j]));
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
	 * This method allows to move Invaders table of delta dx, dy.
	 * @param dx The delta dx coordinates to move Invaders
	 * @param dy The delta dy coordinates to move Invaders
	 * @throws OutOfGridException This method can return OutOfgridException if monsters does'nt be anymore in the grid.
	 */
	private void moveTab(int dx, int dy) throws OutOfGridException
	{
		int i, nbMonsters;
		nbMonsters = this.monsters.length;
		for(i=0; i < nbMonsters; i++)
		{
			try
			{
				if(this.monsters[i].getArea().getPosition().getX() + 
						this.monsters[i].getArea().getSize().getX() + dx > this.maxSize.getX()
					|| this.monsters[i].getArea().getPosition().getY() + 
						this.monsters[i].getArea().getSize().getY() + dy > this.maxSize.getY()
					|| this.monsters[i].getArea().getPosition().getX() + dx < 0
					|| this.monsters[i].getArea().getPosition().getY() + dy < 0)
				{
					// Kill when Y coordinates is less than 0?
					throw new OutOfGridException(this.monsters[i]);
				}
				this.monsters[i].move(dx, dy);
			}
			catch (NegativeSizeException e)
			{
				System.out.println(e.getNegativeCoordinatesException());
				System.out.println(this.monsters[i] + " " + new Coordinates(dx,dx));
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
	 * Method for shoot on tanks.
	 * It search the invaders just above tanks and shoot.
	 */
	private void shoot()
	{
		int nbMonsters = this.monsters.length;
		int nbTanks = this.tanks.length;
		int nbShoots = this.shoots.length;
		int i,j,k = 0, l = -1;
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
			if(invaderAbove != null)
			{
				// TODO Remove debug
				System.out.println("Shoot is from : " + invaderAbove);
				try
				{
					// Search dead shoot
					while(k < nbShoots)
					{
						if(this.shoots[k] != null)
						{
							if(!this.shoots[k].isAlive())
								l = k;
						}
						else
						{
							l = k;
						}
						k++;
					}
					if(l != -1) // TODO Add acceleration to shoot
						this.shoots[l] = invaderAbove.fire(-1, DEFAULT_SIZE_SHOOT);
					else 	// TODO Remove debug
						System.out.println("Issue l = -1");
				}
				catch (NegativeSizeException e)
				{
					e.printStackTrace();
					System.out.println(e.getNegativeCoordinatesException());
				}
			}
		}
	}	
	
	@Override
	public String toString()
	{
		return "SpaceInvaders [tabMonster=" + Arrays.toString(this.monsters) + "tabTank="
				+ Arrays.toString(this.tanks) + "]";
	}
}
