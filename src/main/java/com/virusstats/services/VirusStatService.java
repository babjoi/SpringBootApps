package com.virusstats.services;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.virusstats.models.LocationStats;

@Service
public class VirusStatService {

	private static String VIRUS_STAT_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
	private Iterable<CSVRecord> records;
	private List<LocationStats> stats ;
	
	private void fetchFromURL(){
		try {
			URL url = new URL(VIRUS_STAT_URL);
			Reader in = new BufferedReader(new InputStreamReader(url.openStream()));
			records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
		}catch(Exception e) {e.printStackTrace();}
	}

	private void generateList(CSVRecord record) {
	    stats.add(
	    		new LocationStats(record.get("Province/State"),
	    						  record.get("Country/Region"),
	    						  Integer.parseInt(record.get(record.size() - 1))));
	}

	public List<LocationStats> getAllStats() {
		fetchFromURL();
		stats = new ArrayList<>();
		for (CSVRecord record : records)
			generateList(record);
		return stats;
	}
	
	public List<LocationStats> getStatsPerCountry(String countryname){
		fetchFromURL();
		stats = new ArrayList<>();
		for (CSVRecord record : records) {
			if(record.get(1).equalsIgnoreCase(countryname))
				generateList(record);
		}
		return stats;
	}


}
