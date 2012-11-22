/**
 * 
 */
package fr.iutvalence.java.projet.test;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * @author Gallet Guyon
 *
 */
public class TestSwing
{
	/**
	 * @param args No
	 */
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame("test");
		frame.setSize(400, 200);
		frame.setVisible(true);
		//frame.setBackground(new Color(255,255,255));
		frame.setContentPane(new MyJPanel());
		while (true)
		{
			frame.getContentPane().repaint();
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
