/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import javax.swing.JFrame;
import javax.swing.JPanel;


// TODO Comment
/**
 * @author Gallet Guyon
 *
 */
public class SwingDisplay implements Display
{
	private JFrame window = new JFrame();
	
	private MyJPanel pan = new MyJPanel();

	/**
	 * Constructor of the class.
	 */
	public SwingDisplay(int x, int y)
	{
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(x,y);
		this.window.setVisible(true);
		this.window.setContentPane(this.pan);
	}

	@Override
	public void show(Movable elements[], Coordinates maxSize)
	{
		double ratio = (this.pan.getWidth() / maxSize.getX()) + 
				(this.pan.getHeight() / maxSize.getY())/2;
		this.pan.setTableToPaint(elements, maxSize, ratio);
		this.pan.repaint();
	}
}
