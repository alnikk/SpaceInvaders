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
public class SpaceInvadersMaVs extends SpaceInvaders
{
	// ************************** Constructors **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the number of tanks to 1, the number of monsters to 20, the X axis to
	 * 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructor
	 */
	public SpaceInvadersMaVs()
	{
		super();
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor sets the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors
	 * 
	 * @param nbMonster
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 */
	public SpaceInvadersMaVs(int nbMonster, int nbTank)
	{
		super(nbMonster, nbTank);
	}

	/**
	 * Initialize the game.<br/>
	 * This constructor no default value.
	 * 
	 * @param nbMonster
	 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank
	 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 * @param Max
	 *            Set the Max point of the grid (Coordinates)
	 */
	public SpaceInvadersMaVs(int nbMonster, int nbTank, Coordinates Max)
	{
		super(nbMonster, nbTank, Max);
	}

	// ************************** Methods **************************//

	/**
	 * This method begins the game. It's the only entry point.
	 */
	public void run()
	{
		MonstersBehaviorThread monsters = new MonstersBehaviorThread("Monsters", 1000, this.monsters, this.tanks,
				this.shoots, this.work, this.maxSize);
		monsters.start();
		while (true)
		{
			try
			{
				monsters.join();
				break;
			}
			catch (InterruptedException e)
			{
			}
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
	private void randomMove() throws OutOfGridException
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
	private void tankShoot()
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
