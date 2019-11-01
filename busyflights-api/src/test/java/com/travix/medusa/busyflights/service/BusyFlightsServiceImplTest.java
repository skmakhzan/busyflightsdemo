package com.travix.medusa.busyflights.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.travix.medusa.busyflights.BusyFlightsApplication;
import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse.BusyFlightsFlight;
import com.travix.medusa.busyflights.service.supplier.Supplier;
import com.travix.medusa.busyflights.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = BusyFlightsApplication.class)
public class BusyFlightsServiceImplTest {

	private List<Supplier<List<BusyFlightsFlight>>> suppliers;

	@Mock
	private Supplier<List<BusyFlightsFlight>> supplierA;
	@Mock
	private Supplier<List<BusyFlightsFlight>> supplierB;

	@InjectMocks
	private BusyFlightsServiceImpl busyFlightsService = new BusyFlightsServiceImpl();

	@Before
	public void setUp() {
		suppliers = Arrays.asList(supplierA, supplierB);
		busyFlightsService.setSuppliers(suppliers);
	}

	@Test
	public void testFindFlights() {
		List<BusyFlightsFlight> flights = TestUtils.mockflights();
		CompletableFuture<List<BusyFlightsFlight>> futureA = CompletableFuture.completedFuture(flights);
		when(supplierA.getFlights(any())).thenReturn(futureA);
		CompletableFuture<List<BusyFlightsFlight>> futureB = CompletableFuture.completedFuture(flights);
		when(supplierB.getFlights(any())).thenReturn(futureB);

		BusyFlightsRequest busyFlightRequest = TestUtils.mockBusyFlightsRequest();
		BusyFlightsResponse actual = busyFlightsService.findFlights(busyFlightRequest);

		assertThat(actual).isNotNull();
		assertThat(actual.getFlights()).hasSize(4);
	}
}
