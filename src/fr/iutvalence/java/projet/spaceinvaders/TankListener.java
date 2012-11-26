/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * This thread loop until game finished.
 * It allows to tank move and tank shoot. 
 * @author Gallet Guyon
 */
public class TankListener extends Thread implements KeyListener
{
	/**
	 * Interface for using tanks object
	 */
	private TankControler tank;	

	
	/**
	 * 
	 */
	private boolean Upressed;
	/**
	 * 
	 */
	private boolean Dpressed;
	/**
	 * 
	 */
	private boolean Lpressed;
	/**
	 * 
	 */
	private boolean Rpressed;
	/**
	 * 
	 */
	private boolean Tpressed;
	
	/**
	 * Create a new Tank Object
	 * @param tank Interface for controlling tank threw this class
	 */
	public TankListener(TankControler tank)
	{
		this.tank = tank;
		this.Lpressed = false;
		this.Rpressed = false;
		this.Tpressed = false;
		this.Upressed = false;
		this.Dpressed = false;
	}

	/**
	 * Main of the thread. It calls tankMove() and tankShoot() every 1000ms.
	 */
	public void run()
	{
		this.tank.setControleur(this);
		while(!this.tank.working())
		{
			if(this.Tpressed)
			{
				this.tank.tankShoot();
			}
			if(this.Rpressed)
			{
				try
				{
					this.tank.tankMove(new Coordinates(2,0));
				}
				catch (OutOfGridException e)
				{
					java.awt.Toolkit.getDefaultToolkit().beep();
				}
			}
			if(this.Lpressed)
			{
				try
				{
					this.tank.tankMove(new Coordinates(-2,0));
				}
				catch (OutOfGridException e)
				{
					java.awt.Toolkit.getDefaultToolkit().beep();
				}
			}
			if(this.Upressed)
			{
				try
				{
					this.tank.tankMove(new Coordinates(0,2));
				}
				catch (OutOfGridException e)
				{
					java.awt.Toolkit.getDefaultToolkit().beep();
				}
			}
			if(this.Dpressed)
			{
				try
				{
					this.tank.tankMove(new Coordinates(0,-2));
				}
				catch (OutOfGridException e)
				{
					java.awt.Toolkit.getDefaultToolkit().beep();
				}
			}
			try
			{
				Thread.sleep(50);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void keyPressed(KeyEvent event) 
	{
		switch(event.getKeyCode())
		{
			case KeyEvent.VK_SPACE:
				this.Tpressed = true;
				break;
			case KeyEvent.VK_RIGHT:
				this.Rpressed = true;
				break;
			case KeyEvent.VK_LEFT:
				this.Lpressed = true;
				break;
			case KeyEvent.VK_UP:
				this.Upressed = true;
				break;
			case KeyEvent.VK_DOWN:
				this.Dpressed = true;
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_SPACE:
				this.Tpressed = false;
				break;
			case KeyEvent.VK_RIGHT:
				this.Rpressed = false;
				break;
			case KeyEvent.VK_LEFT:
				this.Lpressed = false;
				break;
			case KeyEvent.VK_UP:
				this.Upressed = false;
				break;
			case KeyEvent.VK_DOWN:
				this.Dpressed = false;
				break;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e)
	{			
	}
}
