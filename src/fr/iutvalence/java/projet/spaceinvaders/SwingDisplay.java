/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyListener;
import javax.swing.JFrame;


// TODO Comment
/**
 * @author Gallet Guyon
 *
 */
public class SwingDisplay implements Display
{	
	/**
	 * 
	 */
	private SwingDraw pan = new SwingDraw();
	
	/**
	 * 
	 */
	private JFrame window = new JFrame();
	
	/**
	 * Constructor of the class.
	 * @param x r
	 * @param y r
	 */
	public SwingDisplay(int x, int y)
	{
		super();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(x,y);
		this.window.setLocationRelativeTo(null);
		this.window.setResizable(false);
		this.window.setVisible(true);
		this.window.setContentPane(this.pan);
	}
	
	public void init(KeyListener e, Movable elements[], Coordinates maxSize)
	{
		float ratio = (this.pan.getWidth() / maxSize.getX()) + ((this.pan.getHeight() / maxSize.getY())/2);
		this.window.addKeyListener(e);
		this.pan.setTableToPaint(elements, maxSize, ratio);
	}

	@Override
	public void show()
	{
		this.window.repaint();
	}

	@Override
	public void loose()
	{
		this.pan.loose();
	}

	@Override
	public void win()
	{
		this.pan.win();		
	}
}