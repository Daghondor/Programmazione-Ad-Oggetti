package com.univpm.ProgettoOOP.Exception;

/**
 * Classe di eccezione personalizzata per la creazione dei tweet.
 * @author Ricciardi Nicola
 *
 */
public class TweetException extends Exception
{
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore della classe di eccezione personalizzata.
	 */
	public TweetException()
	{
		super();
		System.out.println("PROBLEMI RISCONTRATI DURANTE LA CREAZIONE DEI TWEET.");
	}
}
