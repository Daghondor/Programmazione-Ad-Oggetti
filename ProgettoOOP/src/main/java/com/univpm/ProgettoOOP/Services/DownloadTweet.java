package com.univpm.ProgettoOOP.Services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import com.univpm.ProgettoOOP.Exception.*;
import com.univpm.ProgettoOOP.Model.*;
import com.univpm.ProgettoOOP.Model.Tweet;
import com.univpm.ProgettoOOP.Utils.*;

/**
 * Classe per il download dei tweet modellati.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class DownloadTweet 
{
	/**
	 * ArrayList che contiene tutte le citta' italiane e tedesche.
	 */
	private static ArrayList<PosizioneTweet> arrayCittaIT_DE = new ArrayList<PosizioneTweet>();
	
	/**
	 * Stringa statica contenente l'URL della API (proxy) di Twitter per richiedere le citta' italiane 
	 * vicine partendo da una coordinata.
	 * La stringa è composta da:
	 * lat: Latitudine del punto.
	 * lot: Longitudine del punto.
	 * accuracy: Indica il raggio massimo per prelevare le citta'.
	 */
	private static String urlCittaItaliane = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?lat=43.0087&lon=12.7716&accuracy=100000m";
	
	/**
	 * Stringa statica contenente l'URL della API (proxy) di Twitter per richiedere le citta' tedesche
	 * vicine partendo da una coordinata.
	 * La stringa è composta da:
	 * lat: Latitudine del punto.
	 * lot: Longitudine del punto.
	 * accuracy: Indica il raggio massimo per prelevare le citta'.
	 */
	private static String urlCittaTedesche = "https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/user/1.1/geo/search.json?lat=51.0690&lon=10.0305&accuracy=100000m";
	
	/**
	 * Metodo statico che preleva i tweet dall'URL passato dal controller, successivamente
	 * effettua l'estrapolazione dei soli parametri che ci servono per creare il nostro oggetto
	 * Tweet, ed infine l'array di tweet modellato ritorna al controller che ne effettua le dovute analisi.
	 * @param url URL delle API (proxy) di Twitter.
	 * @return listaDeiTweet Ritorna al controller la lista dei tweet modellati.
	 * @throws TweetException Eccezione personalizzata per l'array di tweet se e' vuoto o e' null.
	 */
	public static JSONArray getTweet(String url) throws TweetException
	{
		try
		{
			arrayCittaIT_DE.clear();
		}
		catch(NullPointerException e)
		{
			 System.out.println("ERRORE. PROBLEAMI NELLA CREAZIONE DELL'ARRAY CITTA'.");
			 System.out.println("MESSAGGIO: " + e.getMessage());
			 System.out.println("CAUSA: " + e.getCause());
		}
		arrayCittaIT_DE = prelevaCitta(urlCittaItaliane, urlCittaTedesche);
		try 
		{
			 URLConnection openConnection = new URL(url).openConnection();
	         openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
	         InputStream in = openConnection.getInputStream();
	         
			 String data = "";
			 String line = "";
			 try 
			 {
				 InputStreamReader inR = new InputStreamReader(in);
				 BufferedReader buf = new BufferedReader(inR);
			  
				 while ((line = buf.readLine()) != null) 
				 {
					 data += line;
				 }
			 } 
			 catch (IOException e) 
			 {
				 System.out.println("ERRORE. OPERAZIONE I/O INTERROTTA.");
				 System.out.println("MESSAGGIO: " + e.getMessage());
				 System.out.println("CAUSA: " + e.getCause());
			 }
			 finally
			 {
				 in.close();
			 }
			
			 JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
			 JSONArray objArray = (JSONArray) obj.get("statuses");
			 ArrayList<Tweet> array = new ArrayList<Tweet>();
			 
			 for(Object o: objArray)
			 {
				 if (o instanceof JSONObject)
				 {
					 JSONObject o1 = (JSONObject) o; 
					 try
					 {
						 // Statuses
						 String DataCreazione = (String) o1.get("created_at");
						 String TestoTweet = (String) o1.get("text");
						 String ID_Tweet = (String) o1.get("id_str");
						 String LinguaTweet = (String) o1.get("lang");

						 // Users
						 JSONObject objUtente = (JSONObject) o1.get("user");
						 String NomeUtente = (String) objUtente.get("name");
						 String ID_utente = (String) objUtente.get("id_str");
						 String LocationUtente = (String) objUtente.get("location");
						 if (LocationUtente.equals("")) LocationUtente = "Not Aviable";

						 // Place
						 JSONObject objPosizione = (JSONObject) o1.get("place");
						 PosizioneTweet Posizione = null;
						 if(objPosizione != null)
						 {
							 String PosizioneID = (String) o1.get("id");
							 String PosizioneName = (String) o1.get("name");
							 String PosizioneFullName = (String) o1.get("full_name");
							 String PosizionePlaceType = (String) o1.get("place_type");
							 String PosizioneCountryCode = (String) o1.get("country_code");
							 String PosizioneCountry = (String) o1.get("country");
							 Posizione = new PosizioneTweet(PosizioneID, PosizionePlaceType, 
									 						PosizioneName, PosizioneFullName, 
									 						PosizioneCountryCode, PosizioneCountry);
						 }
						 else if(objPosizione == null)
						 {
							 if(LinguaTweet.equals("it") | LinguaTweet.equals("de"))
							 {
								 int numeroRandom = randomCity(arrayCittaIT_DE.size());
								 Posizione = arrayCittaIT_DE.get(numeroRandom);
							 }
						 }
						 array = BuildingArrayTweet.Building(ID_Tweet, DataCreazione, 
								 							 TestoTweet, LinguaTweet,
								 							 NomeUtente, ID_utente, 
								 							 LocationUtente, Posizione);
						 if(array.isEmpty() | array == null) throw new TweetException();
					 }
					 catch(Exception e)
					 {
						 System.out.println("ERRORE. OPERAZIONE INTERROTTA NEL PRELEVAGGIO DEI PARAMETRI.");
						 System.out.println("MESSAGGIO: " + e.getMessage());
						 System.out.println("CAUSA: " + e.getCause());
					 }	
				 }
			 }
			 
			 JSONArray listaDeiTweet = new JSONArray();
			 listaDeiTweet = (JSONArray) JSONValue.parseWithException(ParsingJSON.ParsingToJSON(array));
			 array.clear();
			 return listaDeiTweet;
		}
		catch (IOException | ParseException e)
		{
    		System.out.println("ERRORE. OPERAZIONE I/O - PARSING INTERROTTA .");
    		System.out.println("MESSAGGIO: " + e.getMessage());
    		System.out.println("CAUSA: " + e.getCause());
		} 
		catch (Exception e) 
		{
    		System.out.println("ERRORE GENERICO.");
    		System.out.println("MESSAGGIO: " + e.getMessage());
    		System.out.println("CAUSA: " + e.getCause());
		}
		return null;
	}
	
	/**
	 * Metodo statico che si occupa di estrapolare, partendo da una latitudine e longitudine,
	 * le città che si trovano nei pressi di tale punto.
	 * Il metodo estrapola sia le citta' italiane, sia le citta' tedesche. 
	 * @param urlCittaItaliane URL delle API (proxy) di Twitter per le citta' italiane.
	 * @param urlCittaTedesche URL delle API (proxy) di Twitter per le citta' tedesche.
	 * @return arrayCittaIT_DE Ritorna la lista contenente le citta' sia italiane, sia tedesche.
	 */
	private static ArrayList<PosizioneTweet> prelevaCitta(String urlCittaItaliane, String urlCittaTedesche)
	{
		String data = "", data2 = "";
		
		// ---------------------- INIZIO PRIMA CHIAMATA -----------------------
		try 
		{
			 URLConnection openConnection = new URL(urlCittaItaliane).openConnection();
	         openConnection.addRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
	         InputStream in = openConnection.getInputStream();
	         
			 String line = "";
			 try 
			 {
				 InputStreamReader inR = new InputStreamReader(in);
				 BufferedReader buf = new BufferedReader(inR);
			  
				 while ((line = buf.readLine()) != null) 
				 {
					 data += line;
				 }
			 } 
			 catch (IOException e) 
			 {
		    		System.out.println("ERRORE. OPERAZIONE I/O INTERROTTA.");
		    		System.out.println("MESSAGGIO: " + e.getMessage());
		    		System.out.println("CAUSA: " + e.getCause());
			 }
			 finally
			 {
				 in.close();
			 }
		}
		catch (IOException e)
		{
    		System.out.println("ERRORE. OPERAZIONE I/O - PARSING INTERROTTA .");
    		System.out.println("MESSAGGIO: " + e.getMessage());
    		System.out.println("CAUSA: " + e.getCause());
		} 
		catch (Exception e) 
		{
    		System.out.println("ERRORE GENERICO.");
    		System.out.println("MESSAGGIO: " + e.getMessage());
    		System.out.println("CAUSA: " + e.getCause());
		}
		// ---------------------- FINE PRIMA CHIAMATA -------------------------------------
		
		// ---------------------- INIZIO SECONDA CHIAMATA ---------------------------------
		try 
		{
			URLConnection openConnection2 = new URL(urlCittaTedesche).openConnection();
			openConnection2.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
			InputStream in2 = openConnection2.getInputStream();

			String line2 = "";
			try 
			{
				InputStreamReader inR2 = new InputStreamReader(in2);
				BufferedReader buf2 = new BufferedReader(inR2);

				while ((line2 = buf2.readLine()) != null) 
				{
					data2 += line2;
				}
			}
			catch (IOException e) 
			{
				System.out.println("ERRORE. OPERAZIONE I/O INTERROTTA.");
				System.out.println("MESSAGGIO: " + e.getMessage());
				System.out.println("CAUSA: " + e.getCause());
			} 
			finally 
			{
				in2.close();
			}
		} 
		catch (IOException e)
		{
			System.out.println("ERRORE. OPERAZIONE I/O - PARSING INTERROTTA .");
			System.out.println("MESSAGGIO: " + e.getMessage());
			System.out.println("CAUSA: " + e.getCause());
		}
		catch (Exception e)
		{
			System.out.println("ERRORE GENERICO.");
			System.out.println("MESSAGGIO: " + e.getMessage());
			System.out.println("CAUSA: " + e.getCause());
		}
		// ------------------------ FINE SECONDA CHIAMATA -------------------------------
		
		data = "{\"it\":"+ data + ",\"de\":"+data2+"}";
		
		JSONObject obj;
		try 
		{
			obj = (JSONObject) JSONValue.parseWithException(data);
			
			JSONObject objObjectIT = (JSONObject) obj.get("it");
			JSONObject objResultIT = (JSONObject) objObjectIT.get("result");	
			JSONArray objArrayIT = (JSONArray) objResultIT.get("places");

			JSONObject objObjectDE = (JSONObject) obj.get("de");
			JSONObject objResultDE = (JSONObject) objObjectDE.get("result");	
			JSONArray objArrayDE = (JSONArray) objResultDE.get("places");

			// Ciclo per i places italiani
			for (Object o : objArrayIT) 
			{
				if (o instanceof JSONObject) 
				{
					JSONObject o1 = (JSONObject) o;
					try 
					{
						// Places
						String ID = (String) o1.get("id");
						String Place_Type = (String) o1.get("place_type");
						String Name = (String) o1.get("name");
						String Full_Name = (String) o1.get("full_name");
						String Country_Code = (String) o1.get("country_code");
						String Country = (String) o1.get("country");
						

						PosizioneTweet objPosizone = new PosizioneTweet(ID, Place_Type, 
																		Name, Full_Name, 
																		Country_Code,Country);
						arrayCittaIT_DE.add(objPosizone);
					} 
					catch (Exception e)
					{
						System.out.println("ERRORE. OPERAZIONE INTERROTTA NEL PRELEVAGGIO DEI PARAMETRI.");
						System.out.println("MESSAGGIO: " + e.getMessage());
						System.out.println("CAUSA: " + e.getCause());

					}
				}
			}

			// Ciclo per i places tedeschi
			for (Object o : objArrayDE) 
			{
				if (o instanceof JSONObject) 
				{
					JSONObject o1 = (JSONObject) o;
					try 
					{
						// Places
						String ID = (String) o1.get("id");
						String Place_Type = (String) o1.get("place_type");
						String Name = (String) o1.get("name");
						String Full_Name = (String) o1.get("full_name");
						String Country_Code = (String) o1.get("country_code");
						String Country = (String) o1.get("country");
						

						PosizioneTweet objPosizone = new PosizioneTweet(ID, Place_Type, 
																		Name, Full_Name, 
																		Country_Code,Country);
						arrayCittaIT_DE.add(objPosizone);
					} 
					catch (Exception e)
					{
						System.out.println("ERRORE. OPERAZIONE INTERROTTA NEL PRELEVAGGIO DEI PARAMETRI.");
						System.out.println("MESSAGGIO: " + e.getMessage());
						System.out.println("CAUSA: " + e.getCause());

					}
				}
			}
			return arrayCittaIT_DE;
		} 
		catch (ParseException e) 
		{
			System.out.println("ERRORE. OPERAZIONE INTERROTTA NEL PARSING JSON.");
    		System.out.println("MESSAGGIO: " + e.getMessage());
    		System.out.println("CAUSA: " + e.getCause());
		}
		return null;
	}
	
	
	/**
	 * Metodo statico che genera in maniera casuale un numero che verra' usato
	 * per estrapolare la citta' che verra' inserita nel tweet.
	 * @param max Grandezza dell'arrayList delle citta' italiane e tedesche.
	 * @return random Ritona il numero generato casualmente.
	 */
	private static int randomCity(int max)
	{
		int random = (int) (Math.random() * (max - 0 + 1) + 0);
		return random;
	}
}
