package com.univpm.ProgettoOOP.Model;

/** 
 * Rappresenta la classe che modella un tweet.
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
	 * Data creazione tweet.
	 */
	protected String Data;
	
	/**
	 * Nome dell'utente che ha creato il tweet.
	 */
	protected String Nome_Utente;
	
	/**
	 * ID dell'utente che ha creato il tweet.
	 */
	protected String ID_Utente;
	
	
	/**
	 * Costruttore della classe Tweet che inizializza una istanza.
	 * @param data Data di creazione del tweet.
	 * @param iD_Tweet ID del tweet.
	 * @param text Testo del tweet.
	 * @param lang Lingua del tweet.
	 * @param location Locazione del tweet.
	 */
	public Tweet(String iD_Tweet, String data, String text, String lang, String location) 
	{
		super(); // Richiamo del costruttore della classe superiore java.util
		ID_Tweet = iD_Tweet;
		Data = data;
		Text = text;
		Lang = lang;
		Location = location;
	}
	/*public Tweet(String data, String iD_Tweet, String text, String lang, String location, String iD_Utente, String nome_Utente) 
	{
		super(); // Richiamo del costruttore della classe superiore java.util
		Data = data;
		ID_Tweet = iD_Tweet;
		Text = text;
		Lang = lang;
		Location = location;
		ID_Utente = iD_Utente;
		Nome_Utente = nome_Utente;
	}*/
	
	/**
	 * Getter della data del tweet.
	 * @return Ritorna l'ID del tweet.
	 */
	public String getData() 
	{
		return Data;
	}

	/**
	 * Setter della data del tweet.
	 * @param iD_Tweet ID passato dal chiamante. 
	 */
	public void setData(String data) 
	{
		Data = data;
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

	
	/**
	 * Getter del Nome dell'utente che ha creato il tweet.
	 * @return Nome_Utente Nome dell'utente che ha creato il tweet.
	 */
	public String getNome_Utente() 
	{
		return Nome_Utente;
	}

	/**
	 * Setter del Nome dell'utente che ha creato il tweet.
	 * @param nome_Utente Nome dell'utente che ha creato il tweet passato come parametro.
	 */
	public void setNome_Utente(String nome_Utente) 
	{
		Nome_Utente = nome_Utente;
	}

	/**
	 * Getter dell'ID dell'utente che ha creato il tweet.
	 * @return ID_Utente Nome dell'utente che ha creato il tweet.
	 */
	public String getID_Utente() 
	{
		return ID_Utente;
	}

	/**
	 * Setter dell'ID dell'utente che ha creato il tweet.
	 * @param iD_Utente ID dell'utente che ha creato il tweet passato come parametro.
	 */
	public void setID_Utente(String iD_Utente) 
	{
		ID_Utente = iD_Utente;
	}
}
