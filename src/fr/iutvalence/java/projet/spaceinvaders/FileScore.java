/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.io.File;

/**
 * Store the score in file.
 * @author Gallet Guyon
 */
public class FileScore implements Score
{
	/**
	 * File where is store all score.
	 */
	private File file;
	
	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#init()
	 */
	@Override
	public void init()
	{
		this.file = new File("score.txt");			
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#save(java.lang.String, int)
	 */
	@Override
	public void save(String name, long score)
	{
		
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#showSheet()
	 */
	@Override
	public void showSheet()
	{
		
	}
}
