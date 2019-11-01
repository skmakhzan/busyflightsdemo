package com.travix.medusa.toughjet.domain;

import java.time.Instant;
import java.util.List;

/**
 * 
 * @author skh
 *
 */
public class ToughJetResponse {

	public static final String SUPPLIER_NAME = "ToughJet";

	private List<ToughJetFlight> flights;

	public List<ToughJetFlight> getFlights() {
		return flights;
	}

	public void setFlights(List<ToughJetFlight> flights) {
		this.flights = flights;
	}

	public static class ToughJetFlight {

		private String carrier;
		private double basePrice;
		private double tax;
		private double discount;
		private String departureAirportName;
		private String arrivalAirportName;
		private Instant outboundDateTime;
		private Instant inboundDateTime;

		public String getCarrier() {
			return carrier;
		}

		public void setCarrier(String carrier) {
			this.carrier = carrier;
		}

		public double getBasePrice() {
			return basePrice;
		}

		public void setBasePrice(double basePrice) {
			this.basePrice = basePrice;
		}

		public double getTax() {
			return tax;
		}

		public void setTax(double tax) {
			this.tax = tax;
		}

		public double getDiscount() {
			return discount;
		}

		public void setDiscount(double discount) {
			this.discount = discount;
		}

		public String getDepartureAirportName() {
			return departureAirportName;
		}

		public void setDepartureAirportName(String departureAirportName) {
			this.departureAirportName = departureAirportName;
		}

		public String getArrivalAirportName() {
			return arrivalAirportName;
		}

		public void setArrivalAirportName(String arrivalAirportName) {
			this.arrivalAirportName = arrivalAirportName;
		}

		public Instant getOutboundDateTime() {
			return outboundDateTime;
		}

		public void setOutboundDateTime(Instant outboundDateTime) {
			this.outboundDateTime = outboundDateTime;
		}

		public Instant getInboundDateTime() {
			return inboundDateTime;
		}

		public void setInboundDateTime(Instant inboundDateTime) {
			this.inboundDateTime = inboundDateTime;
		}

	}
}
