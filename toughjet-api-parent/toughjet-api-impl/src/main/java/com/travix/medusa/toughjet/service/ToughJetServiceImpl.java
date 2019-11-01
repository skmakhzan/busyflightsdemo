package com.travix.medusa.toughjet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;
import com.travix.medusa.toughjet.repository.ToughJetRepository;

/**
 * 
 * @author skh
 *
 */
@Service
public class ToughJetServiceImpl implements ToughJetService {

	@Autowired
	private ToughJetRepository toughJetRepository;

	@Override
	public List<ToughJetFlight> findFlights(ToughJetRequest request) {
		return toughJetRepository.findFlights(request);
	}

}
