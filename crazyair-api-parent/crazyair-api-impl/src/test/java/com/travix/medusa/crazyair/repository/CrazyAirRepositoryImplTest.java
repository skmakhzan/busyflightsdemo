package com.travix.medusa.crazyair.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.crazyair.CrazyAirApplication;
import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;
import com.travix.medusa.crazyair.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrazyAirApplication.class)
public class CrazyAirRepositoryImplTest {

	@Autowired
	private CrazyAirRepository crazyAirRepository;

	private CrazyAirRequest request;

	@Before
	public void setUp() {
		request = TestUtils.mockRequest();
	}

	@Test
	public void testFindFlights() {
		List<CrazyAirFlight> actual = crazyAirRepository.findFlights(request);
		assertThat(actual).hasSize(2);
		assertThat(actual.get(0).getDepartureAirportCode()).isEqualTo(request.getOrigin());
	}

}
