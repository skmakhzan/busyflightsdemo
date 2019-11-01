package com.travix.medusa.crazyair.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse;
import com.travix.medusa.crazyair.repository.CrazyAirRepository;

/**
 * 
 * @author skh
 *
 */
@Service
public class CrazyAirServiceImpl implements CrazyAirService {

	@Autowired
	private CrazyAirRepository crazyAirRepository;

	public List<CrazyAirResponse.CrazyAirFlight> findFlights(CrazyAirRequest request) {
		return this.crazyAirRepository.findFlights(request);
	}
}
