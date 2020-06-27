package com.springboot.virusstats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

enum Method{
	GET,POST,DELETE;
}

class VirusStatApiApplicationTests {
	
	private String buildCurl(String stats, String country) {
		StringBuffer curl = new StringBuffer("");
		try {
		InputStream reader=getClass().getClassLoader().getResourceAsStream("TestVirusStats.properties");
		Properties p = new Properties();
		p.load(reader);
		
		curl.append( "curl -X " + 
				Method.GET + 
				" --anyauth http://"+
				p.getProperty("testhost")+
				":"+p.getProperty("testport")+
				"/"+stats+"/"+country);
		}catch(Exception e) {e.printStackTrace();}
		return curl.toString();
	}
	
	private int getProcReturnValue(String command) {
		int retValue = -1;
		try {
			Process proc = Runtime.getRuntime().exec(command);
			BufferedReader in = new BufferedReader(
		            new InputStreamReader(proc.getInputStream()));
			 String line = null;
			    while((line = in.readLine()) != null) {}
			
			retValue = proc.exitValue();
			proc.destroy();
		}catch(Exception e) {e.printStackTrace();}
		return retValue;
	}
	
	@Test
	@DisplayName("Test to fetch 1 Country data")
	void oneCountryData() {
			String command = buildCurl("stats","singapore");
			assertEquals(0,getProcReturnValue(command));
	}
	
	@Test
	@DisplayName("Test to fetch all countries data")
	void allData() {
			String command = buildCurl("stats","");
			assertEquals(0,getProcReturnValue(command));
	}
	

}
