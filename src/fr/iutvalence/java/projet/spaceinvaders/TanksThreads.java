/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

//TODO Comment
/**
 * 
 * @author Gallet Guyon
 */
public class TanksThreads extends Thread
{
	/**
	 * 
	 */
	private TankControler tank;	
	
	/**
	 * Create a new RandomTank Object
	 * @param tank 
	 */
	public TanksThreads(TankControler tank)
	{
		this.tank = tank;
	}
	
	/**
	 * Main of the thread. It calls move() then testCollision() every sleepTime millisecond.
	 */
	public void run()
	{
		while (true)
		{			
			try
			{
				this.tank.tankMove();
			}
			catch (OutOfGridException e)
			{
				//e.printStackTrace();
			}
			
			this.tank.tankShoot();
		}
	}
	
}
