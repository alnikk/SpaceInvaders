/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;


/**
 * This thread loop until the game finish.<br/>
 *  It make invaders move and shot on tanks.
 * @author Gallet Guyon
 */
public class MonstersThread extends Thread
{
	// ***************** Variable *************************

	/**
	 * It sets the number of monsters' thread loop before invaders shoots.
	 */
	private static final int DEFAULT_NB_LOOP_SHOOT = 2;

	/**
	 * Delay between each moves of Invaders. 
	 * When it's equals to 0 the game is finished
	 */
	private int delay;
	
	/**
	 * Interface for using monsters objects.
	 */
	private MonsterControler monster;
	
	/**
	 * It sets the number of monsters' thread loop before invaders shoots.
	 */
	private int nbLoopShoot = DEFAULT_NB_LOOP_SHOOT;
	
	// ***************** Constructors *************************
	
	/**
	 * This constructors set the variable needed by the thread.
	 * 
	 * @param monster Interface for control Monster threw this class 
	 */
	public MonstersThread(MonsterControler monster)
	{
		this.delay = 10;
		this.monster = monster;
		this.nbLoopShoot = DEFAULT_NB_LOOP_SHOOT;
	}
	
	/**
	 * This constructors set the variable needed by the thread.
	 * 
	 * @param nom Name of the Thread
	 * @param monster Interface for control Monster threw this class
	 * @param initialDelay The initial delay between each moves of monsters 
	 */
	public MonstersThread(String nom, MonsterControler monster, int initialDelay)
	{
		super(nom);
		this.delay = initialDelay;
		this.monster = monster;
		this.nbLoopShoot = DEFAULT_NB_LOOP_SHOOT;
	}
	
	/**
	 * This constructors set the variable needed by the thread.
	 * 
	 * @param nom Name of the Thread
	 * @param monster Interface for control Monster threw this class
	 * @param initialDelay The initial delay between each moves of monsters 
	 * @param nbLoopShoot It sets the number of monsters' thread loop before invaders shoots.
	 */
	public MonstersThread(String nom, MonsterControler monster, int initialDelay, int nbLoopShoot)
	{
		super(nom);
		this.delay = initialDelay;
		this.monster = monster;
		this.nbLoopShoot = nbLoopShoot;
	}

	// ******************** Main ***********************

	/**
	 * Main of the thread.<br/>
	 * It calls move() then testCollision() every 
	 * sleepTime millisecond.<br/>
	 */
	public void run()
	{
		while (this.delay > 0)
		{			
			this.delay = this.monster.monstersMove();
			
			if(this.nbLoopShoot <= 0)
				this.monster.monsterShoot();
			
			this.monster.waitLoop();
			this.nbLoopShoot--;
		}
	}
}
