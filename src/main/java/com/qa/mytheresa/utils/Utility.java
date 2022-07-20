package com.qa.mytheresa.utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Utility {
	
	HttpURLConnection huc = null;
	int respCode = 200;

	
	
	public int getResponse(String url) throws MalformedURLException, IOException {
		 
		huc = (HttpURLConnection) (new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
		huc.connect();
		respCode = huc.getResponseCode();
		return respCode;
	}

}
