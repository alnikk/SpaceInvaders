/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This class allows to print the state of the game into console.<br/>
 * The display is in ASCII arts, that is to say drawable elements are represented by ASCII digit who can be changed by changing constants.<br/>
 * For example : invaders area is represented by many 'M' character.<br/>
 * This class implements Display
 * @see Display 
 * @author Gallet Guyon
 */
public class ASCIIDisplay implements Display
{
	//*********** Constant *******************
	/**
	 * This constant used to defines the letter who fill the background  
	 */
	private static final char DEFAULT_LETTRE_EMPTY = ' ';
	
	/**
	 * This constant used to fill tanks' area.<br/>
	 * So you can identify tank in the console screen by this letter.  
	 */
	private static final char DEFAULT_LETTRE_TANKS = 'T';
	
	/**
	 * This constant used to fill monsters' area.<br/>
	 * So you can identify monsters in the console screen by this letter.  
	 */
	private static final char DEFAULT_LETTRE_MONTERS = 'M';
	
	/**
	 * This constant used to fill shoots' area.<br/>
	 * So you can identify shoots in the console screen by this letter.  
	 */
	private static final char DEFAULT_LETTRE_SHOOTS = 'S';
	
	
	//*********** Variable *******************
	/**
	 * It defines the number of monsters you have in tabMonster.
	 */
	private int monstersAmount;

	/**
	 * It defines the number of tank you have in tabTank.
	 */
	private int tanksAmount;
	
	/**
	 * Array containing all monsters to draw.
	 */
	private Movable[] monsters;

	/**
	 * Array containing all tanks to draw.
	 */
	private Movable[] tanks;

	/**
	 * Array containing all shoots to draw.
	 */
	private Movable[] shoots;
	
	/**
	 * The maximum size of the area.<br/>
	 * No elements can move (so be drown) over this bound.
	 */
	private Coordinates maxSize;
	
	/**
	 * Constructor of the class.<br/>
	 * Do nothing, but just used to create new ASCIIDisplay object. 
	 */
	public ASCIIDisplay()
	{
	}

	/**
	 * This method can make 2D table of characters from the state of elements' tables.
	 * @return 2D table of character who used to display
	 */
	private char[][] gridImage()
	{
		int i, x, y;
		char grid[][] = new char[this.maxSize.getX()][this.maxSize.getY()];

		for (y = 0; y < this.maxSize.getY(); y++)
		{
			for (x = 0; x < this.maxSize.getX(); x++)
			{
				grid[x][y] = DEFAULT_LETTRE_EMPTY;
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
						grid[x][y] = DEFAULT_LETTRE_TANKS;
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
						grid[x][y] = DEFAULT_LETTRE_MONTERS;
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
						grid[x][y] = DEFAULT_LETTRE_SHOOTS;
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
	 *            the 2D grid to print. It can be made by gridImage function.
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
