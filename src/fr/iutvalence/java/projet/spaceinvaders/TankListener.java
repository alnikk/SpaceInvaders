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
	//***************** Constant ******************
	/**
	 * The default move of a tank
	 */
	private static final int DEFAULT_MOVE = 2;
	
	/**
	 * The default waitTime between each actions of tank.
	 */
	private static final int DEFAULT_WAIT_TIME = 50;
	
	//***************** Variable ******************
	/**
	 * The default move of a tank
	 */
	private final int move;
	
	/**
	 * The default waitTime between each actions of tank.
	 */
	private final int waitTime;
	
	/**
	 * Interface for using tanks object
	 */
	private TankControler tank;	

	/**
	 * If UP key is pressed
	 */
	private boolean Upressed;
	
	/**
	 * If DOWN key is pressed
	 */
	private boolean Dpressed;
	
	/**
	 * If LEFT key is pressed
	 */
	private boolean Lpressed;
	
	/**
	 * If RIGHT key is pressed 
	 */
	private boolean Rpressed;
	
	/**
	 * If SPACE key is pressed
	 */
	private boolean Tpressed;
	
	/**
	 * If cheat key is pressed
	 */
	private boolean cheat;
	
	//***************** Constructors ******************
	/**
	 * Create a new Tank Object.
	 * @param tank Interface for controlling tank threw this class.
	 */
	public TankListener(TankControler tank)
	{
		this.tank = tank;
		this.waitTime = DEFAULT_WAIT_TIME;
		this.move = DEFAULT_MOVE;
		this.Lpressed = false;
		this.Rpressed = false;
		this.Tpressed = false;
		this.Upressed = false;
		this.Dpressed = false;
	}
	
	/**
	 * Create a new Tank Object.
	 * @param tank Interface for controlling tank threw this class.
	 * @param move The default move of tank.
	 * @param waitTime The default waitTime between each actions of tank. 
	 */
	public TankListener(TankControler tank, int move, int waitTime)
	{
		this.tank = tank;
		this.waitTime = waitTime;
		this.move = move;
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
				this.tank.tankMove(new Coordinates(this.move,0));
			if(this.Lpressed)
				this.tank.tankMove(new Coordinates(-this.move,0));
			if(this.cheat)
			{
				if(this.Upressed)
					this.tank.tankMove(new Coordinates(0,this.move));
				if(this.Dpressed)
					this.tank.tankMove(new Coordinates(0,-this.move));
			}
			
			try
			{
				Thread.sleep(this.waitTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	//***************** Methods ******************
	
	@Override
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
			case KeyEvent.VK_CONTROL:
				this.cheat = true;
				break;
			case KeyEvent.VK_ALT:
				this.cheat = false;
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
