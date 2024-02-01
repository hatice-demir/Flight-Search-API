package com.amadeus.FlightSearch.scheduledbackgroundjob;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.amadeus.FlightSearch.dataaccess.IFlightDal;
import com.amadeus.FlightSearch.entities.Flight;

@Component
public class FlightDataJob {
	
	private IFlightDal flightDal;
	
	@Autowired
	public FlightDataJob(IFlightDal flightDal) {
		this.flightDal = flightDal;
	}

	@Scheduled(cron = "0 0 21 * * ?")
    public void fetchDataAndSaveToDatabase() {
		try {
	        saveToDatabase(mockApiCall());
	        System.out.println("Scheduled background job worked.");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());;
	    }
    }
	
	private void saveToDatabase(List<Flight> newData) {
		for (Flight flight : newData) {
			flightDal.addFlight(flight);
		}
    }
	
	private List<Flight> mockApiCall() {
		List<Flight> newData = new ArrayList<Flight>();
		Flight flight1 = new Flight(6, 9, Timestamp.valueOf("2024-02-04 14:15:00"), Timestamp.valueOf("2024-02-07 20:45:00"), new BigDecimal("500.00"));
		newData.add(flight1);
		return newData;
    }

}