package com.amadeus.FlightSearch.business;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amadeus.FlightSearch.dataaccess.IAirportDal;
import com.amadeus.FlightSearch.dataaccess.IFlightDal;
import com.amadeus.FlightSearch.entities.Flight;

@Service
public class FlightManager implements IFlightService{
	
	private IFlightDal flightDal;
	private IAirportDal airportDal;
	
	@Autowired
	public FlightManager(IFlightDal flightDal, IAirportDal airportDal) {
		this.flightDal = flightDal;
		this.airportDal = airportDal;
	}

	@Override
	@Transactional
	public List<Flight> getAllFlights() {
		return flightDal.listFlights();
	}
	
}