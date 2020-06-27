package com.virusstats.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virusstats.models.*;
import com.virusstats.services.*;

@RestController
public class VirusStatController {

	@Autowired
	private VirusStatService virusStatService;
	
	@RequestMapping("/stats")
	public List<LocationStats> getAllStats() {
			return virusStatService.getAllStats();
	}

	@RequestMapping("/stats/{countryname}")
	public List<LocationStats> getStatsPerCountry(@PathVariable("countryname") String countryname) {
			return virusStatService.getStatsPerCountry(countryname);
	}
	
}
