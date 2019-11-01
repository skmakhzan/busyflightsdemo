package com.travix.medusa.crazyair.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse.CrazyAirFlight;
import com.travix.medusa.crazyair.service.CrazyAirService;
import com.travix.medusa.crazyair.utils.TestUtils;

/**
 * 
 * @author skh
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CrazyAirController.class)
public class CrazyAirControllerTest {

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	public static final String URI = "/api/crazyair";

	@MockBean
	private CrazyAirService crazyAirService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private CrazyAirRequest request;
	private List<CrazyAirFlight> flights = new ArrayList<>();

	@Before
	public void setUp() {
		request = TestUtils.mockRequest();
		flights = TestUtils.mockFlights();
	}

	@Test
	public void getFlights() throws Exception {
		given(this.crazyAirService.findFlights(any())).willReturn(flights);
		// @formatter:off
		mockMvc.perform(post(URI)
				.contentType(APPLICATION_JSON_UTF8)
				.content(mapper.writeValueAsString(request)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.flights").isArray())
                .andExpect(jsonPath("$.flights", hasSize(2)));
		// @formatter:on
	}

}
