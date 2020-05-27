package com.univpm.ProgettoOOP.Controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.univpm.ProgettoOOP.Services.BuildingArrayTweet;
import com.univpm.ProgettoOOP.Util.*;

/**
 * Rappresenta la classe che gestisce tutte le chiamate al Server 
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
@RestController
public class Controller 
{
	/**
	 * Rotta che preleva i tweet.
	 * @return JSONObject Ritornano i tweet in formato JSON.
	 */
	@GetMapping("/getData")
	public JSONObject getTweet()
	{
		return DownloadTweet.getTweet();
		//return (JSONObject) BuildingArrayTweet.getArray(DownloadTweet.getTweet());
	}
}
