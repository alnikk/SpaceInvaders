/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Store the score in file.
 * @author Gallet Guyon
 */
public class FileScore implements Score
{
	//************** Constant *******************
	
	/**
	 * The path to access file for storing scores
	 */
	private static final String PATH_TEXT = "score.txt";


	//************** Variable *******************
	/**
	 * File where is store all score.
	 */
	private File file;

	/**
	 * It used for write on the file.
	 */
	private FileWriter fo;

	/**
	 * It used to Read on the file.
	 */
	private FileReader fi;

	//************** Method *******************

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#init()
	 */
	@Override
	public void init()
	{
		this.file = new File(PATH_TEXT);
		if(!this.file.exists())
		{
			try
			{
				this.file.createNewFile();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#save(java.lang.String, int)
	 */
	@Override
	public void save(String name, long score)
	{
		try
		{
			this.fo = new FileWriter(this.file, true);
			this.fo.write(name + " : " + score + "\n");
			this.fo.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see fr.iutvalence.java.projet.spaceinvaders.Score#showSheet()
	 */
	@Override
	public void showSheet()
	{
		int input;		

		try
		{
			this.fi = new FileReader(this.file);

			try
			{
				while((input =this.fi.read()) != -1)
					System.out.print((char) input);
				this.fi.close();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
}
