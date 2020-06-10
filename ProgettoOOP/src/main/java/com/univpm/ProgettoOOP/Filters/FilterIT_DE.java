package com.univpm.ProgettoOOP.Filters;

import org.json.simple.JSONArray;

import com.univpm.ProgettoOOP.Utils.FiltersUtils;

/**
 * Classe che implementa il filtraggio della lingua IT e della locazione DE su i tweet.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class FilterIT_DE implements Filters<Object, Object>
{
	/**
	 * Array contenente i tweet.
	 */
	private JSONArray arrayTweet;
	
	/**
	 * Variabile usata per richiamare il metodo presente nella classe FiltersUtils.
	 */
	private FiltersUtils utils;
	
	/**
	 * Costruttore della classe FilterIT_DE.
	 * @param array Array di tweet.
	 */
	public FilterIT_DE(JSONArray array)
	{
		super();
		this.arrayTweet = array;
		this.utils = new FiltersUtils();
	}
	
	/**
	 * Getter dell'array di tweet.
	 * @return arrayTweet Ritorna l'array di tweet.
	 */
	public JSONArray getTweet()
	{
		return arrayTweet;
	}
	
	@Override
	public JSONArray filtersTweet(JSONArray arrayTweet, Object lingua, Object locazione)
	{
		return (JSONArray) utils.getTweetFiltered(this.getTweet(), lingua, locazione);
	}
}
