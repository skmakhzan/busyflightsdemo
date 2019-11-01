package com.travix.medusa.toughjet.repository;

import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;

@Repository
public class ToughJetRepositoryImpl implements ToughJetRepository {

	@Override
	public List<ToughJetFlight> findFlights(ToughJetRequest request) {
		// mock result
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
