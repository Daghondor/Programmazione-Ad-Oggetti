package com.univpm.ProgettoOOP.Statistics;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class StatsIT implements Stats
{	
	private static JSONArray tweetStats = new JSONArray();
	
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
		percentualeTweetItaliani = (100/NumeroTweetFiltrati) * tweetItaliani;
		c.put("Tweet Esaminati", NumeroTweet);
		c.put("Tweet Filtrati", NumeroTweetFiltrati);
		c.put("Numero Di Tweet Italiani", tweetItaliani);
		c.put("Percentuale Tweet Italiani", percentualeTweetItaliani);
		appoggio.add(c);
		percentualeTweetItaliani = 0;
		return appoggio;
	}
}
