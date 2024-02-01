package com.amadeus.FlightSearch.dataaccess;

import java.util.List;

import com.amadeus.FlightSearch.entities.Airport;

public interface IAirportDal {
	
	void removeAirport(Airport airport);
	void addAirport(Airport airport);
	void updateAirport(Airport airport);
	List<Airport> listAirports();
	Airport getById(int id);

}