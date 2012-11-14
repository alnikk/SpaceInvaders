/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

//TODO Comment
/**
 *
 * @author Gallet Guyon
 */
public class RandomTanksThreads implements Tank
{
	/**
	 * It defines the number of tank you have in tabTank.
	 */
	private int tanksAmount;
	
	/**
	 * Array containing all tanks.
	 */
	protected Movable[] tanks;

	/**
	 * Create a new RandomTank Object
	 */
	public RandomTanksThreads(Movable tanks[])
	{
		this.tanks = tanks;
		this.tanksAmount = this.tanks.length;
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Tank#shoot()
	 */
	@Override
	public void shoot()
	{
		int i;
		int x;
		long neg;
		
		for(i=0; i < this.tanksAmount; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
			{
				x = (int) (Math.random() * 10);
				neg = Math.round(Math.random());
				
				if(neg == 0)
					neg = -1;
				
				try
				{
					if((this.tanks[i].getArea().getPosition().getX() + (int) (x*neg)) > 0
						&& (this.tanks[i].getArea().getPosition().getX() +
						    this.tanks[i].getArea().getSize().getX() + (int) (x*neg)) < this.maxSize.getX())
					{
						this.tanks[i].move(new Coordinates((int) (x*neg),0));
					}
					else
					{
						throw new OutOfGridException(this.tanks[i]);
					}
				}
				catch (NegativeSizeException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Tank#move()
	 */
	@Override
	public void move()
	{
		int i;
		
		for(i=0; i < this.tanksAmount; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
				this.shootFrom(this.tanks[i], 1);
		}
	}

}
