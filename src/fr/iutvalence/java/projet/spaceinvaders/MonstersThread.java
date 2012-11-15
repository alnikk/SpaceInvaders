/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * This thread loop until the game finish. It make invaders move and test collision beetween us and the tank.
 * 
 * @author Gallet Guyon
 */
public class MonstersThread extends Thread
{
	// ***************** Variable *************************

	/**
	 * Reference to work boolean in SpaceInvaders class Boolean to know if the game is finished
	 */
	private int delay;
	
	/**
	 * 
	 */
	private MonsterControler monster;
	
	// ***************** Constructors *************************

	/**
	 * This constructors set the variable needed by the thread.
	 * 
	 * @param nom
	 *            Name of the Thread
	 * @param work
	 *            The stop loop value
	 * @param monster // TODO Comment 
	 */
	public MonstersThread(String nom, MonsterControler monster, int initialDelay)
	{
		super(nom);
		this.delay = initialDelay;
		this.monster = monster;
	}

	// ******************** Main ***********************

	/**
	 * Main of the thread. It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		while (this.delay > 0)
		{			
			this.delay = this.monster.monstersMove();
			
			this.monster.monsterShoot();
			
			this.waitLoop();
		}
	}
	
	/**
	 * This method wait a time in function of sleepTime value and of monster alive's number
	 */
	public void waitLoop()
	{
		try
		{
			Thread.sleep(this.delay);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
