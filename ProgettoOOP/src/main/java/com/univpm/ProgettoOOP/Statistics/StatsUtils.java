package com.univpm.ProgettoOOP.Statistics;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import com.univpm.ProgettoOOP.Model.Tweet;


public class StatsUtils
{	
	/*
	 * otterò il vettore filtarto e la condizione da StatsIT.
	 * Dentro questo file andrò a ricavare i tweet in base lla condizione.
	 * il vettore filtrato in base IT o DE, lo restituirò a StatsIT/DE.
	 * 
	 */
	private static JSONArray tweetStats = new JSONArray();
	
	@SuppressWarnings("unchecked")
	public JSONArray getValue(JSONArray array, Object value)
	{
		int tweetLinguaItaliana = 0, tweetLocazioneItaliana = 0;
		float percentualeTweetLinguaItaliana = 0, percentualeTweetLocazioneItaliana = 0;
		int tweetLinguaTedesca = 0, tweetLocazioneTedesca = 0;
		float percentualeTweetLinguaTedesca = 0, percentualeTweetLocazioneTedesca = 0;
		
		String lingua = (String) value;
		JSONObject statsFinale = new JSONObject();
		tweetStats.clear();
		statsFinale.clear();
		
		for (Object o : array) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
				{
					// ITALIANO
					if(lingua.equals("IT") | lingua.equals("it"))
					{
						JSONObject posizione = (JSONObject) o1.get("Posizione");
						
						if (((String) o1.get("Lang")).equals("it")) 
						{
							tweetLinguaItaliana++;
						} 
						if(((String) posizione.get("Country_Code")).equals("IT"))
						{
							tweetLocazioneItaliana++;
						}
					}
					
					// TEDESCO
					else if(lingua.equals("DE") | lingua.equals("de"))
					{
						JSONObject posizione = (JSONObject) o1.get("Posizione");
						
						if (((String) o1.get("Lang")).equals("de")) 
						{
							tweetLinguaTedesca++;
						} 
						if(((String) posizione.get("Country_Code")).equals("DE"))
						{
							tweetLocazioneTedesca++;
						}
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
		
		if(lingua.equals("IT") | lingua.equals("it"))
		{
			percentualeTweetLinguaItaliana = (float) BigDecimal.valueOf((float) (tweetLinguaItaliana * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
			percentualeTweetLocazioneItaliana = (float) BigDecimal.valueOf((float) (tweetLocazioneItaliana * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
			//statsFinale.put("Tweet Esaminati", NumeroTweet);
			statsFinale.put("Tweet Filtrati", array.size());
			statsFinale.put("Numero Di Tweet Lingua Italiana", tweetLinguaItaliana);
			statsFinale.put("Percentuale Tweet Lingua Italiana", percentualeTweetLinguaItaliana + "%");
			statsFinale.put("Numero Di Tweet Con Locazione Italiana", tweetLocazioneItaliana);
			statsFinale.put("Percentuale Tweet Con Locazione Italiana", percentualeTweetLocazioneItaliana + "%");
			tweetStats.add(statsFinale);
		}
		else if(lingua.equals("DE") | lingua.equals("de"))
		{
			percentualeTweetLinguaTedesca = (float) BigDecimal.valueOf((float) (tweetLinguaTedesca * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
			percentualeTweetLocazioneTedesca = (float) BigDecimal.valueOf((float) (tweetLocazioneTedesca * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
			//statsFinale.put("Tweet Esaminati", NumeroTweet);
			statsFinale.put("Tweet Filtrati", array.size());
			statsFinale.put("Numero Di Tweet Lingua Tedesca", tweetLinguaTedesca );
			statsFinale.put("Percentuale Tweet Lingua Tedesca", percentualeTweetLinguaTedesca  + "%");
			statsFinale.put("Numero Di Tweet Con Locazione Tedesca", tweetLocazioneTedesca );
			statsFinale.put("Percentuale Tweet Con Locazione Tedesca", percentualeTweetLocazioneTedesca  + "%");
			tweetStats.add(statsFinale);
		}
		return tweetStats;
	}
}