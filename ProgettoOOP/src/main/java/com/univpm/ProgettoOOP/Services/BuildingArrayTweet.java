package com.univpm.ProgettoOOP.Services;

import java.util.ArrayList;
import com.univpm.ProgettoOOP.Model.Tweet;

/**
 * Classe per la creazione degi arrayList di tipo tweet.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class BuildingArrayTweet 
{
	private static ArrayList<Tweet> arrayLista = new ArrayList<Tweet>();
	
	public static ArrayList<Tweet> Building(String id_tweet, String dataCreazione, String testo, String lingua, String locazione)
	{
		Tweet singoloTweet = new Tweet(id_tweet, dataCreazione, testo, lingua, locazione);
		arrayLista.add(singoloTweet);
		return arrayLista;
	}
}
