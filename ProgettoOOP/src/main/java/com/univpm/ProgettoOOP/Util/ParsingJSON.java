package com.univpm.ProgettoOOP.Util;

import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.univpm.ProgettoOOP.Model.Tweet;

/**
 * Classe per il parsing da oggetto java in oggetto JSON.
 * @author Ricciardi Nicola
 * @author Rendina Michele Pio
 */
public class ParsingJSON 
{
	public static String ParsingToJSON(ArrayList<Tweet> array)
	{
		Gson out = new GsonBuilder().setPrettyPrinting().create();
		String outFinal = out.toJson(array);
		return outFinal;
	}
}
