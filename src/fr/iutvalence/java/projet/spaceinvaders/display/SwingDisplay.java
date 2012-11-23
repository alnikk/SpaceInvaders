/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders.display;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.iutvalence.java.projet.spaceinvaders.Coordinates;
import fr.iutvalence.java.projet.spaceinvaders.Movable;
import fr.iutvalence.java.projet.spaceinvaders.interfaces.Display;

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
	public void show(Movable[] tanks, Movable[] monsters, Movable[] shoots, Coordinates maxSize)
	{
		this.pan.setTableToPaint(monsters,tanks,shoots);
		this.pan.repaint();
	}
}