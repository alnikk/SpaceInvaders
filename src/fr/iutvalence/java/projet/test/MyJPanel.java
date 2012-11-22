package fr.iutvalence.java.projet.test;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MyJPanel extends JPanel
{
	private boolean pair;
	
	public MyJPanel()
	{
		this.pair = false;
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		if (pair) g.fillRect(0, 0, 100,100);
		else g.drawRect(0, 0, 100,100);
		pair = !pair;
	}

}
