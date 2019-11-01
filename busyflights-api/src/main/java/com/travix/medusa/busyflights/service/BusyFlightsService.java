package com.travix.medusa.busyflights.service;

import java.util.concurrent.ExecutionException;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.exception.BusyFlightsServiceException;

/**
 * 
 * @author skh
 *
 */
public interface BusyFlightsService {

	/**
	 * search flights from suppliers
	 * 
	 * @param request
	 * @return
	 * @throws BusyFlightsServiceException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	BusyFlightsResponse findFlights(BusyFlightsRequest request) throws BusyFlightsServiceException;

}