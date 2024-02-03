package com.amadeus.FlightSearch.business;

import java.util.List;

import com.amadeus.FlightSearch.entities.Airport;

public interface IAirportService {
	
	List<Airport> getAllAirports();
	void addAirport(Airport airport);
	void removeAirport(Airport airport);
	void updateAirport(Airport airport);
	Airport getById(int id);

}
