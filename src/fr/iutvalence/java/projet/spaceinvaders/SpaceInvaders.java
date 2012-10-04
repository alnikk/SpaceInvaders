/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * The main parts of the game.<br/>
 * It provides the initializations and all objects are referenced in it. 
 * 
 * @author Gallet Guyon
 */
public class SpaceInvaders
{
	//************* Variable *************//
	/**
	 * Boolean to know if the game is finished
	 */
	private boolean work;
	
	/**
	 * The maximum size of the area
	 */
	private final Coordinates maxSize;

	//************* Tableau *************//
	/**
	 * Table of all monsters' instance variable
	 */
	private Monster[] tabMonster;

	/**
	 * Table of all tanks' instance variable
	 */
	private Tank[] tabTank;

	// TODO move to Movable
	// FIXME field initialization must be done inside a constructor
	/**
	 * Size of a movable object 
	 */
	private final int size = 10;

	//************* Constante *************//
	/**
	 * It defines the number of monster you have in tabMonster by default,
	 * if it's not set in constructor. 
	 */
	private static final int nbMonsterDefault = 20;

	/**
	 * It defines the number of tank you have in tabTank by default,
	 * if it's not set in constructor.
	 */
	private static final int nbTankDefault = 1;
	
	/**
	 * It defines the maximum of X axis,
	 * if it's not set in constructor.
	 */
	private static final int XGrid = 300;
	
	/**
	 * It defines the maximum of Y axis,
	 * if it's not set in constructor.
	 */
	private static final int YGrid = 300;

	
	//************************** Constructeurs **************************//
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the number of tank to 1, the number of monster to 20,
	 * the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors 
	 */
	public SpaceInvaders()
	{
		super();

		this.work = true;
		this.maxSize = new Coordinates(this.XGrid, this.YGrid);
		initTab(this.nbMonsterDefault, this.nbTankDefault);
	}
	
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It sets the X axis to 300, and the Y axis to 300 too.<br/>
	 * If you don't want to use this default characteristic use another constructors
	 * 
	 * @param nbMonster Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank Set the number of Tank you want instantiate (with default constructors, it sets to 20)
	 */
	public SpaceInvaders(int nbMonster, int nbTank)
	{
		super();

		this.work = true;
		this.maxSize = new Coordinates(this.XGrid, this.YGrid);
		initTab(nbMonster, nbTank);
	}
	
	/**
	 * Initialize the game.<br/>
	 * This is the default constructor. It uses no default value.
	 * 
	 * @param nbMonster Set the number of Monster you want instantiate (with default constructors, it sets to 20)
	 * @param nbTank Set the number of Tank you want instantiate (with default constructors, it sets to 20)
 	 * @param nbTank Set the X axis (with default constructors, it sets to 300)
 	 * @param nbTank Set the Y axis (with default constructors, it sets to 300)
	 */
	public SpaceInvaders(int nbMonster, int nbTank, Coordinates Max)
	{
		super();

		this.work = true;
		this.maxSize = Max;
		initTab(nbMonster, nbTank);
	}

	//************************** Methodes **************************//
	
	/**
	 * Initialize the table of movable elements.
	 * 
	 * 
	 * @param Set the max of monster 
	 * @param Set the max of tank
	 */
	private void initTab(int nbMonstre, int nbTank)
	{
		// local variable
		Coordinates tank_size = new Coordinates(this.size, this.size);
		Coordinates tank_position = new Coordinates((this.maxSize.getX() / 2) 
														- (tank_size.getX() / 2), 
													this.maxSize.getY() / 2 - (tank_size.getY() / 2));

		int i = 0;
		Coordinates monster_size = new Coordinates(this.size, this.size);
		Coordinates monster_position = new Coordinates(this.maxSize.getX() - monster_size.getX(), 
														this.maxSize.getY() - monster_size.getY());

		// Allocations
		this.tabMonster = new Monster[nbMonstre];
		this.tabTank = new Tank[nbTank];

		// Set Tabs
		this.tabTank[0] = new Tank(tank_position, tank_size);

		for (i = 0; i < 19; i++)
		{
			this.tabMonster[i] = new Monster(monster_position, monster_size);
			monster_position = new Coordinates(monster_position.getX()
					- monster_size.getX(), monster_position.getY()
					- monster_size.getY());
		}
		//TODO finish
	}

	// TODO deplacement des enemis seuls
	
	// oldFIXME public methods ?
	// later =)
}
