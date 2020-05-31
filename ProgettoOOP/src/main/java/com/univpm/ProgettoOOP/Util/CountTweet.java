package com.univpm.ProgettoOOP.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Classe che analizza un gruppo di tweet (100) su base o Lingua o Locazione.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class CountTweet
{
	/**
	 * Oggetto di tipo JSONArray che contiene tutti i tweet analizzati sulla base lingua.
	 */
	private static JSONArray tweetLinguaItalianaTedesca = new JSONArray();
	
	/**
	 * Oggetto di tipo JSONArray che contiene tutti i tweet analizzati sulla locazione.
	 */
	private static JSONArray tweetLocationItaliaGermania= new JSONArray();
	
	/**
	 * Metodo che analizza i tweet passati sulla base della lingua,
	 * preleva tutti i tweet che hanno la lingua italiana ed i tweet che hanno la lingua tedesca,
	 * li inserisce in un oggetto JSONArray tweetLinguaItalianaTedesca.
	 * @param listaTweet Lista dei tweet (100) in cui verrà fatta l'analisi.
	 * @return tweetLinguaItalianaTedesca Ritorna l'oggetto JSONArray contenente tutti i tweet in lingua italiana e tedesca.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static JSONArray analisiLinguaTweet(JSONArray listaTweet)
	{
		tweetLinguaItalianaTedesca.clear();
		int numeroTweetItaliani = 0, numeroTweetTedeschi = 0;
		
		JSONArray listaTweetLinguaItaliana = new JSONArray();
		JSONArray listaTweetLinguaTedesca = new JSONArray();
		
		for (Object o : listaTweet) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
				{
					if (((String) o1.get("Lang")).equals("it")) 
					{
						numeroTweetItaliani++;
						listaTweetLinguaItaliana.add(o1);
					} 
					else if (((String) o1.get("Lang")).equals("de")) 
					{
						numeroTweetTedeschi++;
						listaTweetLinguaTedesca.add(o1);
						//tweetLinguaItalianaTedesca.add(o1);
					}
				} 
				catch (Exception e) 
				{
					System.out.println("ERRORE.");
					System.out.println("MESSAGGIO: " + e.getMessage());
					System.out.println("CAUSA: " + e.getCause());

				}
			}
		}
		tweetLinguaItalianaTedesca.add(listaTweetLinguaItaliana);
		tweetLinguaItalianaTedesca.add(listaTweetLinguaTedesca);

	 	return tweetLinguaItalianaTedesca;
	}
	
	
	/**
	 * Metodo che analizza i tweet passati sulla base della locazione,
	 * preleva tutti i tweet che hanno la locazione italia ed i tweet che hanno la locazione germania,
	 * li inserisce in un oggetto JSONArray tweetLocationItaliaGermania.
	 * @param listaTweet Lista dei tweet (100) in cui verrà fatta l'analisi.
	 * @return tweetLocationItaliaGermania Ritorna l'oggetto JSONArray contenente tutti i tweet con la locazione italia e germania.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static JSONArray analisiLocationTweet(JSONArray listaTweet)
	{
		tweetLocationItaliaGermania.clear();
		int numeroTweetItaliani = 0, numeroTweetTedeschi = 0;
		
		JSONArray listaTweetLocationItalia = new JSONArray();
		JSONArray listaTweetLocationGermania = new JSONArray();
		
		for (Object o : listaTweet) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
				{
					if (((String) o1.get("Location")).equals("Italy")) 
					{
						listaTweetLocationItalia.add(o1);
					} 
					else if (((String) o1.get("Location")).equals("Germany")) 
					{
						listaTweetLocationGermania.add(o1);
					}
				} 
				catch (Exception e) 
				{
					System.out.println("ERRORE.");
					System.out.println("MESSAGGIO: " + e.getMessage());
					System.out.println("CAUSA: " + e.getCause());

				}
			}
		}
		tweetLocationItaliaGermania.add(listaTweetLocationItalia);
		tweetLocationItaliaGermania.add(listaTweetLocationGermania);
		
		return tweetLocationItaliaGermania;
	}
}
