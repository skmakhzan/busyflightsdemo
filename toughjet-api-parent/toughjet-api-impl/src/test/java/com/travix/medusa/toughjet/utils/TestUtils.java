package com.travix.medusa.toughjet.utils;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;

/**
 * 
 * @author skh
 *
 */
public final class TestUtils {

	private TestUtils() {
	}

	public static ToughJetRequest mockRequest() {
		ToughJetRequest request = new ToughJetRequest();
		request = new ToughJetRequest();
		request.setFrom("LDN");
		request.setTo("AMS");
		request.setOutboundDate(LocalDate.now());
		request.setInboundDate(LocalDate.now());
		request.setNumberOfAdults(3);
		return request;
	}

	public static List<ToughJetFlight> mockFlights() {
		ToughJetRequest request = mockRequest();
		List<ToughJetFlight> flights = new ArrayList<>();
		ToughJetFlight flight1 = new ToughJetFlight();
		flight1.setCarrier("air hibernate");
		flight1.setDepartureAirportName(request.getFrom());
		flight1.setArrivalAirportName(request.getTo());
		flight1.setBasePrice(300.94334);
		flight1.setTax(10);
		flight1.setDiscount(4);
		flight1.setOutboundDateTime(request.getOutboundDate().atStartOfDay().toInstant(ZoneOffset.UTC));
		flight1.setInboundDateTime(request.getInboundDate().atStartOfDay().toInstant(ZoneOffset.UTC));
		flights.add(flight1);

		ToughJetFlight flight2 = new ToughJetFlight();
		flight2.setCarrier("air maven");
		flight2.setDepartureAirportName(request.getFrom());
		flight2.setArrivalAirportName(request.getTo());
		flight2.setBasePrice(250.1234);
		flight2.setTax(13);
		flight2.setDiscount(3);
		flight2.setOutboundDateTime(request.getOutboundDate().atStartOfDay().plusHours(3).toInstant(ZoneOffset.UTC));
		flight2.setInboundDateTime(request.getInboundDate().atStartOfDay().plusHours(3).toInstant(ZoneOffset.UTC));
		flights.add(flight2);

		return flights;
	}
}
