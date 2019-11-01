package com.travix.medusa.busyflights.domain;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 * @author skh
 *
 */
public class BusyFlightsResponse {

	private List<BusyFlightsFlight> flights;

	public List<BusyFlightsFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<BusyFlightsFlight> flights) {
		this.flights = flights;
	}

	public static class BusyFlightsFlight implements Comparable<BusyFlightsFlight> {

		private String airlineName;
		private String supplier;
		private Double fare;
		private String departureAirportCode;
		private String destinationAirportCode;
		private LocalDateTime departureDate;
		private LocalDateTime arrivalDate;

		public String getAirlineName() {
			return airlineName;
		}

		public void setAirlineName(String airlineName) {
			this.airlineName = airlineName;
		}

		public String getSupplier() {
			return supplier;
		}

		public void setSupplier(String supplier) {
			this.supplier = supplier;
		}

		public Double getFare() {
			return fare;
		}

		public void setFare(Double fare) {
			this.fare = Math.round(fare * 100.0) / 100.0;
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

		@Override
		public int compareTo(BusyFlightsFlight o) {
			return (int) (this.fare - o.fare);
		}
	}
}
