package com.travix.medusa.toughjet.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.toughjet.ToughJetApplication;
import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;
import com.travix.medusa.toughjet.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToughJetApplication.class)
public class ToughJetRepositoryImplTest {

	@Autowired
	private ToughJetRepository toughJetRepository;

	private ToughJetRequest request;

	@Before
	public void setUp() {
		request = TestUtils.mockRequest();
	}

	@Test
	public void testFindFlights() {
		List<ToughJetFlight> actual = toughJetRepository.findFlights(request);
		assertThat(actual).hasSize(2);
		assertThat(actual.get(0).getDepartureAirportName()).isEqualTo(request.getFrom());
	}

}
