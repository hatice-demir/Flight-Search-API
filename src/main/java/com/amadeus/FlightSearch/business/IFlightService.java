package com.amadeus.FlightSearch.business;

import java.util.List;

import com.amadeus.FlightSearch.entities.Flight;

public interface IFlightService {
	
	List<Flight> getAllFlights();
}