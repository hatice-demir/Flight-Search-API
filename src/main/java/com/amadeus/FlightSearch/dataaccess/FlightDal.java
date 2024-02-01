package com.amadeus.FlightSearch.dataaccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amadeus.FlightSearch.entities.Flight;

import jakarta.persistence.EntityManager;

@Repository
public class FlightDal implements IFlightDal{
	
	private EntityManager entityManager;
	
	@Autowired
	public FlightDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void removeFlight(Flight flight) {
		Session session = entityManager.unwrap(Session.class);
		Flight deleteToFlight = session.get(Flight.class, flight.getId());
		session.remove(deleteToFlight);
		
	}

	@Override
	@Transactional
	public void addAirport(Flight flight) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(flight);
		
	}

	@Override
	@Transactional
	public void updateAirport(Flight flight) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(flight);
		
	}

	@Override
	@Transactional
	public List<Flight> listFlights() {
		Session session = entityManager.unwrap(Session.class);
		List<Flight> flights = session.createQuery("from Flight", Flight.class).getResultList();
		return flights;
	}
	
	@Override
	@Transactional
	public Flight getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Flight flight = session.get(Flight.class, id);
		return flight;
	}

}