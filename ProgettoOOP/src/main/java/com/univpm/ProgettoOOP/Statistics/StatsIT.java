package com.univpm.ProgettoOOP.Statistics;

import org.json.simple.JSONArray;

public class StatsIT implements Stats<Object>
{

	/*
	 * Riceviamo la chiamata dal downloadtweet che ci passerà il campo prelevato da postman (IT o DE)
	 * dopo di ché, ottenuto  la lingua e ottenuto l'arrayList filtrato (da downloadtweet)
	 * li passo a StatsUtils. Il risultato filtarto per lingua ritornerà a downloadTweet
	 * 
	 */
	private JSONArray arrayTweet;
	private StatsUtils utils;
	
	public StatsIT(JSONArray array)
	{
		super();
		this.arrayTweet = array;
		this.utils = new StatsUtils();
	}
	
	public JSONArray getTweet()
	{
		return arrayTweet;
	}
	
	/*public JSONArray setTweet(JSONArray tweet)
	{
		this.arrayTweet = tweet;
	}*/
	
	@Override
	public JSONArray StatsTweet(JSONArray arrayTweet, Object lingua) 
	{
		return (JSONArray) utils.getValue(this.getTweet(), lingua);
	}
}
