package com.travix.medusa.busyflights.domain;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author skh
 *
 */
public class BusyFlightsRequest {

	private static final int IATA_CODE_LENGTH = 3;

	@NotEmpty(message = "Please provide origin")
	@Size(min = IATA_CODE_LENGTH, max = IATA_CODE_LENGTH, message = "origin must be between 3 and 3")
	private String origin;

	@NotEmpty(message = "Please provide destination")
	@Size(min = IATA_CODE_LENGTH, max = IATA_CODE_LENGTH, message = "destination must be between 3 and 3")
	private String destination;

	@NotNull(message = "Please provide departureDate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate departureDate;

	@NotNull(message = "Please provide returnDate")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate returnDate;

	@Max(value = 4, message = "Max of passengers 4")
	private int numberOfPassengers;

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

}
