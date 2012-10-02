/**
 * 
 */
package fr.iutvalence.java.projet;

/**
 * @author guyonal
 *
 */
public class SpaceInvaders
{
	private Monster[] tabMonstre;
	private Shoot[] tabShoot;
	private Tank[] tabTank;
	private final Coordonnee taille = new Coordonnee(10,10);
	
	/**
	 * 
	 */
	public SpaceInvaders()
	{
		super();
		start(20,5,1);
	}
	
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

		return true;
	}
}
