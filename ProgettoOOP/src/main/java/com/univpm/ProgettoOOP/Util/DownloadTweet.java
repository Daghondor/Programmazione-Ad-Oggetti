package com.univpm.ProgettoOOP.Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import com.univpm.ProgettoOOP.Model.Tweet;
import com.univpm.ProgettoOOP.Services.BuildingArrayTweet;

/**
 * Classe per il download dei tweet.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class DownloadTweet 
{
	static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=conte&count=5000";
	/**
	 * Metodo statica che preleva il tweet dalle api, successivamente
	 * effettua l'estrapolazione dei soli parametri che ci servono per creare il nostro oggetto
	 * Twett, e passa questi datti alla classe che si occupa della creazione di questi oggetti.
	 */
	public static JSONArray getTweet()
	{
		try 
		{
			 URLConnection openConnection = new URL(url).openConnection();
	         openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
	         InputStream in = openConnection.getInputStream();
			
			 String data = "";
			 String line = "";
			 try 
			 {
				 InputStreamReader inR = new InputStreamReader( in );
				 BufferedReader buf = new BufferedReader( inR );
			  
				 while ( ( line = buf.readLine() ) != null ) 
				 {
					 data+= line;
				 }
			 } 
			 catch (IOException e) 
			 {
				 System.out.println(e.getCause());
				 System.out.println("ERRORE I/O. OPERAZIONE INTERROTTA.");
			 }
			 finally
			 {
				 in.close();
			 }
			
			 JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			 JSONArray objArray = (JSONArray) obj.get("statuses");
			 ArrayList<Tweet> array = new ArrayList<Tweet>();
			 
			 for(Object o: objArray)
			 {
					if (o instanceof JSONObject)
					{
				    	JSONObject o1 = (JSONObject)o; 
				    	try
				    	{
					    	String DataCreazione = (String) o1.get("created_at");
					    	String TestoTweet = (String) o1.get("text");
					    	String ID_Tweet = (String) o1.get("id_str");
					    	String LinguaTweet = (String) o1.get("lang");
					    	String PosizioneTweet = (String) o1.get("place");
					    	// alle volte da eccezzione sul place
					    	// java.lang.ClassCastException: org.json.simple.JSONObject cannot be cast to java.lang.String
				    		array = BuildingArrayTweet.Building(ID_Tweet,DataCreazione,
									TestoTweet,LinguaTweet,
									PosizioneTweet);
				    	}
				    	catch(Exception e)
				    	{
				    		System.out.println("ERRORE: " + e.getMessage() + e.getCause());
				    	}
				    	
				    	
				    	
				    	//String NomeUtente = (String) o1.get("lang");
				    	//String ID_Utente = (String) o1.get("name");	
				 	}
			 }
			 return (JSONArray) JSONValue.parseWithException(ParsingJSON.ParsingToJSON(array));
			 
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
