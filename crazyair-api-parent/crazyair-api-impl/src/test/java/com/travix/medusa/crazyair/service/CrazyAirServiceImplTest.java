package com.travix.medusa.crazyair.service;

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

import com.travix.medusa.crazyair.CrazyAirApplication;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;
import com.travix.medusa.crazyair.repository.CrazyAirRepository;
import com.travix.medusa.crazyair.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CrazyAirApplication.class)
public class CrazyAirServiceImplTest {

	@MockBean
	private CrazyAirRepository crazyAirRepository;

	@Autowired
	private CrazyAirService crazyAirService;

	@Test
	public void testFindFlights() {
		given(this.crazyAirRepository.findFlights(any())).willReturn(TestUtils.mockFlights());
		List<CrazyAirFlight> actual = crazyAirService.findFlights(any());
		assertThat(actual).hasSize(2);
		assertThat(actual.get(0).getAirline()).isEqualTo("air java");
	}
}
