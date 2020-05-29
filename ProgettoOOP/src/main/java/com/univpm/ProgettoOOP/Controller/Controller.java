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
	 */
	static String url = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/search/tweets.json?q=conte&count=5000";
	
	/**
	 * Rotta che preleva i tweet.
	 * @return  Ritornano i tweet modellati in formato JSONArray.
	 * @throws LangException 
	 */
	@GetMapping("/getData")
	public JSONArray getTweet()
	{
		return DownloadTweet.getTweet(url);
	}
	

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
		System.out.println("CCC: "+ url.substring(0, url.length()) + parametroLang);
		return DownloadTweet.getTweet(url.substring(0, url.length()) + parametroLang);
	}
}
