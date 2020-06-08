package com.univpm.ProgettoOOP.Controller;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.univpm.ProgettoOOP.Services.*;

/**
 * Rappresenta la classe che gestisce tutte le chiamate al Server 
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
@RestController
public class Controller 
{
	/**
	 * Stringa statica contenente l'URL della API (proxy) di Twitter.
	 * La stringa è composta da:
	 * q = Coronavirus: La query ci restituisce tutti i tweet che contengono come argomento la parola Coronavirus.
	 * count = 100: Ritornano un massimo di 100 tweet (valore massimo impostato dall'azienda Twitter).
	 * result_type = mixed: Ci restituisce i tweet sia recenti, sia popolari.
	 * since_id = 12345: Viene inserito questo parametro per evitare la ridondanza di tweet già prelevati.
	 */
	private String urlTweet = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=Coronavirus&count=100&result_type=mixed&since_id=12345";
	
	/*

	@GetMapping("/getDataLanguage")
	public JSONArray getTweetLingua()
	{
		JSONArray arrayTweetLingua = new JSONArray();
		arrayTweetLingua = DownloadTweet.getTweet(urlTweet, "lingua");
		return arrayTweetLingua;
	}
	

	@GetMapping("/getDataLocation")
	public JSONArray getTweetLocation()
	{
		JSONArray arrayTweetLocation= new JSONArray();
		arrayTweetLocation = DownloadTweet.getTweet(urlTweet, "location");
		return arrayTweetLocation;
	}
	*/
	
	
	@GetMapping("/getData")
	public JSONArray getTweet(@RequestParam(name = "tipo", defaultValue = "lingua") String Tipo)
	{
		JSONArray arrayTweet = new JSONArray();
		arrayTweet = DownloadTweet.getTweet(urlTweet, Tipo);
		return arrayTweet;
	}
	
	/**
	 * Rotta che mostra le statistiche su i tweet(100), per verificare quanti ne siano italiani (Lingua & Locazione).
	 * @return arrayTweetStats Ritornano le statistiche su i tweet analizzati.
	 */
	@GetMapping("/getStats")
	public JSONArray getStatsTweetIT(@RequestParam(name = "tipo", defaultValue = "IT") String Tipo)
	{
		JSONArray arrayTweetStatsIT = new JSONArray();
		arrayTweetStatsIT = DownloadTweet.getTweet(urlTweet, Tipo);
		return arrayTweetStatsIT;
	}
	
	/**
	 * Rotta che mostra le statistiche su i tweet(100), per verificare quanti ne siano tedeschi (Lingua & Locazione).
	 * @return arrayTweetStats Ritornano le statistiche su i tweet analizzati.
	 */
	@GetMapping("/getStatsDE")
	public JSONArray getStatsTweetDE()
	{
		JSONArray arrayTweetStatsDE = new JSONArray();
		arrayTweetStatsDE = DownloadTweet.getTweet(urlTweet, "statsDE");
		return arrayTweetStatsDE;
	}
}
