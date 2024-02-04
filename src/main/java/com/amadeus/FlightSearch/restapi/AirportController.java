package com.amadeus.FlightSearch.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amadeus.FlightSearch.business.IAirportService;
import com.amadeus.FlightSearch.entities.Airport;

@RestController
@RequestMapping("/api")
public class AirportController {
	
	IAirportService airportService;

	@Autowired
	AirportController(IAirportService airportService) {
		this.airportService = airportService;
	}
	
	@GetMapping("/listairports")
	public List<Airport> getAllAirports() {
		return airportService.getAllAirports();
	}
	
	@PostMapping("/addairports")
	public void addAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
	}
	
	@PostMapping("/removeairports")
	public void removeAirport(@RequestBody Airport airport) {
		airportService.addAirport(airport);
	}
	
	@PostMapping("/updateairports")
	public void updateAirport(@RequestBody Airport airport) {
		airportService.updateAirport(airport);
	}
	
	@GetMapping("/airport/{id}")
	public Airport getById(@PathVariable int id) {
		return airportService.getById(id);
	}

}
