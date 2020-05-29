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
	 * q = Trump: La query ci restituisce tutti i tweet che contengono come argomento la parola Trump.
	 * count = 100: Ritornano un massimo di 100 tweet (valore massimo impostato dall'azienda Twitter).
	 * result_type = mixed: Ci restituisce i tweet sia recenti, sia popolari.
	 * since_id = 12345: Viene inserito questo parametro per evitare la ridondanza di tweet già prelevati.
	 */
	private static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=Trump&count=100&result_type=mixed&since_id=12345";
	
	/**
	 * Rotta che preleva i tweet.
	 * @return arrayTweetGenerici Ritornano i tweet generici modellati in formato JSONArray.
	 */
	@GetMapping("/getData")
	public JSONArray getTweet()
	{
		JSONArray arrayTweetGenerici = new JSONArray();
		arrayTweetGenerici = DownloadTweet.getTweet(url);
		return arrayTweetGenerici;
	}
	

	/**
	 * Rotta che preleva i tweet con il filtro sulla lingua passato dall'utente.
	 * @param Lang Lingua prelevata dall'url.
	 * @return arrayTweetLinguaIT Ritornano i tweet filtrati sulla lingua.
	 */
	@GetMapping("/getDataParam")
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
		}*/
		String parametroLang = "&lang=" + Lang;
		JSONArray arrayTweetLinguaIT = new JSONArray();
		arrayTweetLinguaIT = DownloadTweet.getTweet(url.substring(0, url.length()) + parametroLang);
		return arrayTweetLinguaIT;
	}
}
