/**
 * 
 */
// FIXME rename the package
package fr.iutvalence.java.projet;

// FIXME finish writing the comment
/**
 * @author guyonal
 *
 */
public class SpaceInvaders
{
	// FIXME write a comment
	private Monster[] tabMonstre;

	// FIXME write a comment
	private Shoot[] tabShoot;
	
	// FIXME write a comment
	private Tank[] tabTank;
	
	// FIXME write a comment
	// FIXME initialize fields in constructor
	private final Coordonnee taille = new Coordonnee(10,10);
	
	/**
	 * 
	 */
	public SpaceInvaders()
	{
		super();
		
		// FIXME define default values as constants
		start(20,5,1);
	}
	
	// FIXME rename the method
	// FIXME write a comment
	private boolean start(int nbMonstre, int nbShoot, int nbTank)
	{
		int i =0;
		this.tabMonstre = new Monster[nbMonstre];
		this.tabShoot = new Shoot[nbShoot];
		this.tabTank = new Tank[nbTank];
		
		this.tabTank[0] = new Tank();
		
		for(i=0;i<19;i++)
		{
			this.tabMonstre[i] = new Monster(); 
		}

		// FIXME in which case the method return false ?
		return true;
	}
	
	// FIXME public methods ?
}
