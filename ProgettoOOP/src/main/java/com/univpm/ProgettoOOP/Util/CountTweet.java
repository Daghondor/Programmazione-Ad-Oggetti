package com.univpm.ProgettoOOP.Util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class CountTweet
{
	private static int numeroTweetItaliani = 0, numeroTweetTedeschi = 0;
	private static JSONArray tweetItalianiETedeschi = new JSONArray();
	
	public static JSONArray count(JSONArray listaTweet)
	{
		JSONArray listaTweetItaliani = new JSONArray();
		JSONArray listaTweetTedeschi = new JSONArray();
		
		 for(Object o: listaTweet)
		 {
			 if (o instanceof JSONObject)
				{
			    	JSONObject o1 = (JSONObject) o; 
			    	try
			    	{
			    		if(((String) o1.get("Lang")).equals("it"))
			    		{
			    			numeroTweetItaliani++;
			    			listaTweetItaliani.add(o1);
			    		}
			    		else if(((String)o1.get("Lang")).equals("de"))
			    		{
			    			numeroTweetTedeschi++;
			    			listaTweetTedeschi.add(o1);
			    		}
			    	}
			    	catch(Exception e)
			    	{
			    		System.out.println("ERRORE.");
			    		System.out.println("MESSAGGIO: " + e.getMessage());
			    		System.out.println("CAUSA: " + e.getCause());

			    	}
			 	}
		 }
		 tweetItalianiETedeschi.add(listaTweetItaliani);
		 tweetItalianiETedeschi.add(listaTweetTedeschi);
		return tweetItalianiETedeschi;
	}
}
