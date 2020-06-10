package com.univpm.ProgettoOOP.Controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univpm.ProgettoOOP.Exception.TweetException;
import com.univpm.ProgettoOOP.Filters.FilterIT_IT;
import com.univpm.ProgettoOOP.Services.*;
import com.univpm.ProgettoOOP.Statistics.StatsIT_DE;
import com.univpm.ProgettoOOP.Utils.CountTweet;

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
	@SuppressWarnings("unchecked")
	@GetMapping("/Data")
	public JSONArray getData(@RequestParam(name = "tipo", defaultValue = "lingua") String Tipo) throws TweetException
	{
		JSONArray arrayTweet = new JSONArray();
		arrayTweet = DownloadTweet.getTweet(urlTweet);
		
		if(Tipo.equals("lingua"))
		{
			if(CountTweet.analisiLinguaTweet(arrayTweet).isEmpty() | CountTweet.analisiLinguaTweet(arrayTweet) == null)
			{
				JSONObject objVoid = new JSONObject();
				JSONArray arrayVoid = new JSONArray();
				objVoid.put("TWEET SU BASE LINGUA", "");
				objVoid.put("Tweet Italiani", "0");
				objVoid.put("Tweet Tedeschi", "0");
				arrayVoid.add(objVoid);
				return arrayVoid;
			}
			else
			{
				return CountTweet.analisiLinguaTweet(arrayTweet);
			}

		}
		else if(Tipo.equals("location"))
		{
			if(CountTweet.analisiLinguaTweet(arrayTweet).isEmpty() | CountTweet.analisiLinguaTweet(arrayTweet) == null)
			{
				JSONObject objVoid = new JSONObject();
				JSONArray arrayVoid = new JSONArray();
				objVoid.put("TWEET SU BASE LOCAZIONE", "");
				objVoid.put("Tweet Italiani", "0");
				objVoid.put("Tweet Tedeschi", "0");
				arrayVoid.add(objVoid);
				return arrayVoid;
			}
			else
			{
				return CountTweet.analisiLocationTweet(arrayTweet);
			}
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
	@GetMapping("/Stats")
	public JSONArray getStats(@RequestParam(name = "tipo", defaultValue = "IT") String Tipo) throws TweetException 
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
	
	/**
	 * Rotta di tipo POST che effettua il filtraggio dei tweet in base alla lingua e locazione
	 * inserita dall'utente.
	 * La Lingua e la Locazione vengono prelevate dal body della richiesta.
	 * @param bodyFilter Body della richiesta POST contenente la lingua e la locazione.
	 * @return Ritornano i Tweet filtrati Italiani/Tedeschi.
	 * @throws TweetException Eccezione personalizzata per l'array di tweet se e' vuoto o e' null.
	 */
	@PostMapping("/Filter")
	public JSONArray getFilters(@RequestBody JSONObject bodyFilter) throws TweetException 
	{
		JSONArray arrayTweet = new JSONArray();
		arrayTweet = DownloadTweet.getTweet(urlTweet);
		String Lingua = (String) bodyFilter.get("Lang");
		String Locazione = (String) bodyFilter.get("Location");

		if(Lingua.equals("it") & Locazione.equals("IT"))
		{
			FilterIT_IT filterIT_IT = new FilterIT_IT(CountTweet.analisiLinguaTweet(arrayTweet));
			JSONArray arrayFilterIT_IT = filterIT_IT.filtersTweet(CountTweet.analisiLinguaTweet(arrayTweet), "it", "IT");
			return arrayFilterIT_IT;
		}
		else if(Lingua.equals("it") & Locazione.equals("DE"))
		{
			FilterIT_IT filterIT_DE = new FilterIT_IT(CountTweet.analisiLinguaTweet(arrayTweet));
			JSONArray arrayFilterIT_DE = filterIT_DE.filtersTweet(CountTweet.analisiLinguaTweet(arrayTweet), "it", "DE");
			return arrayFilterIT_DE;
		}
		else if(Lingua.equals("de") & Locazione.equals("IT"))
		{
			FilterIT_IT filterDE_IT = new FilterIT_IT(CountTweet.analisiLinguaTweet(arrayTweet));
			JSONArray arrayFilterDE_IT = filterDE_IT.filtersTweet(CountTweet.analisiLinguaTweet(arrayTweet), "de", "IT");
			return arrayFilterDE_IT;
		}
		else if(Lingua.equals("de") & Locazione.equals("DE"))
		{
			FilterIT_IT filterDE_DE = new FilterIT_IT(CountTweet.analisiLinguaTweet(arrayTweet));
			JSONArray arrayFilterDE_DE = filterDE_DE.filtersTweet(CountTweet.analisiLinguaTweet(arrayTweet), "de", "DE");
			return arrayFilterDE_DE;
		}
		return null;
	}
	
}
