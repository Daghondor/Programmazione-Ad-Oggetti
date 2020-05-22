package com.univpm.ProgettoOOP.Model;

/** Rappresenta la classe che modella un tweet
 * permesse al Client.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
*/
public class Tweet 
{
	/**
	 * Id del tweet.
	 */
	protected String ID_Tweet;
	/**
	 * Testo del tweet.
	 */
	protected String Text;
	/**
	 * Lingua del tweet.
	 */
	protected String Lang;
	/**
	 * Locazione del tweet.
	 */
	protected String Location;
	
	/**
	 * Costruttore della classe Tweet che inizializza una istanza.
	 * @param iD_Tweet ID del tweet.
	 * @param text Testo del tweet.
	 * @param lang Lingua del tweet.
	 * @param location Locazione del tweet.
	 */
	public Tweet(String iD_Tweet, String text, String lang, String location) 
	{
		super(); // Richiamo del costruttore della classe superiore java.util
		ID_Tweet = iD_Tweet;
		Text = text;
		Lang = lang;
		Location = location;
	}

	/**
	 * Getter dell'ID tweet.
	 * @return Ritorna l'ID del tweet.
	 */
	public String getID_Tweet() 
	{
		return ID_Tweet;
	}

	/**
	 * Setter dell'ID tweet.
	 * @param iD_Tweet ID passato dal chiamante. 
	 */
	public void setID_Tweet(String iD_Tweet) 
	{
		ID_Tweet = iD_Tweet;
	}

	/**
	 * Getter del testo del  tweet.
	 * @return Ritorna il testo del tweet.
	 */
	public String getText()
	{
		return Text;
	}

	/**
	 * Setter del testo del tweet.
	 * @param text Testo passato dal chiamante.
	 */
	public void setText(String text)
	{
		Text = text;
	}

	/**
	 * Getter della lingua del tweet.
	 * @return Ritorna la lingua del tweet.
	 */
	public String getLang() 
	{
		return Lang;
	}

	/**
	 * Setter della lingua del tweet.
	 * @param lang Lingua passata dal chiamante.
	 */
	public void setLang(String lang)
	{
		Lang = lang;
	}

	/**
	 * Getter della locazione del tweet.
	 * @return Ritorna la locazione del tweet.
	 */
	public String getLocation() 
	{
		return Location;
	}

	/**
	 * Setter della locazione del tweet.
	 * @param location Locazione passata dal chiamante.
	 */
	public void setLocation(String location)
	{
		Location = location;
	}
}
