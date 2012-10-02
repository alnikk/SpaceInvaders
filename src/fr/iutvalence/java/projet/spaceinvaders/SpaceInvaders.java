/**
 * 
 */
// FIXME rename the package
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author Gallet Guyon
 *
 * The main parts of the game.
 * It provides the initializations and all objects are referenced in it. 
 */
public class SpaceInvaders
{
	// table of monsters' instance variable
	private Monster[] tabMonstre;

	// ???
	// table of shoots' instance variable
	private Shoot[] tabShoot;
	
	// table of tanks' instance variable
	private Tank[] tabTank;
	
	// The size of the screen
	private final Coordonnee taille;
	
	// The constant size of the screen 
	private final int X = 200;
	private final int Y = 200;
	
	// Constant in game
	private final int nbMonstre = 20;
	private final int nbShoot = 5;
	private final int nbTank = 20;
	
	/**
	 * 
	 */
	public SpaceInvaders()
	{
		super();
		
		this.taille= new Coordonnee(this.X,this.Y);
		 
		start(this.nbMonstre,this.nbShoot,this.nbTank);
	}
	
	// FIXME rename the method
	/**
	 * Initialize the game with args
	 * 
	 * @param Set the max of monster 
	 * @param Set the max of shoot
	 * @param Set the max of tank
	 */
	private boolean start(int nbMonstre, int nbShoot, int nbTank)
	{
		//local variable
		Coordonnee tank_size = new Coordonnee(10,10);
		Coordonnee tank_position = new Coordonnee((this.X/2)-(tank_size.getX()/2),this.Y/2-(tank_size.getY()/2));
		int i =0;
		Coordonnee monster_size = new Coordonnee(10,10);
		Coordonnee monster_position = new Coordonnee(this.X-monster_size.getX(),this.Y-monster_size.getY());
		
		//
		this.tabMonstre = new Monster[nbMonstre];
		this.tabShoot = new Shoot[nbShoot];
		this.tabTank = new Tank[nbTank];
		
		this.tabTank[0] = new Tank(tank_position,tank_size);
		
		for(i=0;i<19;i++)
		{
			this.tabMonstre[i] = new Monster(monster_position,monster_size);
			monster_position = new Coordonnee(monster_position.getX()-monster_size.getX(),monster_position.getY()-monster_size.getY());	
		}

		// FIXME in which case the method return false ?
		// no finish yet
		return true;
	}
	
	// FIXME public methods ?
	// later =)
}
