/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * @author alexandre
 *
 */
public class SpaceInvadersMaVa extends SpaceInvaders
{

	//********************* Constructors ************************
	
		/**
		 * Initialize the game.<br/>
		 * This is the default constructor. 
		 * It set all to default value.
		 * If you don't want to use this default characteristic use another constructor
		 */
		public SpaceInvadersMaVa()
		{
			super();
		}

		/**
		 * Initialize the game.<br/>
		 * This constructor sets the X axis to 300, and the Y axis to 300 too.<br/>
		 * If you don't want to use this default characteristic use another constructors
		 * 
		 * @param nbMonsters
		 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
		 * @param nbTanks
		 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
		 */
		public SpaceInvadersMaVa(int nbMonsters, int nbTanks)
		{
			super(nbMonsters,nbTanks);
		}

		/**
		 * Initialize the game.<br/>
		 * This constructor uses default value of acceleration
		 * 
		 * @param nbMonsters
		 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
		 * @param nbTanks
		 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
		 * @param max
		 *            Set the Max point of the grid (Coordinates) 
		 */
		public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Coordinates max)
		{
			super(nbMonsters, nbTanks, max);
		}
		
		/**
		 * Initialize the game.<br/>
		 * This constructor no default value.
		 * 
		 * @param nbMonsters
		 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
		 * @param nbTanks
		 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
		 * @param max
		 *            Set the Max point of the grid (Coordinates) 
		 * @param sleepTime
		 *            Set the time between each move of monster (in milliseconds)  
		 */
		public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Coordinates max, int sleepTime)
		{
			super(nbMonsters, nbTanks, max, sleepTime);
		}
		
		/**
		 * Initialize the game.<br/>
		 * This constructor uses no default value.
		 * 
		 * @param nbMonsters
		 *            Set the number of Monster you want instantiate (with default constructors, it sets to 20)
		 * @param nbTanks
		 *            Set the number of Tank you want instantiate (with default constructors, it sets to 20)
		 * @param max
		 *            Set the Max point of the grid (Coordinates) 
		 * @param sleepTime
		 *            Set the time between each move of monster (in milliseconds)  
		 * @param acceleration
		 *            Set the acceleration of Invaders. (not uses for now) 
		 */
		public SpaceInvadersMaVa(int nbMonsters, int nbTanks, Coordinates max, int sleepTime, int acceleration)
		{
			super(nbMonsters, nbTanks, max, sleepTime, acceleration);
		}
		
		
		//********************* Main ************************
		
		/**
		 * Main of the thread.
		 * It create to other threads for Invaders and for Tanks
		 */
		public void run()
		{
			
		}
}
