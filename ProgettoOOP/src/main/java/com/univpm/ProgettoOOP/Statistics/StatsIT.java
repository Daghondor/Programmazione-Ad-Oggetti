package com.univpm.ProgettoOOP.Statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class StatsIT implements Stats
{	
	private static JSONArray tweetStatsIT = new JSONArray();
	
	@SuppressWarnings("unchecked")
	public static JSONArray StatsTweet(JSONArray arrayTweet, int NumeroTweet, int NumeroTweetFiltrati)
	{
		int tweetLinguaItaliana = 0, tweetLocazioneItaliana = 0;
		float percentualeTweetLinguaItaliana = 0, percentualeTweetLocazioneItaliana = 0;
		
		JSONObject statsFinale = new JSONObject();
		tweetStatsIT.clear();
		
		statsFinale.clear();
		
		for (Object o : arrayTweet) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
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
				catch (Exception e) 
				{
					System.out.println("ERRORE.");
					System.out.println("MESSAGGIO: " + e.getMessage());
					System.out.println("CAUSA: " + e.getCause());

				}
			}
		}
		percentualeTweetLinguaItaliana = (float) BigDecimal.valueOf((float) (tweetLinguaItaliana * 100) / (float) NumeroTweetFiltrati).setScale(2, RoundingMode.HALF_UP).doubleValue();
		percentualeTweetLocazioneItaliana = (float) BigDecimal.valueOf((float) (tweetLocazioneItaliana * 100) / (float) NumeroTweetFiltrati).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		
		statsFinale.put("Tweet Esaminati", NumeroTweet);
		statsFinale.put("Tweet Filtrati", NumeroTweetFiltrati);
		statsFinale.put("Numero Di Tweet Lingua Italiana", tweetLinguaItaliana);
		statsFinale.put("Percentuale Tweet Lingua Italiana", percentualeTweetLinguaItaliana + "%");
		statsFinale.put("Numero Di Tweet Con Locazione Italiana", tweetLocazioneItaliana);
		statsFinale.put("Percentuale Tweet Con Locazione Italiana", percentualeTweetLocazioneItaliana + "%");
		tweetStatsIT.add(statsFinale);
		percentualeTweetLinguaItaliana = 0;
		percentualeTweetLocazioneItaliana = 0;
		return tweetStatsIT;
	}
}
