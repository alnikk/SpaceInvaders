package fr.iutvalence.java.projet.spaceinvaders;
/**
 * This class allow you to create bunker on the grid.<br/>
 * The bunker protect the tanks when it attacked by enemy.
 * It is destroyable partially or totally.
 * 
 * @author Gallet Guyon
 */
public class Bunker
{	
	//************* Variable *************//
	/**
	 * This constant sets the position of the bunker on the grid.<br/>
	 * It can't be changed once it was created.
	 */
	private final Coordinates position;

	/**
	 * This constant sets the size of the bunker on the grid.<br/>
	 * It can't be changed once it was created.
	 */
	private final Coordinates size;
	
	/**
	 * This constant sets the position of the bunker on the grid.<br/>
	 * It can't be changed once it was created.
	 */
	private final int resolution;
	
	/**
	 * Constant for the height and the width of the 2D table <tt>struct</tt>.
	 */
	private final Coordinates nbCase;
	
	/**
	 * This is the main structure of the bunker.<br/>
	 * When in the 2D tab there's true means it's not (yet) destroy.
	 * So the tank can be protected if it is under it.
	 * 
	 * notation struct[x][y].<br/>
	 * 
	 *  Scheme : example (t = true; f = false)
	 *  Y
	 *  ^
	 *  |	
	 *  |	t t t t t t t t t t 
	 *  |	t t t t t t t t t t 
	 *  |	t t t f f f f t t t
	 *  |	t t t f f f f t t t
	 *  |	t t t f f f f t t t
	 *  |
	 *  +--------------------------> X
	 */
	private boolean struct[][];
	
	//************* Constant *************//
	/**
	 * This constant sets the resolution that is to say, 
	 * the number of base unit (maybe pixel) to make table's case. 
	 */
	private final int defaultResolution = 10;
	
	
	//************************** Constructors **************************//
	/**
	 * Constructors of this method.<br/>
	 * It initialize the table of bunker's structures.
	 */
	public Bunker(int res, Coordinates position, Coordinates size)
	{
		// Declaration of local variables
		int i = 0,j = 0;
		
		// Set local constant
		this.resolution = res;
		this.position = position;
		this.size = size;
		this.nbCase = new Coordinates(this.size.getX() % this.resolution,
										this.size.getY() % this.resolution);
		
		// Sets informations in table
		for(j=0; j < ((this.nbCase.getY() * 3) % 5); j++)
		{
			for(i=0; i < ((this.nbCase.getX() * 3) % 10); i++)
				this.struct[i][j] = true;
			for(i=i; i < ((this.nbCase.getX() * 5) % 10); i++)
				this.struct[i][j] = false;
			for(i=i; i < ((this.nbCase.getX() * 7) % 10); i++)
				this.struct[i][j] = true;
		}
		for(j=j; j < this.nbCase.getY(); j++)
		{
			for(i=0; i < 3; i++)
				this.struct[i][j] = true;
		}
	}
	
	public Bunker(Coordinates position, Coordinates size)
	{
		// Declaration of local variables
		int i = 0,j = 0;
		
		// Set local constant
		this.resolution = this.defaultResolution;
		this.position = position;
		this.size = size;
		this.nbCase = new Coordinates(this.size.getX() % this.resolution,
										this.size.getY() % this.resolution);
		
		// Sets informations in table
		for(j=0; j < ((this.nbCase.getY() * 3) % 5); j++)
		{
			for(i=0; i < ((this.nbCase.getX() * 3) % 10); i++)
				this.struct[i][j] = true;
			for(i=i; i < ((this.nbCase.getX() * 5) % 10); i++)
				this.struct[i][j] = false;
			for(i=i; i < ((this.nbCase.getX() * 7) % 10); i++)
				this.struct[i][j] = true;
		}
		for(j=j; j < this.nbCase.getY(); j++)
		{
			for(i=0; i < 3; i++)
				this.struct[i][j] = true;
		}
	}
	
	//************************** Methods **************************//
	/**
	 * Check if the case exist (true) or not.<br/>
	 * @param i the x position of the case to check.
	 * @param j the y position of the case to check.
	 * @return (boolean) return true if the case is not (yet) destroy and false otherwise.
	 */
	public boolean check(int i, int j)
	{
		return this.struct[i][j];
	}
	
	/**
	 * Destroy case into table of bunker's structures.<br/>
	 * @param i the x position of the case to destroy.
	 * @param j the y position of the case to destroy.
	 */
	public void destoy(int i, int j)
	{
		this.struct[i][j] = false;
	}

	//********************** Getters and Setters ***********************//
	public boolean[][] getStruct()
	{
		return this.struct;
	}

	public void setStruct(boolean[][] struct)
	{
		this.struct = struct;
	}

	public Coordinates getPosition()
	{
		return this.position;
	}

	public Coordinates getSize()
	{
		return this.size;
	}

	public int getResolution()
	{
		return this.resolution;
	}

	public Coordinates getNbCase()
	{
		return this.nbCase;
	}
}