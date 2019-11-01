package com.travix.medusa.busyflights.service.supplier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse.BusyFlightsFlight;
import com.travix.medusa.busyflights.exception.BusyFlightsServiceException;
import com.travix.medusa.busyflights.utils.BusyFlightsUtils;
import com.travix.medusa.crazyair.domain.CrazyAirResponse;

/**
 * 
 * @author skh
 *
 */
@Service
public class CrazyAirSupplier implements Supplier<List<BusyFlightsFlight>> {

	private static final Logger LOG = LoggerFactory.getLogger(CrazyAirSupplier.class);

	private static final String CRAZYAIR_WS = "http://localhost:8081/api/crazyair";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CompletableFuture<List<BusyFlightsFlight>> getFlights(BusyFlightsRequest busyFlightsRequest)
			throws BusyFlightsServiceException {
		return CompletableFuture.supplyAsync(() -> {
			CrazyAirResponse crazyAirResponse;
			try {
				ResponseEntity<CrazyAirResponse> response = restTemplate.postForEntity(CRAZYAIR_WS,
						BusyFlightsUtils.busyFlightsRequestToCrazyAirRequest(busyFlightsRequest),
						CrazyAirResponse.class);
				crazyAirResponse = response.getBody();
			} catch (Exception e) {
				LOG.error("CrazyAir supplier problem");
				throw new BusyFlightsServiceException("CrazyAir supplier problem");
			}
			return BusyFlightsUtils.crazyAirResponseToBusyFlightsList(crazyAirResponse);
		});
	}

}
