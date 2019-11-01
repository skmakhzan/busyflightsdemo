package com.travix.medusa.busyflights.service.supplier;

import java.util.concurrent.CompletableFuture;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.exception.BusyFlightsServiceException;

public interface Supplier<T> {

	/**
	 * search flights from supplier
	 * 
	 * @param request
	 * @return
	 */
	CompletableFuture<T> getFlights(BusyFlightsRequest request) throws BusyFlightsServiceException;

}
