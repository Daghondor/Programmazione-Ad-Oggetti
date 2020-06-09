package com.univpm.ProgettoOOP.Filters;

import org.json.simple.JSONArray;

/**
 * Interfaccia per i filtri.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 *
 */
public interface Filters<E,T>
{
	abstract JSONArray filtersTweet(JSONArray arrayTweet, E lingua, T locazione);
}
