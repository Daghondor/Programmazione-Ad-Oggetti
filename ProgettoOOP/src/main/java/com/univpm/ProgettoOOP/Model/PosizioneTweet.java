package com.univpm.ProgettoOOP.Model;

/**
 * Classe che modella la citta' del tweet.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class PosizioneTweet 
{
	/**
	 * ID della citta'.
	 */
	private String ID_City;
	
	/**
	 * Tipo di posto.
	 */
	private String Place_Type;
	
	/**
	 * Nome della citta'.
	 */
	private String Name;
	
	/**
	 * Nome completo della citta'.
	 */
	private String Full_Name;
	
	/**
	 * Codice della nazione.
	 */
	private String Country_Code;
	
	/**
	 * Nome della nazione.
	 */
	private String Country;
	
	/**
	 * Costruttore della classe Posizione Tweet che inizialiiza un'istanza.
	 * @param iD_City ID della citta'.
	 * @param place_Type Tipo di posto.
	 * @param name Nome della citta'.
	 * @param full_Name Nome completo della citta'.
	 * @param country_Code Codice della nazione.
	 * @param country Nome della nazione.
	 */
	public PosizioneTweet(String iD_City, String place_Type, 
						String name, String full_Name,
						String country_Code, String country) 
	{
		super();
		ID_City = iD_City;
		Place_Type = place_Type;
		Name = name;
		Full_Name = full_Name;
		Country_Code = country_Code;
		Country = country;
	}

	/**
	 * Getter dell'ID della citta'.
	 * @return ID_City Ritorna l'ID della citta'.
	 */
	public String getID_City() 
	{
		return ID_City;
	}

	/**
	 * Settere dell?ID della citta'.
	 * @param iD_City ID della citta' passato dal chiamante.
	 */
	public void setID_City(String iD_City) 
	{
		ID_City = iD_City;
	}

	/**
	 * Getter del tipo di posto.
	 * @return Place_Type Ritorna la tipologia del posto.
	 */
	public String getPlace_Type() 
	{
		return Place_Type;
	}

	/**
	 * Setter del tipo di posto.
	 * @param place_Type Tipo di posto passato dal chiamante.
	 */
	public void setPlace_Type(String place_Type) 
	{
		Place_Type = place_Type;
	}

	/**
	 * Getter del nome della citta'.
	 * @return Name Ritorna il nome della citta'.
	 */
	public String getName() 
	{
		return Name;
	}

	/**
	 * Setter del nome della citta'
	 * @param name Nome dell citta' passato dal chiamante.
	 */
	public void setName(String name) 
	{
		Name = name;
	}

	/**
	 * Getter del nome completo della citta'.
	 * @return Full_Name Ritorna il nome completo della citta'.
	 */
	public String getFull_Name() 
	{
		return Full_Name;
	}

	/**
	 * Setter del nome completo della citta'.
	 * @param full_Name Nome completo della citta' passato dal chiamante.
	 */
	public void setFull_Name(String full_Name) 
	{
		Full_Name = full_Name;
	}

	/**
	 * Setter del codice della nazione.
	 * @return Country_Code Ritorna il codice della nazione.
	 */
	public String getCountry_Code() 
	{
		return Country_Code;
	}

	/**
	 * Getter del codice della nazione.
	 * @param country_Code Codice della nazione passato dal chiamante.
	 */
	public void setCountry_Code(String country_Code) 
	{
		Country_Code = country_Code;
	}

	/**
	 * Getter della nazione.
	 * @return Country Ritorna la nazione.
	 */
	public String getCountry()
	{
		return Country;
	}

	/**
	 * Setter della nazione.
	 * @param country Nazione passato dal chiamante.
	 */
	public void setCountry(String country) 
	{
		Country = country;
	}
	
	
}
