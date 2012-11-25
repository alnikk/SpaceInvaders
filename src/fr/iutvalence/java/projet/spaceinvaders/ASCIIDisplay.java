/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;

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
	 * Array containing all Movable elements to draw.
	 */
	private Movable[] elements;
	
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
		
		for (i = 0; i < this.elements.length; i++)
		{
			if (this.elements[i] != null && this.elements[i].isAlive())
			{
				y = this.elements[i].getArea().getPosition().getY();
				while (y < (this.elements[i].getArea().getSize().getY() + this.elements[i].getArea().getPosition().getY()))
				{
					x = this.elements[i].getArea().getPosition().getX();
					while (x < (this.elements[i].getArea().getSize().getX() + this.elements[i].getArea().getPosition().getX()))
					{
						switch(this.elements[i].getType())
						{
							case TANK:
								System.out.println(x +" "+ y + " " + this.elements[i]);
								grid[x][y] = DEFAULT_LETTRE_TANKS;
								break;
							case MONSTER:
								grid[x][y] = DEFAULT_LETTRE_MONTERS;
								break;
							case SHOOT:
								grid[x][y] = DEFAULT_LETTRE_SHOOTS;
								break;
							default:
								break;
						}
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
	public void show()
	{
		char[][] grid = gridImage();
		printGrid(grid);
	}
	
	@Override
	public void init(KeyListener e, Movable[] elements, Coordinates maxSize)
	{
		this.elements = elements;
		this.maxSize = maxSize;
	}
}
