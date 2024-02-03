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

	@Override
	@Transactional
	public void addFlight(Flight flight) {
		flightDal.addFlight(flight);		
	}

	@Override
	@Transactional
	public void removeFlight(Flight flight) {
		flightDal.removeFlight(flight);
		
	}

	@Override
	@Transactional
	public void updateFlight(Flight flight) {
		flightDal.updateFlight(flight);
		
	}

	@Override
	@Transactional
	public Flight getById(int id) {
		return flightDal.getById(id);
	}

	@Override
	@Transactional
	public List<Flight> getOneWayFlights(String departureCity, String arrivalCity, Timestamp departureDateTime) {
        List<Flight> oneWayFlights = new ArrayList<>();
        List<Flight> listFlights = flightDal.listFlights();
        for (Flight flight : listFlights) {
            if (airportDal.getById(flight.getDepartureAirportId()).getCity().equals(departureCity)
                    && airportDal.getById(flight.getArrivalAirportId()).getCity().equals(arrivalCity)
                    && flight.getDepartureDateTime().equals(departureDateTime)) {
                oneWayFlights.add(flight);
            }
        }
        return oneWayFlights;
    }

	@Override
	@Transactional
	public List<Flight> getRoundTripFlights(String departureCity, String arrivalCity, Timestamp departureDateTime, Timestamp returnDateTime) {
        List<Flight> roundTripFlights = new ArrayList<>();
        List<Flight> listFlights = flightDal.listFlights();
        for (Flight flight : listFlights) {
        	if (airportDal.getById(flight.getDepartureAirportId()).getCity().equals(departureCity)
                    && airportDal.getById(flight.getArrivalAirportId()).getCity().equals(arrivalCity)
                    && flight.getDepartureDateTime().equals(departureDateTime)
                    && flight.getReturnDateTime().equals(returnDateTime)) {
                roundTripFlights.add(flight);
            }
        }
        return roundTripFlights;
    }
	
}