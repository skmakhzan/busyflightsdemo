package com.travix.medusa.busyflights.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.busyflights.domain.BusyFlightsRequest;
import com.travix.medusa.busyflights.domain.BusyFlightsResponse;
import com.travix.medusa.busyflights.service.BusyFlightsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author skh
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "Flights search")
public class BusyFlightsController {

	@Autowired
	private BusyFlightsService busyFlightsService;

	@PostMapping(value = "/flights")
	@ApiOperation(value = "Get flights")
	public BusyFlightsResponse getFlights(@Valid @RequestBody BusyFlightsRequest request) {
		return busyFlightsService.findFlights(request);
	}

}
