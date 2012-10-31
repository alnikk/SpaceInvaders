/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.util.Arrays;

/**
 * This thread loop until the game finish.
 * It make invaders move and test collision beetween us and the tank. 
 * 
 * @author Gallet Guyon
 */
public class MoveMonstersThread extends Thread
{
	//***************** Constant *************************
	
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
		
		
	//***************** Variable *************************
	
	// FIXME is that right?
	/**
	 * This enumerate the state of invaders
	 */
	private enum Etat {/**
	 * This is the first state, and invaders are left side on the grid
	 */
	LEFT1, /**
	 * This is the second state, and invaders are right side on the grid
	 */
	RIGHT2, /**
	 * This is the third state, and invaders are right side on the grid
	 */
	RIGHT3, /**
	 * This is the fourth state, and invaders are left side on the grid
	 */
	LEFT4};
	
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
	 * A copy of monsters' tab in space invaders.
	 * Array containing all monsters
	 */
	private Movable monsters[];
	
	/**
	 * A copy of tanks' tab in space invaders.
	 * Array containing all tanks
	 */
	private Movable tanks[];
	
	/**
	 * Reference to work boolean in SpaceInvaders class
	 * Boolean to know if the game is finished
	 */
	private Boolean work;
	
	/**
	 * The maximum size of the area
	 */
	private final Coordinates max;
	
	
	//***************** Constructors *************************

	/**
	 * This constructors set the variable needed by the thread.
	 * @param nom Name of the Thread
	 * @param sleepTime Number of millisecond between each move
	 * @param acceleration Acceleration of sleepTime when less Invaders
	 * @param monsters The table of monsters to move
	 * @param tanks The table of tank to check collision
	 * @param work The stop loop value 
	 * @param max The max coordinates of the screen
	 */
	public MoveMonstersThread(String nom, int sleepTime, int acceleration, Movable monsters[], Movable tanks[], Boolean work, Coordinates max)
	{
		super(nom);
		this.sleepTime = sleepTime;
		this.acceleration = acceleration;
		this.monsters = monsters;
		this.tanks = tanks;
		this.work = work;
		this.max = max;
		this.etat = Etat.LEFT1;
	}

	/**
	 * This constructors set the variable needed by the thread.
	 * @param nom Name of the Thread
	 * @param sleepTime Number of millisecond between each move
	 * @param monsters The table of monsters to move
	 * @param tanks The table of tank to check collision
	 * @param work The stop loop value
	 * @param max The max coordinates of the screen
	 */
	public MoveMonstersThread(String nom, int sleepTime, Movable monsters[], Movable tanks[], Boolean work, Coordinates max)
	{
		super(nom);
		this.sleepTime = sleepTime;
		this.monsters = monsters;
		this.tanks = tanks;
		this.work = work;
		this.max = max;
		this.acceleration = DEFAULT_ACCELERATION;
		this.etat = Etat.LEFT1;
	}

	/**
	 * This constructors set the variable needed by the thread.
	 * @param nom Name of the Thread
	 * @param monsters The table of monsters to move
	 * @param tanks The table of tank to check collision
	 * @param work The stop loop value
	 * @param max The max coordinates of the screen
	 */
	public MoveMonstersThread(String nom, Movable monsters[], Movable tanks[], Boolean work, Coordinates max)
	{
		super(nom);
		this.monsters = monsters;
		this.tanks = tanks;
		this.work = work;
		this.max = max;
		this.acceleration = DEFAULT_ACCELERATION;
		this.sleepTime = DEFAULT_SLEEP_TIME;
		this.etat = Etat.LEFT1;
	}
	
	//******************** Main ***********************
	
	/**
	 * Main of the thread.
	 * It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		// TODO remove Debug msg
		System.out.println("\nBegin MoveMonstersThread");
		while(this.work.booleanValue())
		{
			// TODO remove Debug msg
			System.out.println(Arrays.toString(this.monsters));
			try
			{
				move();
			}
			catch (OutOfGridException e1)
			{
				// TODO Stop Game ?
				System.out.println("OutOfGrid : " + e1.getOutOfGridException());
			}
			
			testCollision();

			try
			{
				Thread.sleep(this.sleepTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		// TODO remove Debug msg
		System.out.println("End MoveMonstersThread\n");
	}
	
	//******************** Method ***********************
	
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
		{
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
						System.out.println("Collision !");
					}
				}
			}
		}
		
	}
	
	// TODO Useless?
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
						this.monsters[i].getArea().getSize().getX() + delta.getX() > this.max.getX()
					|| this.monsters[i].getArea().getPosition().getY() + 
						this.monsters[i].getArea().getSize().getY() + delta.getY() > this.max.getY()
					|| this.monsters[i].getArea().getPosition().getX() + delta.getX()< 0
					|| this.monsters[i].getArea().getPosition().getY() + delta.getY() < 0)
				{
					throw new OutOfGridException(delta);
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
						this.monsters[i].getArea().getSize().getX() + dx > this.max.getX()
					|| this.monsters[i].getArea().getPosition().getY() + 
						this.monsters[i].getArea().getSize().getY() + dy > this.max.getY()
					|| this.monsters[i].getArea().getPosition().getX() + dx < 0
					|| this.monsters[i].getArea().getPosition().getY() + dy < 0)
				{
					//TODO Kill when Y coordinates is less than 0?
					throw new OutOfGridException(new Coordinates(dx,dx));
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
			case LEFT1:
				try
				{
					moveTab(DEFAULT_X_MOVE, 0);
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.RIGHT2;
					move();
				}
				break;
			case RIGHT2:
				moveTab(0, -DEFAULT_Y_MOVE);
				this.etat = Etat.RIGHT3;
				break;
			case RIGHT3:
				try
				{
					moveTab(-DEFAULT_X_MOVE, 0);
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.LEFT4;
					move();
				}
				break;
			case LEFT4:
				moveTab(0, -DEFAULT_Y_MOVE);
				this.etat = Etat.LEFT1;
				break;
		}
	}
}
