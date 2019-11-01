package com.travix.medusa.toughjet.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.travix.medusa.toughjet.ToughJetApplication;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;
import com.travix.medusa.toughjet.repository.ToughJetRepository;
import com.travix.medusa.toughjet.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ToughJetApplication.class)
public class ToughJetServiceImplTest {

	@MockBean
	private ToughJetRepository toughJetRepository;

	@Autowired
	private ToughJetService toughJetService;

	@Test
	public void testFindFlights() {
		given(this.toughJetRepository.findFlights(any())).willReturn(TestUtils.mockFlights());
		List<ToughJetFlight> actual = toughJetService.findFlights(any());
		assertThat(actual).hasSize(2);
		assertThat(actual.get(0).getCarrier()).isEqualTo("air hibernate");
	}
}
