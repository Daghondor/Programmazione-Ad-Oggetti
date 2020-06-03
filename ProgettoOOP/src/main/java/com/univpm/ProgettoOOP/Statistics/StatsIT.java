package com.univpm.ProgettoOOP.Statistics;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class StatsIT implements Stats
{	
	@SuppressWarnings("unused")
	private static JSONArray tweetStats = new JSONArray();
	
	@SuppressWarnings("unchecked")
	public static JSONArray StatsTweet(JSONArray arrayTweet, int NumeroTweet, int NumeroTweetFiltrati)
	{
		int tweetItaliani = 0;
		float percentualeTweetItaliani = 0;
		
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
					if (((String) o1.get("Lang")).equals("it")) 
					{
						tweetItaliani++;
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
		percentualeTweetItaliani = (float) BigDecimal.valueOf((float) (tweetItaliani * 100) / (float) NumeroTweetFiltrati).setScale(2, RoundingMode.HALF_UP).doubleValue();
		
		c.put("Tweet Esaminati", NumeroTweet);
		c.put("Tweet Filtrati", NumeroTweetFiltrati);
		c.put("Numero Di Tweet Lingua Italiana", tweetItaliani);
		c.put("Percentuale Tweet Lingua Italiana", percentualeTweetItaliani + "%");
		c.put("Numero Di Tweet Con Locazione Italiana", 0);
		c.put("Percentuale Tweet Con Locazione Italiana", 0);
		appoggio.add(c);
		percentualeTweetItaliani = 0;
		return appoggio;
	}
}
