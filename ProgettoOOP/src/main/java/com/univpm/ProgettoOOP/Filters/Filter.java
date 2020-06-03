package com.univpm.ProgettoOOP.Filters;

import org.json.simple.JSONArray;

/**
 * Interfaccia che per i filtri.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 *
 */
public interface Filter 
{
	/**
	 * Questo metodo retituisce l'array di tweet che contengono tutti i tweet
	 * che rispettano le condizioni di filtraggio.
	 * @return Ritorna l'array di tweet filtrati in base ad i parametri (Lingua - Locazione).
	 */
	public JSONArray filtroLinguaLocazione(JSONArray arrayTweet);
}
