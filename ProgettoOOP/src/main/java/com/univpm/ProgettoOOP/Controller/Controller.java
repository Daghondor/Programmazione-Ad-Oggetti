package com.univpm.ProgettoOOP.Controller;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univpm.ProgettoOOP.Exception.TweetException;
import com.univpm.ProgettoOOP.Services.*;
import com.univpm.ProgettoOOP.Statistics.StatsIT_DE;
import com.univpm.ProgettoOOP.Util.CountTweet;

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
	 * Rotta di tipo GET che effettua l'analisi su un gruppo di tweet Italiani e Tedeschi
	 * in base al parametro che l'utente inserisce nell'URL (tipo Lingua o Locazione).
	 * @param Tipo Parametro che identifica il tipo di analisi effettuata (Lingua o Locazione) su i tweet italiani e tedeschi.
	 * @return Ritornano i tweet analizzati in base alla tipologia espressa dall'utente nell'URL.
	 * @throws TweetException Eccezione personalizzata per l'array di tweet se e' vuoto o e' null.
	 */
	@GetMapping("/getData")
	public JSONArray getTweet(@RequestParam(name = "tipo", defaultValue = "lingua") String Tipo) throws TweetException
	{
		JSONArray arrayTweet = new JSONArray();
		arrayTweet = DownloadTweet.getTweet(urlTweet);
		
		if(Tipo.equals("lingua"))
		{
			return CountTweet.analisiLinguaTweet(arrayTweet);
		}
		else if(Tipo.equals("location"))
		{
			return CountTweet.analisiLocationTweet(arrayTweet);
		}
		return null;
	}
	
	/**
	 * Rotta di tipo GET che effettua il calcolo delle statistiche su un gruppo di tweet Italiani e Tedeschi.
	 * Viene espressa la tipologia di richiesta ove effettuare le statistiche (su i Tweet Italiani o Tedeschi).
	 * Le statistiche vengono effettuate sia sulla lingua, sia sulla locazione.
	 * @param Tipo Parametro che identifica il tipo di statistiche ove deve essere effettuata (su i Tweet Italiani o Tedeschi).
	 * @return Ritornano le statistiche effettuato o su i Tweet Italiani o Tedeschi.
	 * @throws TweetException Eccezione personalizzata per l'array di tweet se e' vuoto o e' null.
	 */
	@GetMapping("/getStats")
	public JSONArray getStatsTweetIT(@RequestParam(name = "tipo", defaultValue = "IT") String Tipo) throws TweetException 
	{
		JSONArray arrayTweet = new JSONArray();
		arrayTweet = DownloadTweet.getTweet(urlTweet);
		
		if(Tipo.equals("IT"))
		{
			StatsIT_DE statsIT = new StatsIT_DE(CountTweet.analisiLinguaTweet(arrayTweet));
			JSONArray arrayStatsIT = statsIT.StatsTweet(CountTweet.analisiLinguaTweet(arrayTweet), "IT");
			return arrayStatsIT;
		}
		else if(Tipo.equals("DE"))
		{
			StatsIT_DE statsDE = new StatsIT_DE(CountTweet.analisiLinguaTweet(arrayTweet));
			JSONArray arrayStatsDE = statsDE.StatsTweet(CountTweet.analisiLinguaTweet(arrayTweet), "DE");
			return arrayStatsDE;
		}
		return null;
	}
}
