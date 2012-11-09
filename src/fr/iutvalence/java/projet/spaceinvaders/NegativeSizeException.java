/**
 * 
 */
package fr.iutvalence.java.projet.spaceinvaders;

/**
 * Thrown when only positive coordinates are expected 
 * 
 * @author Gallet Guyon
 */
// FIXME (QUEST) What is this?
// FIXME (SEEN) (ANSWER) it is an annotation (aimed to be caught by the compiler) meaning that even if no serial version UID is given no warning has to be raised
@SuppressWarnings("serial")
public class NegativeSizeException extends Exception
{
	/**
	 * This variable is the bad coordinates. Exception due to this coordinates. 
	 */
	private Coordinates bad;

	/**
	 * Create an exception related to specified negative coordinates
	 * @param bad negative coordinates related to the exception 
	 */
	public NegativeSizeException(Coordinates bad)
	{
		super();
		this.bad = bad;
	}

	/**
	 * Create NegativeSizeException
	 */
	public NegativeSizeException()
	{
		super();
		this.bad = null;
	}

	/**
	 * Getter for the negative coordinates related to the exception
	 * @return negative coordinates related to the exception
	 */
	public Coordinates getNegativeCoordinatesException()
	{
		return this.bad;
	}
}
