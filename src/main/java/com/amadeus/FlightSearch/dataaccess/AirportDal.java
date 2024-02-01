package com.amadeus.FlightSearch.dataaccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.amadeus.FlightSearch.entities.Airport;

import jakarta.persistence.EntityManager;

@Repository
public class AirportDal implements IAirportDal{
	
	private EntityManager entityManager;
	
	@Autowired
	public AirportDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void removeAirport(Airport airport) {
		Session session = entityManager.unwrap(Session.class);
		Airport deleteToAirport = session.get(Airport.class, airport.getId());
		session.remove(deleteToAirport);
	}

	@Override
	@Transactional
	public void addAirport(Airport airport) {
		Session session = entityManager.unwrap(Session.class);
		session.persist(airport);		
	}

	@Override
	@Transactional
	public void updateAirport(Airport airport) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(airport);
	}

	@Override
	@Transactional
	public List<Airport> listAirports() {
		Session session = entityManager.unwrap(Session.class);
		List<Airport> airports = session.createQuery("from Airport", Airport.class).getResultList();
		return airports;
	}

	@Override
	@Transactional
	public Airport getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Airport airport = session.get(Airport.class, id);
		return airport;
	}

}