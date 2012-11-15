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
public class SpaceInvadersMsVs extends SpaceInvaders implements TankControler, MonsterControler
{
	// ********************* Constructors ************************

	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It set all to default value. If you don't want to use this default
	 * characteristic use another constructor
	 */
	public SpaceInvadersMsVs()
	{
		super();
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
		super(nbMonsters, nbTanks);
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
		super(nbMonsters, nbTanks, max);
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
		super(nbMonsters, nbTanks, max, sleepTime);
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
		super(nbMonsters, nbTanks, max, sleepTime, acceleration);
	}

	// ********************* Main ************************

	/**
	 * Main of the thread. It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		this.work = true;
		while (this.work)
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

			//tankShoot();

			testCollision();

			if (this.countAlive(this.tanks) == 0 || this.countAlive(this.monsters) == 0)
				this.work = false;

			show();
			waitLoop();
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
			// TODO sleepTime constant...
			// expression is a.x type. Add a.x + c with c playable. It have to don't affect sleepTime
			Thread.sleep((long) (Math.sqrt(((double) countAlive(this.monsters) / this.monstersAmount)) * this.sleepTime));
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
	 * @return 
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
			} // TODO Shoot's acceleration
			shootFrom(invaderAbove, -1);
		}
	}

	// [[[[[[[[[[[[[ Shoots behavior ]]]]]]]]]]]]]

	/**
	 * Allow to move shoot
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
	 * Allow tank to shoot Invaders
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

	// [[[[[[[[[[[[[ Display ]]]]]]]]]]]]]

	/**
	 * Create grid image to table of character
	 * 
	 * @return 2D table of character
	 */
	private char[][] gridImage()
	{
		int i, x, y;
		char grid[][] = new char[this.maxSize.getX()][this.maxSize.getY()];

		for (y = 0; y < this.maxSize.getY(); y++)
		{
			for (x = 0; x < this.maxSize.getX(); x++)
			{
				grid[x][y] = ' ';
			}
		}

		for (i = 0; i < this.tanksAmount; i++)
		{
			if (this.tanks[i] != null && this.tanks[i].isAlive())
			{
				y = this.tanks[i].getArea().getPosition().getY();
				while (y < (this.tanks[i].getArea().getSize().getY() + this.tanks[i].getArea().getPosition().getY()))
				{
					x = this.tanks[i].getArea().getPosition().getX();
					while (x < (this.tanks[i].getArea().getSize().getX() + this.tanks[i].getArea().getPosition().getX()))
					{
						grid[x][y] = 'T';
						x++;
					}
					y++;
				}
			}
		}

		for (i = 0; i < this.monstersAmount; i++)
		{
			if (this.monsters[i] != null && this.monsters[i].isAlive())
			{
				y = this.monsters[i].getArea().getPosition().getY();
				while (y < (this.monsters[i].getArea().getSize().getY() + this.monsters[i].getArea().getPosition()
						.getY()))
				{
					x = this.monsters[i].getArea().getPosition().getX();
					while (x < (this.monsters[i].getArea().getSize().getX() + this.monsters[i].getArea().getPosition()
							.getX()))
					{
						grid[x][y] = 'M';
						x++;
					}
					y++;
				}
			}
		}

		for (i = 0; i < (this.monstersAmount + this.tanksAmount); i++)
		{
			if (this.shoots[i] != null && this.shoots[i].isAlive())
			{
				y = this.shoots[i].getArea().getPosition().getY();
				while (y < (this.shoots[i].getArea().getSize().getY() + this.shoots[i].getArea().getPosition().getY()))
				{
					x = this.shoots[i].getArea().getPosition().getX();
					while (x < (this.shoots[i].getArea().getSize().getX() + this.shoots[i].getArea().getPosition()
							.getX()))
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
	 * 
	 * @param grid
	 *            the grid to print
	 */
	private void printGrid(char[][] grid)
	{
		int x, y;

		for (y = this.maxSize.getY() - 1; y >= 0; y--)
		{
			for (x = 0; x < this.maxSize.getX(); x++)
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
	public void show()
	{
		char[][] grid = gridImage();
		printGrid(grid);
	}

	// [[[[[[[[[[[[[ Others ]]]]]]]]]]]]]

	@Override
	public String toString()
	{
		return "SpaceInvaders [tabMonster=" + Arrays.toString(this.monsters) + "tabTank=" + Arrays.toString(this.tanks)
				+ "]";
	}
}
