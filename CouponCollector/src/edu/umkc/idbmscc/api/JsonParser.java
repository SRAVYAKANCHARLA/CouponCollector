package edu.umkc.idbmscc.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;

import edu.umkc.idbmscc.dto.Division;
import edu.umkc.idbmscc.dto.Locations;

/**
 * 
 * @author Rajesh Kapa
 *
 */
public class JsonParser {

	public static void main(String[] args) throws Exception {

	    String json = readUrl("https://partner-api.groupon.com/division.json");

	    Gson gson = new Gson();        
	    Locations locations = gson.fromJson(json, Locations.class);

	    //System.out.println(page.title);
	    for (Division division : locations.getDivisions())
	    {
	    	System.out.println("    " + division.getName());
	        System.out.println("    " + division.getCountry());
	    }
	}
	
	
	private static String readUrl(String urlString) throws Exception {
	    BufferedReader reader = null;
	    try {
	        URL url = new URL(urlString);
	        reader = new BufferedReader(new InputStreamReader(url.openStream()));
	        StringBuffer buffer = new StringBuffer();
	        int read;
	        char[] chars = new char[1024];
	        while ((read = reader.read(chars)) != -1)
	            buffer.append(chars, 0, read); 

	        return buffer.toString();
	    } finally {
	        if (reader != null)
	            reader.close();
	    }
	}
}
