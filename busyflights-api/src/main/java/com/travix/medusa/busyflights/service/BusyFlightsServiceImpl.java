package com.travix.medusa.busyflights.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse.BusyFlightsFlight;
import com.travix.medusa.busyflights.exception.BusyFlightsServiceException;
import com.travix.medusa.busyflights.service.supplier.Supplier;

/**
 * 
 * @author skh
 *
 */
@Service
public class BusyFlightsServiceImpl implements BusyFlightsService {

	@Autowired
	private List<Supplier<List<BusyFlightsFlight>>> suppliers;

	public void setSuppliers(List<Supplier<List<BusyFlightsFlight>>> suppliers) {
		this.suppliers = suppliers;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BusyFlightsResponse findFlights(BusyFlightsRequest request) throws BusyFlightsServiceException {
		List<BusyFlightsFlight> flights = new ArrayList<>();
		List<CompletableFuture<List<BusyFlightsFlight>>> completableFutures = suppliers.stream()
				.map(supplier -> supplier.getFlights(request)).collect(Collectors.toList());
		CompletableFuture<List<BusyFlightsFlight>>[] allFutures = completableFutures
				.toArray(new CompletableFuture[completableFutures.size()]);
		CompletableFuture.allOf(allFutures).join();
		for (CompletableFuture<List<BusyFlightsFlight>> future : allFutures) {
			try {
				flights.addAll(future.get());
			} catch (InterruptedException | ExecutionException e) {
				throw new BusyFlightsServiceException(e.getMessage());
			}
		}
		Collections.sort(flights);
		BusyFlightsResponse response = new BusyFlightsResponse();
		response.setFlights(flights);
		return response;
	}

}
