package com.amadeus.FlightSearch.restapi;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/listflights")
	public List<Flight> getAllFlights() {
		return flightService.getAllFlights();
	}
	
	@PostMapping("/addflights")
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight);
	}
	
	@PostMapping("/removeflights")
	public void removeFlight(@RequestBody Flight flight) {
		flightService.removeFlight(flight);
	}
	
	@PostMapping("/updateflights")
	public void updateFlight(@RequestBody Flight flight) {
		flightService.updateFlight(flight);
	}
	
	@GetMapping("/flight/{id}")
	public Flight getById(@PathVariable int id) {
		return flightService.getById(id);
	}

    @GetMapping("/filterFlights")
    public List<Flight> getFilterFlights(
            @RequestParam String departureCity,
            @RequestParam String arrivalCity,
            @RequestParam Timestamp departureDateTime,
            @RequestParam(required = false) Timestamp returnDateTime
    ) {
    	if(returnDateTime == null) {
    		return flightService.getOneWayFlights(departureCity, arrivalCity, departureDateTime);
    	} else {
    		return flightService.getRoundTripFlights(departureCity, arrivalCity, departureDateTime, returnDateTime);
    	}
    }
}