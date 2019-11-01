package com.travix.medusa.busyflights.utils;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse.BusyFlightsFlight;
import com.travix.medusa.crazyair.domain.CabinclassEnum;
import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;
import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;

/**
 * data mock for test
 * 
 * @author rimas
 *
 */
public final class TestUtils {

	private TestUtils() {
	}

	public static BusyFlightsRequest mockBusyFlightsRequest() {
		BusyFlightsRequest request = new BusyFlightsRequest();
		request = new BusyFlightsRequest();
		request.setOrigin("LDN");
		request.setDestination("AMS");
		request.setDepartureDate(LocalDate.now());
		request.setReturnDate(LocalDate.now());
		request.setNumberOfPassengers(3);
		return request;
	}

	public static List<BusyFlightsFlight> mockflights() {
		BusyFlightsRequest request = mockBusyFlightsRequest();
		List<BusyFlightsFlight> flights = new ArrayList<>();
		BusyFlightsFlight flight1 = new BusyFlightsFlight();
		flight1.setAirlineName("air java");
		flight1.setDepartureAirportCode(request.getOrigin());
		flight1.setDestinationAirportCode(request.getDestination());
		flight1.setFare(400.93);
		flight1.setDepartureDate(request.getDepartureDate().atStartOfDay());
		flight1.setArrivalDate(request.getReturnDate().atStartOfDay());
		flights.add(flight1);

		BusyFlightsFlight flight2 = new BusyFlightsFlight();
		flight2.setAirlineName("air spring");
		flight2.setDepartureAirportCode(request.getOrigin());
		flight2.setDestinationAirportCode(request.getDestination());
		flight2.setFare(600.23);
		flight2.setDepartureDate(request.getDepartureDate().atStartOfDay().plusHours(5L));
		flight2.setArrivalDate(request.getReturnDate().atStartOfDay().plusHours(4L));
		flights.add(flight2);
		return flights;
	}

	public static BusyFlightsResponse mockBusyFlightsResponse() {
		BusyFlightsResponse response = new BusyFlightsResponse();
		response.setFlights(mockflights());
		return response;
	}

	public static CrazyAirRequest mockCrazyAirRequest() {
		BusyFlightsRequest requestBusyFlight = mockBusyFlightsRequest();
		CrazyAirRequest request = new CrazyAirRequest();
		request.setOrigin(requestBusyFlight.getOrigin());
		request.setDestination(requestBusyFlight.getDestination());
		request.setPassengerCount(requestBusyFlight.getNumberOfPassengers());
		request.setDepartureDate(requestBusyFlight.getDepartureDate());
		request.setReturnDate(requestBusyFlight.getReturnDate());
		return request;
	}

	public static ToughJetRequest mockToughJetRequest() {
		BusyFlightsRequest requestBusyFlight = mockBusyFlightsRequest();
		ToughJetRequest request = new ToughJetRequest();
		request.setFrom(requestBusyFlight.getOrigin());
		request.setTo(requestBusyFlight.getDestination());
		request.setNumberOfAdults(requestBusyFlight.getNumberOfPassengers());
		request.setOutboundDate(requestBusyFlight.getDepartureDate());
		request.setInboundDate(requestBusyFlight.getReturnDate());
		return request;
	}

	public static CrazyAirResponse mockCrazyAirRespose() {
		BusyFlightsRequest request = mockBusyFlightsRequest();
		List<CrazyAirFlight> flights = new ArrayList<>();
		CrazyAirResponse.CrazyAirFlight flight1 = new CrazyAirResponse.CrazyAirFlight();
		flight1.setAirline("air java");
		flight1.setCabinclass(CabinclassEnum.ECONOMY.getName());
		flight1.setDepartureAirportCode(request.getOrigin());
		flight1.setDestinationAirportCode(request.getDestination());
		flight1.setPrice(400.932834D);
		flight1.setDepartureDate(request.getDepartureDate().atStartOfDay());
		flight1.setArrivalDate(request.getReturnDate().atStartOfDay());
		flights.add(flight1);

		CrazyAirResponse.CrazyAirFlight flight2 = new CrazyAirResponse.CrazyAirFlight();
		flight2.setAirline("air spring");
		flight2.setCabinclass(CabinclassEnum.BUSINESS.getName());
		flight2.setDepartureAirportCode(request.getOrigin());
		flight2.setDestinationAirportCode(request.getDestination());
		flight2.setPrice(600.2345D);
		flight2.setDepartureDate(request.getDepartureDate().atStartOfDay().plusHours(5L));
		flight2.setArrivalDate(request.getReturnDate().atStartOfDay().plusHours(4L));
		flights.add(flight2);

		CrazyAirResponse response = new CrazyAirResponse();
		response.setFlights(flights);
		return response;
	}

	public static ToughJetResponse mockToughJetRespose() {
		BusyFlightsRequest request = mockBusyFlightsRequest();
		List<ToughJetFlight> flights = new ArrayList<>();
		ToughJetFlight flight1 = new ToughJetFlight();
		flight1.setCarrier("air hibernate");
		flight1.setDepartureAirportName(request.getOrigin());
		flight1.setArrivalAirportName(request.getDestination());
		flight1.setBasePrice(300.94334);
		flight1.setTax(10);
		flight1.setDiscount(4);
		flight1.setOutboundDateTime(request.getDepartureDate().atStartOfDay().toInstant(ZoneOffset.UTC));
		flight1.setInboundDateTime(request.getReturnDate().atStartOfDay().toInstant(ZoneOffset.UTC));
		flights.add(flight1);

		ToughJetFlight flight2 = new ToughJetFlight();
		flight2.setCarrier("air maven");
		flight2.setDepartureAirportName(request.getOrigin());
		flight2.setArrivalAirportName(request.getDestination());
		flight2.setBasePrice(250.1234);
		flight2.setTax(13);
		flight2.setDiscount(3);
		flight2.setOutboundDateTime(request.getDepartureDate().atStartOfDay().plusHours(3).toInstant(ZoneOffset.UTC));
		flight2.setInboundDateTime(request.getReturnDate().atStartOfDay().plusHours(3).toInstant(ZoneOffset.UTC));
		flights.add(flight2);

		ToughJetResponse response = new ToughJetResponse();
		response.setFlights(flights);
		return response;
	}

}
