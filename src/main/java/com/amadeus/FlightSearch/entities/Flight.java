package com.amadeus.FlightSearch.entities;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="flights")
public class Flight {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="DepartureAirportID")
	private int departureAirportId;
	
	@Column(name="ArrivalAirportID")
	private int arrivalAirportId;
	
	@Column(name="DepartureDateTime")
	private Timestamp departureDateTime;
	
	@Column(name="ReturnDateTime")
	private Timestamp returnDateTime;
	
	@Column(name="Price")
	private BigDecimal price;
	
	public Flight() {}
	
	public Flight(int id, int departureAirportId, int arrivalAirportId, Timestamp departureDateTime, BigDecimal price) {
		this.id = id;
		this.departureAirportId = departureAirportId;
		this.arrivalAirportId = arrivalAirportId;
		this.departureDateTime = departureDateTime;
		this.price = price;
	}
	
	public Flight(int id, int departureAirportId, int arrivalAirportId, Timestamp departureDateTime,
			Timestamp returnDateTime, BigDecimal price) {
		this.id = id;
		this.departureAirportId = departureAirportId;
		this.arrivalAirportId = arrivalAirportId;
		this.departureDateTime = departureDateTime;
		this.returnDateTime = returnDateTime;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDepartureAirportId() {
		return departureAirportId;
	}

	public void setDepartureAirportId(int departureAirportId) {
		this.departureAirportId = departureAirportId;
	}

	public int getArrivalAirportId() {
		return arrivalAirportId;
	}

	public void setArrivalAirportId(int arrivalAirportId) {
		this.arrivalAirportId = arrivalAirportId;
	}

	public Timestamp getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Timestamp departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public Timestamp getReturnDateTime() {
		return returnDateTime;
	}

	public void setReturnDateTime(Timestamp returnDateTime) {
		this.returnDateTime = returnDateTime;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}