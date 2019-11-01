package com.travix.medusa.crazyair.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author skh
 *
 */

public class CrazyAirResponse {

	public static final String SUPPLIER_NAME = "CrazyAir";

	private List<CrazyAirFlight> flights;

	public List<CrazyAirFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<CrazyAirFlight> flights) {
		this.flights = flights;
	}

	public static class CrazyAirFlight {

		private String airline;
		private double price;
		private String cabinclass;
		private String departureAirportCode;
		private String destinationAirportCode;
		private LocalDateTime departureDate;
		private LocalDateTime arrivalDate;

		public String getAirline() {
			return airline;
		}

		public void setAirline(String airline) {
			this.airline = airline;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		public String getCabinclass() {
			return cabinclass;
		}

		public void setCabinclass(String cabinclass) {
			this.cabinclass = cabinclass;
		}

		public String getDepartureAirportCode() {
			return departureAirportCode;
		}

		public void setDepartureAirportCode(String departureAirportCode) {
			this.departureAirportCode = departureAirportCode;
		}

		public String getDestinationAirportCode() {
			return destinationAirportCode;
		}

		public void setDestinationAirportCode(String destinationAirportCode) {
			this.destinationAirportCode = destinationAirportCode;
		}

		public LocalDateTime getDepartureDate() {
			return departureDate;
		}

		public void setDepartureDate(LocalDateTime departureDate) {
			this.departureDate = departureDate;
		}

		public LocalDateTime getArrivalDate() {
			return arrivalDate;
		}

		public void setArrivalDate(LocalDateTime arrivalDate) {
			this.arrivalDate = arrivalDate;
		}

	}
}
