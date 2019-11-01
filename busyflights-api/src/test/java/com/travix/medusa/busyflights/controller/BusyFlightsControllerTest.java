package com.travix.medusa.busyflights.controller;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;
import com.travix.medusa.busyflights.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */

@RunWith(SpringRunner.class)
@WebMvcTest(BusyFlightsController.class)
public class BusyFlightsControllerTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	public static final String URI = "/api/flights";

	@MockBean
	private BusyFlightsService busyFlightsService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private BusyFlightsRequest request;
	private BusyFlightsResponse response;

	@Before
	public void setUp() {
		request = TestUtils.mockBusyFlightsRequest();
		response = TestUtils.mockBusyFlightsResponse();
	}

	@Test
	public void testGetFlights() throws Exception {
		given(this.busyFlightsService.findFlights(any())).willReturn(response);
		// @formatter:off
		mockMvc.perform(post(URI)
				.contentType(APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.flights").isArray())
                .andExpect(jsonPath("$.flights", hasSize(2)));
		// @formatter:on
	}

	@Test
	public void testConstraintViolated() throws Exception {
		BusyFlightsRequest req = new BusyFlightsRequest();
		req.setNumberOfPassengers(5);
		// @formatter:off
		mockMvc.perform(post(URI)
				.contentType(APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(req)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.timestamp", is(notNullValue())))
				.andExpect(jsonPath("$.status", is(400)))
				.andExpect(jsonPath("$.errors").isArray())
				.andExpect(jsonPath("$.errors", hasSize(5)))
				.andExpect(jsonPath("$.errors", hasItem("Please provide origin")))
				.andExpect(jsonPath("$.errors", hasItem("Please provide destination")))
				.andExpect(jsonPath("$.errors", hasItem("Please provide departureDate")))
				.andExpect(jsonPath("$.errors", hasItem("Please provide returnDate")))
				.andExpect(jsonPath("$.errors", hasItem("Max of passengers 4")));
		// @formatter:on

	}

}
