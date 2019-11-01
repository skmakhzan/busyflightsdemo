package com.travix.medusa.crazyair.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.crazyair.domain.CrazyAirRequest;
import com.travix.medusa.crazyair.domain.CrazyAirResponse;
import com.travix.medusa.crazyair.service.CrazyAirService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author skh
 *
 */
@RestController
@RequestMapping({ "/api" })
@Api("CrazyAir search")
public class CrazyAirController {

	@Autowired
	private CrazyAirService crazyAirService;

	@PostMapping({ "/crazyair" })
	@ApiOperation("Get crazyair flights")
	public ResponseEntity<CrazyAirResponse> getFlights(@Valid @RequestBody CrazyAirRequest request) {
		CrazyAirResponse response = new CrazyAirResponse();
		List<CrazyAirResponse.CrazyAirFlight> flights = this.crazyAirService.findFlights(request);
		response.setFlights(flights);
		return new ResponseEntity<CrazyAirResponse>(response, HttpStatus.OK);
	}
}
