package com.amadeus.FlightSearch.dataaccess;

import java.util.List;

import com.amadeus.FlightSearch.entities.Flight;

public interface IFlightDal {

	void removeFlight(Flight flight);
	void addFlight(Flight flight);
	void updateFlight(Flight flight);
	List<Flight> listFlights();
	Flight getById(int id);
	
}