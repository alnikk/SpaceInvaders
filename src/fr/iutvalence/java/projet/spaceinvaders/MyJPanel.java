/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;


/**
 * @author Gallet Guyon
 *
 */
public class MyJPanel extends JPanel
{
	/**
	 * Array containing all monsters to draw.
	 */
	private Movable[] elements;

	/**
	 * The maximum size of the area.<br/>
	 * No elements can move (so be drown) over this bound.
	 */
	private Coordinates maxSize;

	/**
	 * 
	 */
	private double ratio;

	public void paintComponent(Graphics g) 
	{
		int i= 0;
		
		// Fond
		g.setColor(Color.black);
		if(this.maxSize != null)
			g.fillRect(0, 0, (int) (this.maxSize.getX() * this.ratio), (int) (this.maxSize.getY() * this.ratio));


		if(this.elements != null)
		{
			for(i = 0; i < this.elements.length; i++)
			{
				if(this.elements[i] != null && this.elements[i].isAlive())
				{
					switch(this.elements[i].getType())
					{
						case TANK:
							g.setColor(Color.green);
							break;
						case MONSTER:
							g.setColor(Color.blue);
							break;
						case SHOOT:
							g.setColor(Color.yellow);
							break;
						default:
							break;
					}
					if(this.elements[i] != null && this.elements[i].isAlive())
						g.fillRect((int)(this.elements[i].getArea().getPosition().getX() * this.ratio), 
								(int)(this.getHeight() - ((this.elements[i].getArea().getSize().getY() + this.elements[i].getArea().getPosition().getY()) * this.ratio)), 
								(int)(this.elements[i].getArea().getSize().getX() * this.ratio), 
								(int)(this.elements[i].getArea().getSize().getY()* this.ratio));
				}
			}
		}
	}

	/**
	 * 
	 * @param monsters
	 */
	public void setTableToPaint(Movable elements[], Coordinates maxSize, double ratio)
	{
		this.maxSize = maxSize;
		this.ratio = ratio;
		this.elements = elements;
	}
}
