package com.univpm.ProgettoOOP.Utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FiltersUtils 
{
	/**
	 * Array che contiene i tweet filtrati.
	 */
	private static JSONArray tweetFiltered = new JSONArray();
	
	@SuppressWarnings("unchecked")
	public JSONArray getTweetFiltered(JSONArray array, Object lang, Object location)
	{
		tweetFiltered.clear();
		for (Object o : array) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
				{
					JSONObject posizione = (JSONObject) o1.get("Posizione");	
					
					if(o1.get("Lang").equals((String)lang) & posizione.get("Country_Code").equals((String)location))
					{
						tweetFiltered.add(o1);
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
		if(tweetFiltered == null | tweetFiltered.isEmpty())
		{
			JSONObject arrayVoid = new JSONObject();
			arrayVoid.put("FILTRAGGIO ABORTITO", "");
			arrayVoid.put("Tweet Italiani", "0");
			arrayVoid.put("Tweet Tedeschi", "0");
			tweetFiltered.add(arrayVoid);
			return tweetFiltered;
		}
		return tweetFiltered;
	}
	
}
