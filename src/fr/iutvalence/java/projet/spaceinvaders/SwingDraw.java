/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * This class is used for draw in the window
 * of the application. it draws the play and
 * if you loose or win !
 * @author Gallet Guyon
 */
public class SwingDraw extends JPanel
{

	@SuppressWarnings("javadoc")
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
	 * The ratio between model and view
	 */
	private double ratio;

	/**
	 * Know if the game continue, or is loosed or win. 
	 */
	private int end;

	public void paintComponent(Graphics g) 
	{
		int i= 0;
		ImageIcon img = null;
		
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
							if(this.elements[i].getDirection() > 0)
								img = new ImageIcon("./Image/shoot_tank.png");
							else
								img = new ImageIcon("./Image/shoot_invaders.png");
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
		g.setFont(new Font("Century Schoolbook L",Font.ITALIC,30)); // TODO better display
		g.setColor(Color.blue);
		if(this.end == 1)
		{
			g.drawString("WIN !", 150,200);
		}
		if(this.end == -1)
		{
			g.drawString("LOOSE !",150, 200);
		}
	}

	/**
	 * 
	 * @param elements The table of movable elements to draw
	 * @param maxSize The max size of the model
	 * @param ratio The ratio between model and view
	 */
	public void setTableToPaint(Movable elements[], Coordinates maxSize, double ratio)
	{
		this.maxSize = maxSize;
		this.ratio = ratio;
		this.elements = elements;
		this.end = 0;
	}

	/**
	 * Tell to paint actions for loose.
	 */
	public void loose()
	{
		this.end = -1;
	}

	/**
	 * Tell to paint actions for win. 
	 */
	public void win()
	{
		this.end = 1;
	}
}
