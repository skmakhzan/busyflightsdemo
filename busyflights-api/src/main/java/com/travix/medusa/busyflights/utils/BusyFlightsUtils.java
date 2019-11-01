package com.travix.medusa.busyflights.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse.BusyFlightsFlight;
import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;
import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;

/**
 * busyflights utils
 * 
 * @author skh
 *
 */
public final class BusyFlightsUtils {

	private BusyFlightsUtils() {
		throw new UnsupportedOperationException();
	}

	/**
	 * map BusyFlightsRequest to CrazyAirRequest
	 * 
	 * @param busyFlightsRequest
	 * @return CrazyAirRequest
	 */
	public static CrazyAirRequest busyFlightsRequestToCrazyAirRequest(BusyFlightsRequest busyFlightsRequest) {
		CrazyAirRequest crazyAirRequest = new CrazyAirRequest();
		crazyAirRequest.setOrigin(busyFlightsRequest.getOrigin());
		crazyAirRequest.setDestination(busyFlightsRequest.getDestination());
		crazyAirRequest.setPassengerCount(busyFlightsRequest.getNumberOfPassengers());
		crazyAirRequest.setDepartureDate(busyFlightsRequest.getDepartureDate());
		crazyAirRequest.setReturnDate(busyFlightsRequest.getReturnDate());
		return crazyAirRequest;
	}

	/**
	 * map BusyFlightsRequest to ToughJetRequest
	 * 
	 * @param busyFlightsRequest
	 * @return ToughJetRequest
	 */
	public static ToughJetRequest busyFlightsRequestToToughJetRequest(BusyFlightsRequest busyFlightsRequest) {
		ToughJetRequest toughJetRequest = new ToughJetRequest();
		toughJetRequest.setFrom(busyFlightsRequest.getOrigin());
		toughJetRequest.setTo(busyFlightsRequest.getDestination());
		toughJetRequest.setNumberOfAdults(busyFlightsRequest.getNumberOfPassengers());
		toughJetRequest.setOutboundDate(busyFlightsRequest.getDepartureDate());
		toughJetRequest.setInboundDate(busyFlightsRequest.getReturnDate());
		return toughJetRequest;
	}

	/**
	 * map CrazyAirFlight to BusyFlightsFlight
	 * 
	 * @param crazyAirFlight
	 * @param request
	 * @return BusyFlightsFlight
	 */
	public static BusyFlightsFlight crazyAirFlightToBusyFlight(CrazyAirFlight crazyAirFlight) {
		BusyFlightsFlight bff = new BusyFlightsFlight();
		bff.setAirlineName(crazyAirFlight.getAirline());
		bff.setDepartureAirportCode(crazyAirFlight.getDepartureAirportCode());
		bff.setDestinationAirportCode(crazyAirFlight.getDestinationAirportCode());
		bff.setDepartureDate(crazyAirFlight.getDepartureDate());
		bff.setArrivalDate(crazyAirFlight.getArrivalDate());
		bff.setFare(priceCrazyAir(crazyAirFlight.getPrice()));
		return bff;
	}

	/**
	 * map ToughJetFlight to BusyFlightsFlight
	 * 
	 * @param toughJetFlight
	 * @return BusyFlightsFlight
	 */
	public static BusyFlightsFlight toughJetFlightToBusyFlight(ToughJetFlight toughJetFlight) {
		BusyFlightsFlight bff = new BusyFlightsFlight();
		bff.setAirlineName(toughJetFlight.getCarrier());
		bff.setDepartureAirportCode(toughJetFlight.getDepartureAirportName());
		bff.setDestinationAirportCode(toughJetFlight.getArrivalAirportName());
		bff.setDepartureDate(LocalDateTime.ofInstant(toughJetFlight.getOutboundDateTime(), ZoneOffset.UTC));
		bff.setArrivalDate(LocalDateTime.ofInstant(toughJetFlight.getInboundDateTime(), ZoneOffset.UTC));
		bff.setFare(priceToughJet(toughJetFlight));
		return bff;
	}

	/**
	 * map CrazyAirResponse to BusyFlightsFlightList
	 * 
	 * @param crazyAirResponse
	 * @return BusyFlightsFlight
	 */
	public static List<BusyFlightsFlight> crazyAirResponseToBusyFlightsList(CrazyAirResponse crazyAirResponse) {
		List<BusyFlightsFlight> flights = new ArrayList<>();
		if (crazyAirResponse == null || crazyAirResponse.getFlights() == null) {
			return flights;
		}
		for (CrazyAirFlight crazyAirFlight : crazyAirResponse.getFlights()) {
			BusyFlightsFlight flight = crazyAirFlightToBusyFlight(crazyAirFlight);
			flight.setSupplier(CrazyAirResponse.SUPPLIER_NAME);
			flights.add(flight);
		}
		return flights;
	}

	/**
	 * map ToughJetResponse to BusyFlightsFlightList
	 * 
	 * @param toughJetResponse
	 * @return BusyFlightsFlight
	 */
	public static List<BusyFlightsFlight> toughJetResponseToBusyFlightsList(ToughJetResponse toughJetResponse) {
		List<BusyFlightsFlight> flights = new ArrayList<>();
		if (toughJetResponse == null || toughJetResponse.getFlights() == null) {
			return flights;
		}
		for (ToughJetFlight toughJetFlight : toughJetResponse.getFlights()) {
			BusyFlightsFlight flight = toughJetFlightToBusyFlight(toughJetFlight);
			flight.setSupplier(ToughJetResponse.SUPPLIER_NAME);
			flights.add(flight);
		}
		return flights;
	}

	/**
	 * format price crazyair
	 * 
	 * @param price
	 * @return
	 */
	public static double priceCrazyAir(Double price) {
		return BigDecimal.valueOf(price).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	}

	/**
	 * calculate price toughjet
	 * 
	 * @param flight
	 * @return
	 */
	public static double priceToughJet(ToughJetFlight flight) {
		BigDecimal basePrice = BigDecimal.valueOf(flight.getBasePrice());
		BigDecimal discount = BigDecimal.valueOf(flight.getDiscount());
		BigDecimal tax = BigDecimal.valueOf(flight.getTax());
		BigDecimal discountAmount = basePrice.multiply(discount).divide(BigDecimal.valueOf(100));
		BigDecimal discounedPrice = basePrice.subtract(discountAmount);
		BigDecimal total = discounedPrice.add(tax);
		return total.setScale(2, RoundingMode.HALF_EVEN).doubleValue();
	}

}
