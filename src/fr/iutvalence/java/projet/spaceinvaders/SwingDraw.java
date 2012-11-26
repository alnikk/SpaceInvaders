/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

//TODO Commment
/**
 * @author Gallet Guyon
 *
 */
public class SwingDraw extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		ImageIcon img =null;
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
							//g.setColor(Color.green);
							img = new ImageIcon("./Image/tank.png");
							break;
						case MONSTER:
							//g.setColor(Color.blue);
							img = new ImageIcon("./Image/invader.png");
							break;
						case SHOOT:
							//g.setColor(Color.yellow);
							img = new ImageIcon("./Image/shoot.png");
							break;
						default:
							break;
					}
					if(this.elements[i] != null && this.elements[i].isAlive())
						g.drawImage(img.getImage(),(int) (this.elements[i].getArea().getPosition().getX() * this.ratio), 
								(int)(this.getHeight() - ((this.elements[i].getArea().getSize().getY() + this.elements[i].getArea().getPosition().getY()) * this.ratio)), 
								(int)(this.elements[i].getArea().getSize().getX() * this.ratio), 
								(int)(this.elements[i].getArea().getSize().getY()* this.ratio),
								null, null);
				}
			}
		}
	}

	/**
	 * 
	 * @param elements v
	 * @param maxSize cv 
	 * @param ratio cz
	 */
	public void setTableToPaint(Movable elements[], Coordinates maxSize, double ratio)
	{
		this.maxSize = maxSize;
		this.ratio = ratio;
		this.elements = elements;
	}
}
