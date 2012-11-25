/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;


/**
 * This thread loop until game finished.
 * It allows to tank move and tank shoot. 
 * @author Gallet Guyon
 */
public class TanksThreads extends Thread
{
	/**
	 * Interface for using tanks object
	 */
	private TankControler tank;	
	
	/**
	 * Create a new Tank Object
	 * @param tank Interface for controlling tank threw this class
	 */
	public TanksThreads(TankControler tank)
	{
		this.tank = tank;
	}
	
	/**
	 * Main of the thread. It calls tankMove() and tankShoot() every 1000ms.
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
				java.awt.Toolkit.getDefaultToolkit().beep();
			}
			
			this.tank.tankShoot();
			
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
				break;
			}
		}
	}
	
}
