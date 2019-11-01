package com.travix.medusa.crazyair.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.crazyair.domain.CabinclassEnum;
import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;

/**
 * data mock for tets
 * 
 * @author skh
 *
 */
public final class TestUtils {

	private TestUtils() {
	}

	public static CrazyAirRequest mockRequest() {
		CrazyAirRequest request = new CrazyAirRequest();
		request = new CrazyAirRequest();
		request.setOrigin("LDN");
		request.setDestination("AMS");
		request.setDepartureDate(LocalDate.now());
		request.setReturnDate(LocalDate.now());
		request.setPassengerCount(3);
		return request;
	}

	public static List<CrazyAirFlight> mockFlights() {
		CrazyAirRequest request = mockRequest();
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

		return flights;
	}
}
