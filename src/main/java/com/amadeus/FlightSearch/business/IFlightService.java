package com.amadeus.FlightSearch.business;

import java.sql.Timestamp;
import java.util.List;

import com.amadeus.FlightSearch.entities.Flight;

public interface IFlightService {
	
	List<Flight> getAllFlights();
	void addFlight(Flight flight);
	void removeFlight(Flight flight);
	void updateFlight(Flight flight);
	Flight getById(int id);
	List<Flight> getOneWayFlights(String departureCity, String arrivalCity, Timestamp departureDateTime);
	List<Flight> getRoundTripFlights(String departureCity, String arrivalCity, Timestamp departureDateTime, Timestamp returnDateTime);
	
}