package com.travix.medusa.toughjet.repository;

import java.util.List;

import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;

/**
 * 
 * @author skh
 *
 */
public interface ToughJetRepository {

	/**
	 * find flights
	 * 
	 * @param request
	 * @return List<ToughJetFlight>
	 */
	List<ToughJetFlight> findFlights(ToughJetRequest request);
}
