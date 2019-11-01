package com.travix.medusa.crazyair.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author skh
 *
 */

public class CrazyAirRequest {

	private static final int IATA_CODE_LENGTH = 3;

	@NotNull(message = "Please provide origin")
	@Size(min = IATA_CODE_LENGTH, max = IATA_CODE_LENGTH, message = "origin must be between 3 and 3")
	private String origin;

	@NotNull(message = "Please provide destination")
	@Size(min = IATA_CODE_LENGTH, max = IATA_CODE_LENGTH, message = "destination must be between 3 and 3")
	private String destination;

	@NotNull(message = "Please provide departureDate")
	private LocalDate departureDate;

	@NotNull(message = "Please provide returnDate")
	private LocalDate returnDate;

	private int passengerCount;

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

	public int getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(int passengerCount) {
		this.passengerCount = passengerCount;
	}

}
