package com.univpm.ProgettoOOP.Controller;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	
	/**
	 * Rotta che preleva i tweet, e ne effettua l'analisi sulla lingua.
	 * @return arrayTweetLingua Ritornano i tweet analizzati sulla lingua modellati in formato JSONArray.
	 */
	@GetMapping("/getDataLanguage")
	public JSONArray getTweetLingua()
	{
		JSONArray arrayTweetLingua = new JSONArray();
		arrayTweetLingua = DownloadTweet.getTweet(urlTweet, "lingua");
		return arrayTweetLingua;
	}
	
	/**
	 * Rotta che preleva i tweet, e ne effettua l'analisi sulla locazione.
	 * @return arrayTweetLocation Ritornano i tweet analizzati sulla locazione modellati in formato JSONArray.
	 */
	@GetMapping("/getDataLocation")
	public JSONArray getTweetLocation()
	{
		JSONArray arrayTweetLocation= new JSONArray();
		arrayTweetLocation = DownloadTweet.getTweet(urlTweet, "location");
		return arrayTweetLocation;
	}
	
	/**
	 * Rotta che mostra le statistiche su i tweet(100), per verificare quanti ne siano itaiani.
	 * @return arrayTweetStats Ritornano le statistiche su i tweet analizzati.
	 */
	@GetMapping("/getStatsIT")
	public JSONArray getStatsTweetIT()
	{
		JSONArray arrayTweetStats = new JSONArray();
		arrayTweetStats = DownloadTweet.getTweet(urlTweet, "statsIT");
		return arrayTweetStats;
	}
	
	
	/**
	 * Rotta che mostra le statistiche su i tweet(100), per verificare quanti ne siano tedeschi.
	 * @return arrayTweetStats Ritornano le statistiche su i tweet analizzati.
	 */
	@GetMapping("/getStatsDE")
	public JSONArray getStatsTweetDE()
	{
		JSONArray arrayTweetStats = new JSONArray();
		arrayTweetStats = DownloadTweet.getTweet(urlTweet, "statsDE");
		return arrayTweetStats;
	}
	
	/*@GetMapping("/getDataParam")
	public JSONArray getTweetWithParam(@RequestParam(name = "lang", defaultValue = "en") String Lang)
	{
		/*if(Lang.equals("it") || Lang.equals("de"))
		{
			String parametroLang = "&lang=" + Lang;
			return DownloadTweet.getTweet(url.substring(0, url.length()) + parametroLang);
		}
		else
		{
			return null;
		}
		String parametroLang = "&lang=" + Lang;
		JSONArray arrayTweetLinguaIT = new JSONArray();
		arrayTweetLinguaIT = DownloadTweet.getTweet(url.substring(0, url.length()) + parametroLang);
		return arrayTweetLinguaIT;
	}
*/
}
