package com.univpm.ProgettoOOP.Statistics;

import org.json.simple.JSONArray;

/**
 * Interfaccia per le statistiche.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 * @param <T> Parametro di tipo generico.
 */
public interface Stats<T>
{
	/**
	 * Metodo astratto privo di implementazione, che verrà implementato successivamente a seconda delle nostre esigenze.
	 * @param arrayTweet Array contenente i tweet italiani e tedeschi.
	 * @param lingua Lingua ove si vuole effettuare la statistica.
	 * @return Ritorna l'array contenente le statitiche effettuate su i tweet.
	 */
	abstract JSONArray StatsTweet(JSONArray arrayTweet, T lingua);
}
