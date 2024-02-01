package com.amadeus.FlightSearch.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.FlightSearch.business.IFlightService;
import com.amadeus.FlightSearch.entities.Flight;

@RestController
@RequestMapping("/api")
public class FlightController {
	
	IFlightService flightService;

	@Autowired
	public FlightController(IFlightService flightService) {
		this.flightService = flightService;
	}
	
	@RequestMapping("/list")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
}