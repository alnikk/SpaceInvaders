/**
 * 
 */
package fr.iutvalence.java.projet.unused;

/**
 * @author alexandre
 *
 */
public class Liste
{
	private String nom;
	private Object objet;
	private Liste suivant;

	/**
	 * 
	 */
	public Liste()
	{
		this.objet = null;
		this.suivant = null;
		this.nom = null;
	}

	/**
	 * @return the objet
	 */
	public Object getObjet()
	{
		return this.objet;
	}

	/**
	 * @param objet the objet to set
	 */
	public void setObjet(Object objet)
	{
		this.objet = objet;
	}

	/**
	 * @return le doublet suivant (on en créé un nouveau)
	 */
	public Liste setSuivant()
	{
		Liste suivant = new Liste();
		this.suivant = suivant;
		return suivant;
	}

	/**
	 * @return le doublet suivant (existant => peut etre agal à nil)
	 */
	public Liste suivant()
	{
		return this.suivant;
	}

	/**
	 * @return the nom
	 */
	public String getNom()
	{
		return this.nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Liste [nom=" + this.nom + ", objet=" + this.objet + ", suivant=" + this.suivant + "]"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
	}

}
