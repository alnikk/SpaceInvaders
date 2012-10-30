/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.util.Arrays;

// TODO Comment Class

/**
 * 
 * @author Gallet Guyon
 */
public class MoveMonstersThread extends Thread
{
	//***************** Variable *************************
	private enum Etat {GAUCHE1, DROITE1, DROITE2, GAUCHE2};
	
	private Etat etat;
	
	private int sleepTime;
	
	private int acceleration;
	
	private Movable monsters[];
	
	private Movable tanks[];
	
	private Boolean work;
	
	private final Coordinates max;

	//***************** Constant *************************
	
	private final static int DEFAULT_SLEEP_TIME = 100;
	
	private final static int DEFAULT_ACCELERATION = 2;
	
	private final static int DEFAULT_X_MOVE = 10;
	
	private final static int DEFAULT_Y_MOVE = 10;
	
	//***************** Constructors *************************

	/**
	 * @param nom 
	 * @param sleepTime
	 * @param acceleration
	 * @param monsters
	 * @param tanks 
	 * @param work
	 * @param max
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
		this.etat = etat.GAUCHE1;
	}

	/**
	 * @param nom 
	 * @param sleepTime
	 * @param monsters
	 * @param tanks 
	 * @param work
	 * @param max
	 */
	public MoveMonstersThread(String nom, int sleepTime, Movable monsters[], Movable tanks[], Boolean work, Coordinates max)
	{
		super(nom);
		this.sleepTime = sleepTime;
		this.monsters = monsters;
		this.tanks = tanks;
		this.work = work;
		this.max = max;
		this.acceleration = this.DEFAULT_ACCELERATION;
		this.etat = etat.GAUCHE1;
	}

	/**
	 * @param nom 
	 * @param monsters
	 * @param tanks 
	 * @param work
	 * @param max
	 */
	public MoveMonstersThread(String nom, Movable monsters[], Movable tanks[], Boolean work, Coordinates max)
	{
		super(nom);
		this.monsters = monsters;
		this.tanks = tanks;
		this.work = work;
		this.max = max;
		this.acceleration = this.DEFAULT_ACCELERATION;
		this.sleepTime = this.DEFAULT_SLEEP_TIME;
		this.etat = etat.GAUCHE1;
	}
	
	//******************** Main ***********************
	
	public void run()
	{
		// TODO remove Debud msg
		System.out.println("\nBegin MoveMonstersThread");
		while(this.work.booleanValue())
		{
			// TODO remove Debud msg
			System.out.println(Arrays.toString(this.monsters));
			try
			{
				move();
			}
			catch (OutOfGridException e1)
			{
				System.out.println("OutOfGrid : " + e1.getOutOfGridException());
				e1.printStackTrace();
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
		// TODO remove Debud msg
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
				if(this.tanks[i].overlapping(this.monsters[j]) != null)
				{
					this.tanks[i].setAlive(false);
					this.monsters[j].setAlive(false);
					this.work = false;
					// TODO Remove debug msg
					System.out.println("Collision !");
				}
			}
		}
		
	}
	
	private void moveTab(Coordinates delta) throws OutOfGridException
	{
		int i, nbMonsters;
		nbMonsters = this.monsters.length;
		for(i=0; i < nbMonsters; i++)
		{
			try
			{
				if(this.monsters[i].getArea().getPosition().getX() + 
						this.monsters[i].getArea().getSize().getX() > this.max.getX()
					&& this.monsters[i].getArea().getPosition().getY() + 
						this.monsters[i].getArea().getSize().getY() > this.max.getY()
					&& this.monsters[i].getArea().getPosition().getX() < 0
					&& this.monsters[i].getArea().getPosition().getY() < 0)
				{
					System.out.println("Negative");
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
	
	private void moveTab(int dx, int dy) throws OutOfGridException
	{
		int i, nbMonsters;
		nbMonsters = this.monsters.length;
		for(i=0; i < nbMonsters; i++)
		{
			try
			{
				if(this.monsters[i].getArea().getPosition().getX() + 
						this.monsters[i].getArea().getSize().getX() > this.max.getX()
					&& this.monsters[i].getArea().getPosition().getY() + 
						this.monsters[i].getArea().getSize().getY() > this.max.getY()
					&& this.monsters[i].getArea().getPosition().getX() < 0
					&& this.monsters[i].getArea().getPosition().getY() < 0)
					throw new OutOfGridException(new Coordinates(dx,dx));
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
	
	private void move() throws OutOfGridException
	{
		switch(this.etat)
		{
			case GAUCHE1:
				moveTab(DEFAULT_X_MOVE, 0);
				this.etat = etat.DROITE1;
				break;
			case DROITE1:
				moveTab(0, -DEFAULT_Y_MOVE);
				this.etat = etat.DROITE2;
				break;
			case DROITE2:
				moveTab(-DEFAULT_X_MOVE, 0);
				this.etat = etat.GAUCHE2;
				break;
			case GAUCHE2:
				moveTab(0, -DEFAULT_Y_MOVE);
				this.etat = etat.GAUCHE1;
				break;
		}
	}
}
