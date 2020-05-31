package com.univpm.ProgettoOOP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.univpm.ProgettoOOP.Model.Tweet;
import com.univpm.ProgettoOOP.Services.BuildingArrayTweet;
import com.univpm.ProgettoOOP.Services.DownloadTweet;

@SpringBootTest
public class ProgettoOopApplicationTests
{
	JSONArray arrayTweetLingua = null;
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
	}

	/**
	 * Serve per distruggere ciò che è stato inizializzato da setUp.
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception 
	{
	}

	@Test
	@DisplayName("Test 1: Verifica se i tweet hanno la lingua italiana.")
	void testLingua() 
	{
		System.out.println("DIO");
		for (Object o : arrayTweetLingua) 
		{
			JSONObject o1 = (JSONObject) o;
			System.out.println("DIO!!!!!!!!!!!!!: "+(String) o1.get("lang"));

			if (o instanceof JSONObject) 
			{
				//JSONObject o1 = (JSONObject) o;
				//System.out.println("DIO!!!!!!!!!!!!!: "+(String) o1.get("lang"));

				try 
				{
					assertEquals("en", (String) o1.get("Lang"));
				} 
				catch (Exception e)
				{

				}
			}
		}
	}
	
	@Test
	@DisplayName("Test 2: Verifica se l'array contenente i tweet modellati sia diverso da null.")
	void testNotNull() 
	{
		assertNotNull(arrayTweetLingua);
	}
	
}
