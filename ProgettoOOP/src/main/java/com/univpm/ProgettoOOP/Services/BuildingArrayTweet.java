package com.univpm.ProgettoOOP.Services;

import java.util.ArrayList;

import com.univpm.ProgettoOOP.Model.PosizioneTweet;
import com.univpm.ProgettoOOP.Model.Tweet;

/**
 * Classe per la creazione degi arrayList di tipo tweet.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class BuildingArrayTweet 
{
	/**
	 * ArrayList che conterrà tutti i nostri tweet modellati.
	 */
	private static ArrayList<Tweet> arrayLista = new ArrayList<Tweet>();
	
	/**
	 * Metodo statico che popola l'arrayList di tipo tweet, con tutti i tweet che ci servono.
	 * @param id_tweet ID del tweet prelevato.
	 * @param dataCreazione Data di creazione del tweet.
	 * @param testo Il testo del tweet.
	 * @param lingua La lingua del tweet.
	 * @param locazioneTweet La locazione del Tweet.
	 * @param nomeUtente Il nome dell'utente che ha postato il tweet.
	 * @param id_utente L'ID dell'utente che ha postato il tweet.
	 * @param locazioneUtente Locazione dell'utente.
	 * @return arrayLista Lista di array di tipo tweet contenente tutti i tweet (modellati secondo i nostri parametri) che la query di ricerca restituisce.
	 */
	public static ArrayList<Tweet> Building(String id_tweet, String dataCreazione, String testo, String lingua, String nomeUtente, String id_utente, String locazioneUtente, PosizioneTweet posizione)
	{
		Tweet singoloTweet = new Tweet(id_tweet, dataCreazione, testo, lingua, nomeUtente, id_utente, locazioneUtente, posizione);
		arrayLista.add(singoloTweet);
		return arrayLista;
	}
}
