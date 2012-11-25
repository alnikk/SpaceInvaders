/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;
import java.util.Arrays;

import fr.iutvalence.java.projet.spaceinvaders.enumerations.Etat;
import fr.iutvalence.java.projet.spaceinvaders.enumerations.Type;

/**
 * A space invader game.<br/>
 * 
 * @author Gallet Guyon
 */
public class SpaceInvadersMsVs extends SpaceInvaders implements TankControler, MonsterControler
{
	// ********************* Constructors ************************

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all to default value. If you don't want to use this default
	 * characteristic use another constructor
	 * @param d The display object to use.
	 */
	public SpaceInvadersMsVs(Display d)
	{
		super(d);
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
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Display d)
	{
		super(nbMonsters, nbTanks, d);
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
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max, Display d)
	{
		super(nbMonsters, nbTanks, max, d);
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
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, Display d)
	{
		super(nbMonsters, nbTanks, max, sleepTime, d);
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
	public SpaceInvadersMsVs(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, int acceleration, Display d)
	{
		super(nbMonsters, nbTanks, max, sleepTime, acceleration, d);
	}


	// ********************* Main ************************

	/**
	 * Main of the thread. It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		this.display.init(this.listenController, this.elements,this.maxSize);
		while (true)
		{			
			moveShoots();
			
			monstersMove();
			
			monsterShoot();

			try
			{
				tankMove();
			}
			catch (OutOfGridException e)
			{
				java.awt.Toolkit.getDefaultToolkit().beep();
			}

			tankShoot();

			testCollision();

			this.display.show();
			
			if (this.countAlive(this.elements, Type.TANK) == 0 || this.countAlive(this.elements, Type.MONSTER) == 0)
				break;
			
			waitLoop();
		}
	}
	
	/**
	 * @param k
	 */
	public void setControleur(KeyListener k)
	{
		this.listenController = k;
	}

	public boolean working()
	{
		return (this.countAlive(this.elements, Type.TANK) == 0 || this.countAlive(this.elements, Type.MONSTER) == 0);
	}
	// ******************** Method ***********************
	
	// [[[[[[[[[[[[[ Monsters behavior ]]]]]]]]]]]]]

	/**
	 * This method wait a time in function of sleepTime value and of monster alive's number
	 */
	public void waitLoop()
	{
		try
		{
			Thread.sleep((long) ((Math.sqrt(((double) countAlive(this.elements, Type.MONSTER) / this.monstersAmount)) * this.sleepTime)+ this.timeDifficulty));
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * This method allows to move Invaders once that is to say to right, down, or left. It follow scheme by itself :
	 * <ul>
	 * <li>right</li>
	 * <li>down</li>
	 * <li>left</li>
	 * <li>down</li>
	 * <li>right</li>
	 * </ul>
	 * @return (integer) this returns the wait time between each move. When it's equals to 0
	 * 			the game is finished.
	 */
	public int monstersMove()
	{
		switch (this.etat)
		{
			case LEFT_UP:
				try
				{
					moveTab(new Coordinates(this.coorMove.getX(), 0), this.elements, Type.MONSTER);
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.RIGHT_UP;
					monstersMove();
				}
				break;
			case RIGHT_UP:
				try
				{
					moveTab(new Coordinates(0, -this.coorMove.getY()), this.elements, Type.MONSTER);
				}
				catch (OutOfGridException e1)
				{
					e1.kill();
					monstersMove();
				}
				this.etat = Etat.RIGHT_BOTTOM;
				break;
			case RIGHT_BOTTOM:
				try
				{
					moveTab(new Coordinates(-this.coorMove.getX(), 0), this.elements, Type.MONSTER);
				}
				catch (OutOfGridException e)
				{
					this.etat = Etat.LEFT_BOTTOM;
					monstersMove();
				}
				break;
			case LEFT_BOTTOM:
				try
				{
					moveTab(new Coordinates(0, -this.coorMove.getY()), this.elements, Type.MONSTER);
				}
				catch (OutOfGridException e1)
				{
					e1.kill();
					monstersMove();
				}
				this.etat = Etat.LEFT_UP;
				break;
		}
		return (int) (Math.sqrt(((double) countAlive(this.elements, Type.MONSTER) / this.monstersAmount)) * this.sleepTime);
	}

	/**
	 * Method for shoot on tanks. It search the invaders just above tanks and shoot.
	 */
	public void monsterShoot()
	{		
		int i, j;
		Movable invaderAbove = null;
		for (i = 0; i < this.tanksAmount; i++)
		{
			if (this.elements[i] != null && this.elements[i].isAlive() && this.elements[i].getType() == Type.TANK)
			{	
				for (j = 0; j < this.elements.length; j++)
				{
					if (this.elements[j] != null && this.elements[j].isAlive() && this.elements[j].getType() ==  Type.MONSTER)
					{
						if (((this.elements[j].getArea().getPosition().getX() + (this.elements[j].getArea().getSize()
								.getX()) / 2) - (this.sizeShoots.getX() / 2) < (this.elements[i].getArea().getPosition()
										.getX() + this.elements[i].getArea().getSize().getX()) && (this.elements[j].getArea()
												.getPosition().getX() + (this.elements[j].getArea().getSize().getX()) / 2)
												- (this.sizeShoots.getX() / 2) > (this.elements[i].getArea().getPosition().getX()))
												|| ((this.elements[j].getArea().getPosition().getX() + (this.elements[j].getArea()
														.getSize().getX()) / 2) + (this.sizeShoots.getX() / 2) < (this.elements[i]
																.getArea().getPosition().getX() + this.elements[i].getArea().getSize().getX()) && (this.elements[j]
																		.getArea().getPosition().getX() + (this.elements[j].getArea().getSize().getX()) / 2)
																		+ (this.sizeShoots.getX() / 2) > (this.elements[i].getArea().getPosition().getX())))
						{
							if (invaderAbove != null)
							{
								if (invaderAbove.getArea().getPosition().getY() > this.elements[j].getArea()
										.getPosition().getY())
									invaderAbove = this.elements[j];
							}
							else
								invaderAbove = this.elements[j];
						}
						
					}
				}
			}
			shootFrom(invaderAbove, -1);
		}
	}

	// [[[[[[[[[[[[[ Shoots behavior ]]]]]]]]]]]]]

	/**
	 * Allow to move shoot(s)
	 */
	private void moveShoots()
	{
		int i;

		for (i = 0; i < this.elements.length; i++)
		{
			if (this.elements[i] != null && this.elements[i].isAlive() && this.elements[i].getType() == Type.SHOOT)
			{
					if (this.elements[i].getDirection() < 0)
					{
						try
						{
							if(!this.isOutOfGrid(this.elements[i]))
							try
							{
								this.elements[i].move(new Coordinates(0, -this.moveShoots.getY()));
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
					if (this.elements[i].getDirection() > 0)
					{
						try
						{
							if(!this.isOutOfGrid(this.elements[i]))
							try
							{
								this.elements[i].move(new Coordinates(0, this.moveShoots.getY()));
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

	// [[[[[[[[[[[[[ Controls ]]]]]]]]]]]]]

	/**
	 * Allows random tank control
	 * 
	 * @throws OutOfGridException
	 *             Indicate when Tank want to go over the screen
	 */
	public void tankMove() throws OutOfGridException
	{
		int i;
		int x;
		long neg;

		for (i = 0; i < this.elements.length; i++)
		{
			if (this.elements[i] != null && this.elements[i].isAlive() && this.elements[i].getType() == Type.TANK)
			{
				x = (int) (Math.random() * this.coorMove.getX());
				neg = Math.round(Math.random());

				if (neg == 0)
					neg = -1;

				try
				{
					if ((this.elements[i].getArea().getPosition().getX() + (int) (x * neg)) > 0
							&& (this.elements[i].getArea().getPosition().getX() + this.elements[i].getArea().getSize().getX() + (int) (x * neg)) < this.maxSize
							.getX())
					{
						this.elements[i].move(new Coordinates((int) (x * neg), 0));
					}
					else
					{
						throw new OutOfGridException(this.elements[i]);
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
	 * Allow tank(s) to shoot Invaders
	 */
	public void tankShoot()
	{
		int i;

		for (i = 0; i < this.tanksAmount; i++)
		{
			if (this.elements[i] != null && this.elements[i].isAlive())
				this.shootFrom(this.elements[i], 1);
		}
	}
	
	@Override
	public void tankMove(Coordinates delta) throws OutOfGridException
	{
		int i;
		for(i = 0 ; i < this.elements.length; i++)
		{
			if(this.elements[i] != null && this.elements[i].isAlive() && this.elements[i].getType() == Type.TANK)
			{
				try
				{
					this.elements[i].move(delta);
				}
				catch (NegativeSizeException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}