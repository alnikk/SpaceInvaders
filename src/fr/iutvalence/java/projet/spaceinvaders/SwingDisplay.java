/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;


// TODO Comment
/**
 * @author Gallet Guyon
 *
 */
public class SwingDisplay implements Display
{	
	private SwingDraw pan = new SwingDraw();
	
	private JFrame window = new JFrame();
	
	/**
	 * Constructor of the class.
	 */
	public SwingDisplay(int x, int y)
	{
		super();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(x,y);
		this.window.setLocationRelativeTo(null);
		this.window.setContentPane(this.pan);
		this.window.setVisible(true);
	}
	
	public void init(KeyListener e, Movable elements[], Coordinates maxSize)
	{
		float ratio = (this.pan.getWidth() / maxSize.getX()) + (this.pan.getHeight() / maxSize.getY())/2;
		this.window.addKeyListener(e);
		this.pan.setTableToPaint(elements, maxSize, ratio);		
	}

	@Override
	public void show()
	{
		this.pan.repaint();
	}
}