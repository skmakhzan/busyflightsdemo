package com.travix.medusa.crazyair.service;

import java.util.List;

import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;

/**
 * 
 * @author skh
 *
 */
public interface CrazyAirService {

	/**
	 * find flights
	 * 
	 * @param paramCrazyAirRequest
	 * @return List<CrazyAirFlight>
	 */
	List<CrazyAirFlight> findFlights(CrazyAirRequest crazyAirRequest);
}
