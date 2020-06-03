package com.univpm.ProgettoOOP.Statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StatsDE implements Stats
{
	@SuppressWarnings("unused")
	private static JSONArray tweetStats = new JSONArray();
	
	@SuppressWarnings("unchecked")
	public static JSONArray StatsTweet(JSONArray arrayTweet, int NumeroTweet, int NumeroTweetFiltrati)
	{
		int tweetTedeschi = 0;
		float percentualeTweetTedeschi = 0;
		
		JSONObject c = new JSONObject();
		JSONArray appoggio = new JSONArray();
		c.clear();
		appoggio.clear();
		
		for (Object o : arrayTweet) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
				{
					if (((String) o1.get("Lang")).equals("de")) 
					{
						tweetTedeschi++;
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
		percentualeTweetTedeschi = (float) BigDecimal.valueOf((float) (tweetTedeschi * 100) / (float) NumeroTweetFiltrati).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		c.put("Tweet Esaminati", NumeroTweet);
		c.put("Tweet Filtrati", NumeroTweetFiltrati);
		c.put("Numero Di Tweet Lingua Tedesca", tweetTedeschi);
		c.put("Percentuale Tweet Lingua Tedesca", percentualeTweetTedeschi + "%");
		c.put("Numero Di Tweet Con Locazione Tedesca", 0);
		c.put("Percentuale Tweet Con Locazione Tedesca", 0);
		appoggio.add(c);
		percentualeTweetTedeschi = 0;		
		return appoggio;
	}
}
