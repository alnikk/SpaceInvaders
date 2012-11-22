/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import fr.iutvalence.java.projet.spaceinvaders.enumerations.Etat;
import fr.iutvalence.java.projet.spaceinvaders.exceptions.NegativeSizeException;
import fr.iutvalence.java.projet.spaceinvaders.exceptions.OutOfGridException;
import fr.iutvalence.java.projet.spaceinvaders.interfaces.Display;
import fr.iutvalence.java.projet.spaceinvaders.interfaces.MonsterControler;
import fr.iutvalence.java.projet.spaceinvaders.interfaces.TankControler;

/**
 * A space invader game.<br/>
 * @author Gallet Guyon
 */
public class SpaceInvadersMaVa extends SpaceInvaders implements TankControler, MonsterControler
{

	// ********************* Constructors ************************

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all to default value. If you don't want to use this default
	 * characteristic use another constructor
	 * @param d The display object to use.
	 */
	public SpaceInvadersMaVa(Display d)
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
	public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Display d)
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
	public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Coordinates max, Display d)
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
	public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, Display d)
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
	public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, int acceleration, Display d)
	{
		super(nbMonsters, nbTanks, max, sleepTime, acceleration, d);
	}

	// ********************* Main ************************

	/**
	 * Main of the thread. It create to other threads for Invaders and for Tanks
	 */
	public void run()
	{
		while(true)
		{
			moveShoots();

			testCollision();

			this.display.show(this.tanks,this.monsters,this.shoots,this.maxSize);

			if (this.countAlive(this.tanks) == 0 || this.countAlive(this.monsters) == 0)
				break;

			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
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
			Thread.sleep((long) ((Math.sqrt(((double) countAlive(this.monsters) / this.monstersAmount)) * this.sleepTime)+ this.timeDifficulty));
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
					moveTab(new Coordinates(this.coorMove.getX(), 0), this.monsters);
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
					moveTab(new Coordinates(0, -this.coorMove.getY()), this.monsters);
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
					moveTab(new Coordinates(-this.coorMove.getX(), 0), this.monsters);
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
					moveTab(new Coordinates(0, -this.coorMove.getY()), this.monsters);
				}
				catch (OutOfGridException e1)
				{
					e1.kill();
					monstersMove();
				}
				this.etat = Etat.LEFT_UP;
				break;
		}
		return (int) (Math.sqrt(((double) countAlive(this.monsters) / this.monstersAmount)) * this.sleepTime);
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
			if (this.tanks[i] != null && this.tanks[i].isAlive())
			{
				for (j = this.monstersAmount - 1; j > 0; j--)
				{
					if (this.monsters[i] != null && this.monsters[j].isAlive())
					{
						if (((this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea().getSize()
								.getX()) / 2) - (this.sizeShoots.getX() / 2) < (this.tanks[i].getArea().getPosition()
										.getX() + this.tanks[i].getArea().getSize().getX()) && (this.monsters[j].getArea()
												.getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2)
												- (this.sizeShoots.getX() / 2) > (this.tanks[i].getArea().getPosition().getX()))
												|| ((this.monsters[j].getArea().getPosition().getX() + (this.monsters[j].getArea()
														.getSize().getX()) / 2) + (this.sizeShoots.getX() / 2) < (this.tanks[i]
																.getArea().getPosition().getX() + this.tanks[i].getArea().getSize().getX()) && (this.monsters[j]
																		.getArea().getPosition().getX() + (this.monsters[j].getArea().getSize().getX()) / 2)
																		+ (this.sizeShoots.getX() / 2) > (this.tanks[i].getArea().getPosition().getX())))
						{
							if (invaderAbove != null)
							{
								if (invaderAbove.getArea().getPosition().getY() > this.monsters[j].getArea()
										.getPosition().getY())
									invaderAbove = this.monsters[j];
							}
							else
								invaderAbove = this.monsters[j];
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

		for (i = 0; i < (this.monstersAmount + this.tanksAmount); i++)
		{
			if (this.shoots[i] != null && this.shoots[i].isAlive())
			{
				try
				{
					if (this.shoots[i].getDirection() < 0)
						this.moveTab(new Coordinates(0, -this.moveShoots.getY()), this.shoots);
					if (this.shoots[i].getDirection() > 0)
						this.moveTab(new Coordinates(0, this.moveShoots.getY()), this.shoots);
				}
				catch (OutOfGridException e)
				{
					e.kill();
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

		for (i = 0; i < this.tanksAmount; i++)
		{
			if (this.tanks[i] != null && this.tanks[i].isAlive())
			{
				x = (int) (Math.random() * 10);
				neg = Math.round(Math.random());

				if (neg == 0)
					neg = -1;

				try
				{
					if ((this.tanks[i].getArea().getPosition().getX() + (int) (x * neg)) > 0
							&& (this.tanks[i].getArea().getPosition().getX() + this.tanks[i].getArea().getSize().getX() + (int) (x * neg)) < this.maxSize
							.getX())
					{
						this.tanks[i].move(new Coordinates((int) (x * neg), 0));
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
	 * Allow tank(s) to shoot Invaders
	 */
	public void tankShoot()
	{
		int i;

		for (i = 0; i < this.tanksAmount; i++)
		{
			if (this.tanks[i] != null && this.tanks[i].isAlive())
				this.shootFrom(this.tanks[i], 1);
		}
	}
}
