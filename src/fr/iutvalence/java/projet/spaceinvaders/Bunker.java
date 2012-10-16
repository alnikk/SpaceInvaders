package fr.iutvalence.java.projet.spaceinvaders;

// FIXME (FIXED) spellcheck comment
/**
 * This class allows you to manage bunker on the grid.<br/>
 * The bunker protects the tank when attacked by enemy.
 * It is partially or totally destroyable.
 * 
 * @author Gallet Guyon
 */
public class Bunker
{	
	//************* Variable *************//
	
	// FIXME this is not a constant. If so, define it as a real one
	/**
	 * This constant sets the position of the bunker on the grid.<br/>
	 * It can't be changed once it was created.
	 */
	private final Coordinates position;

	// FIXME this is not a constant. If so, define it as a real one
	/**
	 * This constant sets the size of the bunker on the grid.<br/>
	 * It can't be changed once it was created.
	 */
	private final Coordinates size;
	
	// FIXME this is not a constant. If so, define it as a real one
	/**
	 * This constant sets the position of the bunker on the grid.<br/>
	 * It can't be changed once it was created.
	 */
	private final int resolution;
	
	// FIXME this is not a constant. If so, define it as a real one
	/**
	 * Constant for the height and the width of the 2D table <tt>struct</tt>.
	 */
	// FIXME rename attribute (nbCells ?)
	private final Coordinates nbCase;
	
	// FIXME (FIXED) spellcheck comment
	/**
	 * This is the main structure of the bunker.<br/>
	 * When found in the 2D tab, <tt>true</tt> means "not (yet) destroyed".
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
	private boolean [][]struct;
	
	//************* Constant *************//
	
	/**
	 * This constant sets the resolution that is to say, 
	 * the number of base unit (maybe pixel) to make table's case. 
	 */
	// FIXME this is not a constant. If so, define it as a real one. If not, initialize its value in a constructor
	private final int defaultResolution = 10;
	
	
	//************************** Constructors **************************//
	// FIXME fix the comment (indicating what the created bunker looks like)
	/**
	 * Constructor.<br/>
	 * It initializes the table of bunker's structures.
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
			// FIXME what means 10 here ?
			for(i=0; i < ((this.nbCase.getX() * 3) % 10); i++)
				this.struct[i][j] = true;
			for(i=i; i < ((this.nbCase.getX() * 5) % 10); i++)
				this.struct[i][j] = false;
			for(i=i; i < ((this.nbCase.getX() * 7) % 10); i++)
				this.struct[i][j] = true;
		}
		// FIXME what means j=j here ?
		for(j=j; j < this.nbCase.getY(); j++)
		{
			for(i=0; i < 3; i++)
				this.struct[i][j] = true;
		}
	}
	
	// FIXME write a comment
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
	
	
	// FIXME (FIXED) spellcheck comment
	//************************** Methods **************************//
	/**
	 * Check if the cell exists (true) or not.<br/>
	 * @param i the x position of the cell to check.
	 * @param j the y position of the cell to check.
	 * @return (boolean) return true if the cell is not (yet) destroyed and false otherwise.
	 */
	// FIXME what if i and j are out of bounds ?
	public boolean check(int i, int j)
	{
		return this.struct[i][j];
	}
	
	/**
	 * Destroy case into table of bunker's structures.<br/>
	 * @param i the x position of the case to destroy.
	 * @param j the y position of the case to destroy.
	 */
	// FIXME rename method
	// FIXME what if i and j are out of bounds ?
	public void destoy(int i, int j)
	{
		this.struct[i][j] = false;
	}

	//********************** Getters and Setters ***********************//

	// FIXME write comment
	// FIXME is this really useful  if you have yet check and destroy methods ?
	public boolean[][] getStruct()
	{
		return this.struct;
	}

	// FIXME write comment
	// FIXME is this really useful  if you have yet check and destroy methods ?  
	public void setStruct(boolean[][] struct)
	{
		this.struct = struct;
	}

	// FIXME write comment
	public Coordinates getPosition()
	{
		return this.position;
	}

	// FIXME write comment
	public Coordinates getSize()
	{
		return this.size;
	}

	// FIXME write comment
	public int getResolution()
	{
		return this.resolution;
	}

	// FIXME write comment
	// FIXME rename method
	public Coordinates getNbCase()
	{
		return this.nbCase;
	}
}