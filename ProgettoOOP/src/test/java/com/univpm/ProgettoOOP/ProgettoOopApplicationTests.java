package com.univpm.ProgettoOOP;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.univpm.ProgettoOOP.Services.DownloadTweet;
import com.univpm.ProgettoOOP.Utils.CountTweet;

/**
 * Classe per il testing dell'applicazione.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
@SpringBootTest
public class ProgettoOopApplicationTests
{
	/**
	 * Array che conterra' i tweet (100 casuali).
	 */
	private JSONArray arrayTweet = null;
	
	/**
	 * Array che conterra' i tweet con la locazione Italiana e Tedesca.
	 */
	private JSONArray arrayTweetLocation = null;
	
	/**
	 * Array che conterra' i tweet con la lingua Italiana e Tedesca.
	 */
	private JSONArray arrayTweetLingua = null;
	
	/**
	 * URL della API di Twitter.
	 */
	private String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=Coronavirus&count=100&result_type=mixed&since_id=12345";

	
	/**
	 * Inizializza i componenti del test.
	 * @throws Exception Possibile Eccezione.
	 */
	@BeforeEach
	public void setUp() throws Exception 
	{
		arrayTweet = new JSONArray();
		arrayTweetLingua = new JSONArray();
		arrayTweetLocation = new JSONArray();
		arrayTweet = DownloadTweet.getTweet(url);
		arrayTweetLingua = CountTweet.analisiLinguaTweet(arrayTweet);
		arrayTweetLocation = CountTweet.analisiLocationTweet(arrayTweet);
	}

	/**
	 * Serve per distruggere ciò che e' stato inizializzato dal setUp.
	 * @throws Exception Possibile Eccezione.
	 */
	@AfterEach
	public void tearDown() throws Exception 
	{
	}
	
	/**
	 * Test che verifica se i tweet hanno la lingua o Italiana o Tedesca.
	 */
	@Test
	@DisplayName("Test 1: Verifica se i tweet hanno la lingua italiana.")
	public void testLinguaIT_DE() 
	{
		assertNotNull(arrayTweetLingua);
		
		for (Object o : arrayTweetLingua) 
		{
			if (o instanceof JSONObject) {
				JSONObject o1 = (JSONObject) o;

				try 
				{
					assertTrue("Errore Nella Lingua: " + o1.get("Lang"), o1.get("Lang").equals("it") | o1.get("Lang").equals("de"));

				} 
				catch (Exception e) {}
			}
		}
	}
	
	/**
	 * Test che verifica se il vettore di tweet (in base lingua) not e' null.
	 */
	@Test
	@DisplayName("Test 2: Verifica se l'array contenente i tweet modellati con la lingua sia diverso da null.")
	public void testNotNullLingua() 
	{
		assertNotNull(arrayTweetLingua);
	}
	
	/**
	 * Test che verifica se il vettore di tweet (in base locazione) not e' null.
	 */
	@Test
	@DisplayName("Test 3: Verifica se l'array contenente i tweet modellati con la locazione sia diverso da null.")
	public void testNotNullLocation() 
	{
		assertNotNull(arrayTweetLocation);
	}
}
