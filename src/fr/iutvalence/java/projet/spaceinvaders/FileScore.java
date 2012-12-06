/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Store the score in file.
 * @author Gallet Guyon
 */
public class FileScore implements Score
{
	/**
	 * File where is store all score.
	 */
	private FileWriter file;
	
	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#init()
	 */
	@Override
	public void init()
	{
		try
		{
			this.file = new FileWriter("score.txt", true);
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
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
