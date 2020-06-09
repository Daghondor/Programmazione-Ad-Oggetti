package com.univpm.ProgettoOOP.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Classe che contiene il metodo statico per il calcolo delle statistiche.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class StatsUtils
{	
	/**
	 * Array che contiene le statitiche effettuate su i tweet.
	 */
	private static JSONArray tweetStats = new JSONArray();
	
	/**
	 * Metodo statico che effettua le statistiche su i tweet Italiani e Tedeschi.
	 * @param array Array che contiene tutti i tweet italiani e tedeschi.
	 * @param value Indica il la tipologia ove verranno effettuate le statistiche (IT o DE).
	 * @return tweetStats Ritorna l'array (modellato secondo una nostra struttura) contenente le statistiche effettuate su i tweet.
	 */
	@SuppressWarnings("unchecked")
	public JSONArray getStats(JSONArray array, Object value)
	{
		int tweetLinguaItaliana = 0, tweetLocazioneItaliana = 0;
		int tweetLinguaTedesca = 0, tweetLocazioneTedesca = 0;
		float percentualeTweetLinguaItaliana = 0, percentualeTweetLocazioneItaliana = 0;
		float percentualeTweetLinguaTedesca = 0, percentualeTweetLocazioneTedesca = 0;
		String lingua = (String) value;
		JSONObject statsFinale = new JSONObject();
		
		tweetStats.clear();
		statsFinale.clear();
		
		for (Object o : array) 
		{
			if (o instanceof JSONObject)
			{
				JSONObject o1 = (JSONObject) o;
				try 
				{
					// ITALIANO
					if(lingua.equals("IT") | lingua.equals("it"))
					{
						JSONObject posizione = (JSONObject) o1.get("Posizione");
						
						if (((String) o1.get("Lang")).equals("it")) 
						{
							tweetLinguaItaliana++;
						} 
						if(((String) posizione.get("Country_Code")).equals("IT"))
						{
							tweetLocazioneItaliana++;
						}
					}
					
					// TEDESCO
					else if(lingua.equals("DE") | lingua.equals("de"))
					{
						JSONObject posizione = (JSONObject) o1.get("Posizione");
						
						if (((String) o1.get("Lang")).equals("de")) 
						{
							tweetLinguaTedesca++;
						} 
						if(((String) posizione.get("Country_Code")).equals("DE"))
						{
							tweetLocazioneTedesca++;
						}
					}
				} 
				catch (Exception e) 
				{
					System.out.println("ERRORE.");
					System.out.println("MESSAGGIO: " + e.getMessage());
					System.out.println("CAUSA: " + e.getCause());
				}
			}
		}
		
		if(lingua.equals("IT") | lingua.equals("it"))
		{
			try
			{
				percentualeTweetLinguaItaliana = (float) BigDecimal.valueOf((float) (tweetLinguaItaliana * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
				percentualeTweetLocazioneItaliana = (float) BigDecimal.valueOf((float) (tweetLocazioneItaliana * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
				statsFinale.put("Tweet Filtrati (IT & DE)", array.size());
				statsFinale.put("Numero Di Tweet Lingua Italiana", tweetLinguaItaliana);
				statsFinale.put("Percentuale Tweet Lingua Italiana", percentualeTweetLinguaItaliana + "%");
				statsFinale.put("Numero Di Tweet Con Locazione Italiana", tweetLocazioneItaliana);
				statsFinale.put("Percentuale Tweet Con Locazione Italiana", percentualeTweetLocazioneItaliana + "%");
				tweetStats.add(statsFinale);
			}
			catch(NumberFormatException e)
			{
				System.out.println("ERRORE. OPERAZIONE CALCOLO STATISTICHE INTERROTA.");
	    		System.out.println("MESSAGGIO: " + e.getMessage());
	    		System.out.println("CAUSA: " + e.getCause());
			}
		}
		else if(lingua.equals("DE") | lingua.equals("de"))
		{
			try
			{
				percentualeTweetLinguaTedesca = (float) BigDecimal.valueOf((float) (tweetLinguaTedesca * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
				percentualeTweetLocazioneTedesca = (float) BigDecimal.valueOf((float) (tweetLocazioneTedesca * 100) / (float) array.size()).setScale(2, RoundingMode.HALF_UP).doubleValue();
				statsFinale.put("Tweet Filtrati (IT & DE)", array.size());
				statsFinale.put("Numero Di Tweet Lingua Tedesca", tweetLinguaTedesca);
				statsFinale.put("Percentuale Tweet Lingua Tedesca", percentualeTweetLinguaTedesca  + "%");
				statsFinale.put("Numero Di Tweet Con Locazione Tedesca", tweetLocazioneTedesca );
				statsFinale.put("Percentuale Tweet Con Locazione Tedesca", percentualeTweetLocazioneTedesca  + "%");
				tweetStats.add(statsFinale);
			}
			catch(NumberFormatException e)
			{
				System.out.println("ERRORE. OPERAZIONE CALCOLO STATISTICHE INTERROTA.");
	    		System.out.println("MESSAGGIO: " + e.getMessage());
	    		System.out.println("CAUSA: " + e.getCause());
			}
		}
		if(tweetStats == null | tweetStats.isEmpty())
		{
			JSONObject arrayVoid = new JSONObject();
			arrayVoid.put("STATISTICA ABORTITA", "");
			arrayVoid.put("Tweet Italiani", "0");
			arrayVoid.put("Tweet Tedeschi", "0");
			tweetStats.add(arrayVoid);
			return tweetStats;
		}
		return tweetStats;
	}
}