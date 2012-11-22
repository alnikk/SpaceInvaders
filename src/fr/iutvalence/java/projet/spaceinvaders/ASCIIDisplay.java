/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author Gallet Guyon
 *
 */
public class ASCIIDisplay implements Display
{
	/**
	 * It defines the number of monsters you have in tabMonster.
	 */
	protected int monstersAmount;

	/**
	 * It defines the number of tank you have in tabTank.
	 */
	protected int tanksAmount;
	
	/**
	 * Array containing all monsters
	 */
	protected Movable[] monsters;

	/**
	 * Array containing all tanks.
	 */
	protected Movable[] tanks;

	/**
	 * Array containing all shoots.
	 */
	protected Movable[] shoots;
	
	/**
	 * The maximum size of the area
	 */
	protected Coordinates maxSize;
	
	/**
	 *  
	 */
	public ASCIIDisplay()
	{
	}

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

	@Override
	public void show(Movable tanks[], Movable monsters[], Movable shoots[], Coordinates maxSize)
	{
		this.monstersAmount = monsters.length;
		this.tanksAmount = tanks.length;
		this.tanks = tanks;
		this.monsters = monsters;
		this.shoots = shoots;
		this.maxSize = maxSize;
		char[][] grid = gridImage();
		printGrid(grid);
	}
}
