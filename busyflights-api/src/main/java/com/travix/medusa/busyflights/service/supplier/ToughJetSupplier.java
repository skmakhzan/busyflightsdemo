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
import com.travix.medusa.toughjet.domain.ToughJetResponse;

/**
 * 
 * @author skh
 *
 */
@Service
public class ToughJetSupplier implements Supplier<List<BusyFlightsFlight>> {

	private static final Logger LOG = LoggerFactory.getLogger(ToughJetSupplier.class);

	private static final String TOUGHJET_WS = "http://localhost:8082/api/toughjet";

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CompletableFuture<List<BusyFlightsFlight>> getFlights(BusyFlightsRequest busyFlightsRequest)
			throws BusyFlightsServiceException {
		return CompletableFuture.supplyAsync(() -> {
			ToughJetResponse touchJetResponse;
			try {
				ResponseEntity<ToughJetResponse> response = restTemplate.postForEntity(TOUGHJET_WS,
						BusyFlightsUtils.busyFlightsRequestToToughJetRequest(busyFlightsRequest),
						ToughJetResponse.class);
				touchJetResponse = response.getBody();
			} catch (Exception e) {
				LOG.error("ToughJet supplier problem");
				throw new BusyFlightsServiceException("ToughJet supplier problem");
			}
			return BusyFlightsUtils.toughJetResponseToBusyFlightsList(touchJetResponse);
		});
	}

}
