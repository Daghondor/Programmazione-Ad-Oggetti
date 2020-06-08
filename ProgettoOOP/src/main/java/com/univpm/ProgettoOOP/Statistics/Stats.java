package com.univpm.ProgettoOOP.Statistics;

import java.util.Collection;

import org.json.simple.JSONArray;

public interface Stats<T>
{
	abstract JSONArray StatsTweet(JSONArray arrayTweet, T lingua);
}
