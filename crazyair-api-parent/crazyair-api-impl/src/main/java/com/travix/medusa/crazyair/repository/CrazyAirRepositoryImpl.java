package com.travix.medusa.crazyair.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.travix.medusa.crazyair.domain.CabinclassEnum;
import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;

/**
 * 
 * @author skh
 *
 */
@Repository
public class CrazyAirRepositoryImpl implements CrazyAirRepository {

	public List<CrazyAirFlight> findFlights(CrazyAirRequest request) {
		List<CrazyAirFlight> flights = new ArrayList<CrazyAirFlight>();

		CrazyAirFlight flight1 = new CrazyAirFlight();
		flight1.setAirline("air java");
		flight1.setCabinclass(CabinclassEnum.ECONOMY.getName());
		flight1.setDepartureAirportCode(request.getOrigin());
		flight1.setDestinationAirportCode(request.getDestination());
		flight1.setPrice(400.932834D);
		flight1.setDepartureDate(request.getDepartureDate().atStartOfDay());
		flight1.setArrivalDate(request.getReturnDate().atStartOfDay());
		flights.add(flight1);

		CrazyAirFlight flight2 = new CrazyAirFlight();
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