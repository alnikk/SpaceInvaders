/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders.display;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

import fr.iutvalence.java.projet.spaceinvaders.Movable;

/**
 * @author Gallet Guyon
 *
 */
public class MyJPanel extends JPanel
{
	/**
	 * Array containing all monsters to draw.
	 */
	private Movable[] monsters;

	/**
	 * Array containing all tanks to draw.
	 */
	private Movable[] tanks;

	/**
	 * Array containing all shoots to draw.
	 */
	private Movable[] shoots;
	
	public void paintComponent(Graphics g) 
	{
		int i= 0;
		
		// Fond
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Tanks
		g.setColor(Color.green);
		for(i = 0; i < this.tanks.length; i++)
		{
			if(this.tanks[i] != null && this.tanks[i].isAlive())
				g.fillRect(this.tanks[i].getArea().getPosition().getX(), 
					300, 
					this.tanks[i].getArea().getSize().getX(), 
					this.tanks[i].getArea().getSize().getY());
		}
		
		// Monsters
		g.setColor(Color.blue);
		for(i = 0 ; i < this.monsters.length; i++)
		{
			if(this.monsters[i] != null && this.monsters[i].isAlive())
				g.fillRect(this.monsters[i].getArea().getPosition().getX(), 
					(this.monsters[i].getArea().getPosition().getY()), 
					this.monsters[i].getArea().getSize().getX(), 
					this.monsters[i].getArea().getSize().getX());
		}
		
		// Shoots
		g.setColor(Color.yellow);
		for(i = 0 ; i < this.shoots.length; i++)
		{
			if(this.shoots[i] != null && this.shoots[i].isAlive())
				g.fillRect(this.shoots[i].getArea().getPosition().getX(), 
					this.shoots[i].getArea().getPosition().getY(), 
					this.shoots[i].getArea().getSize().getX() , 
					this.shoots[i].getArea().getSize().getX());
		}
	}
	
	/**
	 * 
	 * @param monsters
	 * @param tanks
	 * @param shoots
	 */
	public void setTableToPaint(Movable monsters[], Movable tanks[], Movable shoots[])
	{
		this.tanks = tanks;
		this.monsters = monsters;
		this.shoots = shoots;
	}
}
