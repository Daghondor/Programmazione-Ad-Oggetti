package com.univpm.ProgettoOOP.Exception;

/**
 * Classe di eccezione personalizzata per la creazione dei tweet.
 * @author Ricciardi Nicola
 *
 */
public class TweetException extends Exception
{
	/**
	 * Numero che viene utilizzato durante la deserializzazione per verificare che il mittente 
	 * e il destinatario di un oggetto serializzato abbiano caricato classi per quell'oggetto 
	 * compatibili rispetto alla serializzazione. 
	 * Se il destinatario ha caricato una classe per l'oggetto che ha una diversa 
	 * serialVersionUIDda quella della corrispondente classe del mittente, la deserializzazione 
	 * si tradurrà in un InvalidClassException. 
	 */
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
