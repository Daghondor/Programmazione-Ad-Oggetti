package com.univpm.ProgettoOOP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.univpm.ProgettoOOP.Model.Tweet;
import com.univpm.ProgettoOOP.Services.BuildingArrayTweet;
import com.univpm.ProgettoOOP.Services.DownloadTweet;
import com.univpm.ProgettoOOP.Util.CountTweet;
import com.univpm.ProgettoOOP.Util.ParsingJSON;

@SpringBootTest
public class ProgettoOopApplicationTests
{
	JSONArray arrayTweetLingua = null;
	JSONArray arrayTweetLocation = null;
	private String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=Coronavirus&count=100&result_type=mixed&since_id=12345";

	
	/**
	 * Inizializza i componenti del test.
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception 
	{
		arrayTweetLingua = new JSONArray();
		arrayTweetLingua = DownloadTweet.getTweet(url, "lingua");
		
		arrayTweetLocation = new JSONArray();
		arrayTweetLocation = DownloadTweet.getTweet(url, "location");
	}

	/**
	 * Serve per distruggere ciò che è stato inizializzato da setUp.
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception 
	{
	}

	/*@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test 1: Verifica se i tweet hanno la lingua italiana.")
	void testLingua_Italiani() 
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
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);
			  
				while ((line = buf.readLine()) != null) 
				{
				 data += line;
				}
			} 
			catch (IOException e) {}
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
				    	JSONObject o1 = (JSONObject) o; 
				    	
				    	try
				    	{
				    		JSONObject objUtente =  (JSONObject) o1.get("user");
					    	String LocationUtente = (String) objUtente.get("location");
				    		if(!LocationUtente.equals(""))
				    		{
				    			String DataCreazione = (String) o1.get("created_at");
						    	String TestoTweet = (String) o1.get("text");
						    	String ID_Tweet = (String) o1.get("id_str");
						    	String LinguaTweet = (String) o1.get("lang");
						    	String PosizioneTweet = (String) o1.get("place");
						    	String NomeUtente = (String) objUtente.get("name");
						    	String ID_utente = (String) objUtente.get("id_str");
						    	
						    	if(PosizioneTweet == null) PosizioneTweet = "Not Aviable";
						    	array = BuildingArrayTweet.Building(ID_Tweet,DataCreazione,
										TestoTweet,LinguaTweet,
										PosizioneTweet,NomeUtente,
										ID_utente, LocationUtente);
				    		}		    	    		
				    	}
				    	catch(Exception e) {}
				 	}
			 }
			 
			 JSONArray listaDeiTweet = new JSONArray();
			 listaDeiTweet = (JSONArray) JSONValue.parseWithException(ParsingJSON.ParsingToJSON(array));
			 array.clear();
			 JSONArray listaTweetLinguaItaliana = new JSONArray();
				
			 for (Object o : listaDeiTweet) 
			 {
				 if (o instanceof JSONObject)
				 {
					 JSONObject o1 = (JSONObject) o;
					 try 
					 {
						 if (((String) o1.get("Lang")).equals("it"))
						 {
							 listaTweetLinguaItaliana.add(o1);
						 }
					 }
					 catch (Exception e) {}
				 }
			 }

			 JSONObject o2 = new JSONObject();
			 o2 = (JSONObject) listaTweetLinguaItaliana.get(0);
			 
			 assertEquals("en", o2.get("Lang"));
		}
		catch (IOException | ParseException e) {} 
		catch (Exception e) {}
	}
	
	
	@SuppressWarnings("unchecked")
	@Test
	@DisplayName("Test 2: Verifica se i tweet hanno la lingua tedesca.")
	void testLingua_Tedeschi() 
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
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);
			  
				while ((line = buf.readLine()) != null) 
				{
				 data += line;
				}
			} 
			catch (IOException e) {}
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
				    	JSONObject o1 = (JSONObject) o; 
				    	
				    	try
				    	{
				    		JSONObject objUtente =  (JSONObject) o1.get("user");
					    	String LocationUtente = (String) objUtente.get("location");
				    		if(!LocationUtente.equals(""))
				    		{
				    			String DataCreazione = (String) o1.get("created_at");
						    	String TestoTweet = (String) o1.get("text");
						    	String ID_Tweet = (String) o1.get("id_str");
						    	String LinguaTweet = (String) o1.get("lang");
						    	String PosizioneTweet = (String) o1.get("place");
						    	String NomeUtente = (String) objUtente.get("name");
						    	String ID_utente = (String) objUtente.get("id_str");
						    	
						    	if(PosizioneTweet == null) PosizioneTweet = "Not Aviable";
						    	array = BuildingArrayTweet.Building(ID_Tweet,DataCreazione,
										TestoTweet,LinguaTweet,
										PosizioneTweet,NomeUtente,
										ID_utente, LocationUtente);
				    		}		    	    		
				    	}
				    	catch(Exception e) {}
				 	}
			 }
			 
			 JSONArray listaDeiTweet = new JSONArray();
			 listaDeiTweet = (JSONArray) JSONValue.parseWithException(ParsingJSON.ParsingToJSON(array));
			 array.clear();
			 JSONArray listaTweetLinguaTedesca = new JSONArray();
				
			 for (Object o : listaDeiTweet) 
			 {
				 if (o instanceof JSONObject)
				 {
					 JSONObject o1 = (JSONObject) o;
					 try 
					 {
						 if (((String) o1.get("Lang")).equals("de"))
						 {
							 listaTweetLinguaTedesca.add(o1);
						 }
					 }
					 catch (Exception e) {}
				 }
			 }

			 JSONObject o2 = new JSONObject();
			 o2 = (JSONObject) listaTweetLinguaTedesca.get(0);
			 
			 assertEquals("ede", o2.get("Lang"));
		}
		catch (IOException | ParseException e) {} 
		catch (Exception e) {}
	}*/
	
	
	@Test
	@DisplayName("Test 2: Verifica se l'array contenente i tweet modellati con la lingua sia diverso da null.")
	void testNotNull() 
	{
		System.out.println("SSSS: "+ arrayTweetLingua.get(0));
		//JSONObject o1 = (JSONObject) arrayTweetLingua.get(0);
		//assertEquals("it", o1.get("Lang"));
	}
	
	
	@Test
	@DisplayName("Test 2: Verifica se l'array contenente i tweet modellati con la lingua sia diverso da null.")
	void testNotNullLingua() 
	{
		assertNotNull(arrayTweetLingua);
	}
	
	@Test
	@DisplayName("Test 3: Verifica se l'array contenente i tweet modellati con la locazione sia diverso da null.")
	void testNotNullLocation() 
	{
		assertNotNull(arrayTweetLocation);
	}
	
	private JSONArray test()
	{
		return null;
		
	}
}
