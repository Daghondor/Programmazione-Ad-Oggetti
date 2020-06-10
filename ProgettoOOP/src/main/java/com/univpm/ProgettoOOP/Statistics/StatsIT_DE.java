package com.univpm.ProgettoOOP.Statistics;

import org.json.simple.JSONArray;

import com.univpm.ProgettoOOP.Utils.*;

/**
 * Classe che implementa l'interfaccia delle statistiche e ne effettua l'override.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class StatsIT_DE implements Stats<Object>
{
	/**
	 * Array contenente i tweet.
	 */
	private JSONArray arrayTweet;
	
	/**
	 * Variabile usata per richiamare il metodo presente nella classe StatsUtils.
	 */
	private StatsUtils utils;
	
	/**
	 * Costruttore della classe StatsIT_DE.
	 * @param array Array di tweet.
	 */
	public StatsIT_DE(JSONArray array)
	{
		super();
		this.arrayTweet = array;
		this.utils = new StatsUtils();
	}
	
	/**
	 * Getter dell'array di tweet.
	 * @return arrayTweet Ritorna l'array di tweet.
	 */
	public JSONArray getTweet()
	{
		return arrayTweet;
	}
	
	/**
	 * Override del metodo abstract StatsTweet dell'interfaccia, che richiama il metodo che effettua le statistiche.
	 * @return Ritorna l'array contenente le statitiche effettuate su i tweet in base alla lingua scelta dall'utente.
	 */
	@Override
	public JSONArray StatsTweet(JSONArray arrayTweet, Object lingua) 
	{
		return (JSONArray) utils.getStats(this.getTweet(), lingua);
	}
}
