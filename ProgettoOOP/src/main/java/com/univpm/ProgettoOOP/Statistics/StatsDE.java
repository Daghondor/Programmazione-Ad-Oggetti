package com.univpm.ProgettoOOP.Statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StatsDE implements Stats
{
	private static JSONArray tweetStatsDE = new JSONArray();
	
	@SuppressWarnings("unchecked")
	public static JSONArray StatsTweet(JSONArray arrayTweet, int NumeroTweet, int NumeroTweetFiltrati)
	{
		int tweetLinguaTedesca = 0, tweetLocazioneTedesca = 0;
		float percentualeTweetLinguaTedesca = 0, percentualeTweetLocazioneTedesca = 0;
		
		JSONObject statsFinale = new JSONObject();
		tweetStatsDE.clear();
		
		statsFinale.clear();
		
		for (Object o : arrayTweet) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
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
				catch (Exception e) 
				{
					System.out.println("ERRORE.");
					System.out.println("MESSAGGIO: " + e.getMessage());
					System.out.println("CAUSA: " + e.getCause());

				}
			}
		}
		percentualeTweetLinguaTedesca = (float) BigDecimal.valueOf((float) (tweetLinguaTedesca * 100) / (float) NumeroTweetFiltrati).setScale(2, RoundingMode.HALF_UP).doubleValue();
		percentualeTweetLocazioneTedesca = (float) BigDecimal.valueOf((float) (tweetLocazioneTedesca * 100) / (float) NumeroTweetFiltrati).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		
		statsFinale.put("Tweet Esaminati", NumeroTweet);
		statsFinale.put("Tweet Filtrati", NumeroTweetFiltrati);
		statsFinale.put("Numero Di Tweet Lingua Tedesca", tweetLinguaTedesca );
		statsFinale.put("Percentuale Tweet Lingua Tedesca", percentualeTweetLinguaTedesca  + "%");
		statsFinale.put("Numero Di Tweet Con Locazione Tedesca", tweetLocazioneTedesca );
		statsFinale.put("Percentuale Tweet Con Locazione Tedesca", percentualeTweetLocazioneTedesca  + "%");
		tweetStatsDE.add(statsFinale);
		percentualeTweetLinguaTedesca  = 0;
		percentualeTweetLocazioneTedesca = 0;
		return tweetStatsDE;
	}
}
