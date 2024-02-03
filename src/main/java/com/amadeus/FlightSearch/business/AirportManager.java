package com.amadeus.FlightSearch.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amadeus.FlightSearch.dataaccess.IAirportDal;
import com.amadeus.FlightSearch.entities.Airport;

@Service
public class AirportManager implements IAirportService{
	
	private IAirportDal airportDal;

	@Autowired
	public AirportManager(IAirportDal airportDal) {
		this.airportDal = airportDal;
	}

	@Override
	@Transactional
	public List<Airport> getAllAirports() {
		return airportDal.listAirports();
	}

	@Override
	@Transactional
	public void addAirport(Airport airport) {
		airportDal.addAirport(airport);
		
	}

	@Override
	@Transactional
	public void removeAirport(Airport airport) {
		airportDal.removeAirport(airport);
		
	}

	@Override
	@Transactional
	public void updateAirport(Airport airport) {
		airportDal.updateAirport(airport);
		
	}

	@Override
	@Transactional
	public Airport getById(int id) {
		return airportDal.getById(id);
	}

}
