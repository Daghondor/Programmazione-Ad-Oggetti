package com.univpm.ProgettoOOP.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;


public class DownloadTweet 
{
	public static JSONObject getTweet()
	{
		String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=spaceX&count=2";
		
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
			 System.out.println(data);
			
			 JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			 JSONArray objArray = (JSONArray) obj.get("statuses");
			 
			 for(Object o: objArray)
			 {
					if (o instanceof JSONObject)
					{
				    	JSONObject o1 = (JSONObject)o; 
				    	System.out.println(o1.get("created_at"));
				    	//String name = (String)o1.get("created_at");
				    	//String urlD = (String)o1.get("url");

				 	}
			 }
			 
			 return (JSONObject) obj;
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
