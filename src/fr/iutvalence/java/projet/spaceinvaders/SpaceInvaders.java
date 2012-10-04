/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import fr.iutvalence.java.projet.unused.Shoot;

/**
 * The main parts of the game.<br/>
 * It provides the initializations and all objects are referenced in it. 
 * 
 * @author Gallet Guyon
 */
public class SpaceInvaders
{
	// FIXME rename field
	/**
	 * Boolean to know if the part is finished
	 */
	private boolean part;

	// FIXME rename field
	/**
	 * Table of all monsters' instance variable
	 */
	private Monster[] tabMonstre;

	// FIXME rename field
	// ???
	// table of shoots' instance variable
	private Shoot[] tabShoot;

	// FIXME rename field
	/**
	 * Table of all tanks' instance variable
	 */
	private Tank[] tabTank;

	// FIXME rename field
	/**
	 * The size of the screen
	 */
	private final Coordinates taille;

	/**
	 * The constant size of the screen
	 */
	private static final int X = 300;

	
	// FIXME field initialization must be done inside a constructor
	/**
	 * Height of the screen 
	 */
	private final int Y = 300;

	// FIXME field initialization must be done inside a constructor
	/**
	 * Size of a movable object 
	 */
	private final int size = 10;

	// FIXME rename constant
	/**
	 * Constant in game
	 */
	private static final int nbMonstre = 20;

	// FIXME rename constant
	/**
	 * Constant in game
	 */
	private static final int nbShoot = 5;

	// FIXME rename constant
	/**
	 * Constant in game
	 */
	private static final int nbTank = 20;

	// FIXME fix comment
	/**
	 * Initialize the game and also the part.
	 * 
	 */
	public SpaceInvaders()
	{
		super();

		this.part = true;
		this.taille = new Coordinates(this.X, this.Y);
		init(this.nbMonstre, this.nbShoot, this.nbTank);
	}

	// FIXME fix comment
	/**
	 * Initialize the game with args
	 * 
	 * @param Set the max of monster 
	 * @param Set the max of shoot
	 * @param Set the max of tank
	 */
	private void init(int nbMonstre, int nbShoot, int nbTank)
	{
		// local variable
		Coordinates tank_size = new Coordinates(this.size, this.size);
		Coordinates tank_position = new Coordinates((this.X / 2)
				- (tank_size.getX() / 2), this.Y / 2 - (tank_size.getY() / 2));

		int i = 0;
		Coordinates monster_size = new Coordinates(this.size, this.size);
		Coordinates monster_position = new Coordinates(this.X
				- monster_size.getX(), this.Y - monster_size.getY());

		//
		this.tabMonstre = new Monster[nbMonstre];
		this.tabShoot = new Shoot[nbShoot];
		this.tabTank = new Tank[nbTank];

		//
		this.tabTank[0] = new Tank(tank_position, tank_size);

		for (i = 0; i < 19; i++)
		{
			this.tabMonstre[i] = new Monster(monster_position, monster_size);
			monster_position = new Coordinates(monster_position.getX()
					- monster_size.getX(), monster_position.getY()
					- monster_size.getY());
		}
	}

	// TODO deplacement des enemis seuls

	// oldFIXME public methods ?
	// later =)
}
