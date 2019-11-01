package com.travix.medusa.toughjet.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.travix.medusa.toughjet.domain.ToughJetRequest;
import com.travix.medusa.toughjet.domain.ToughJetResponse;
import com.travix.medusa.toughjet.domain.ToughJetResponse.ToughJetFlight;
import com.travix.medusa.toughjet.service.ToughJetService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author skh
 *
 */
@RestController
@RequestMapping("/api")
@Api(value = "ToughJet search")
public class ToughJetController {

	@Autowired
	private ToughJetService toughJetService;

	@PostMapping(value = "/toughjet")
	@ApiOperation(value = "Get toughJets flights")
	public ResponseEntity<ToughJetResponse> getFlights(@Valid @RequestBody ToughJetRequest request) {
		ToughJetResponse response = new ToughJetResponse();
		List<ToughJetFlight> flights = toughJetService.findFlights(request);
		response.setFlights(flights);
		return new ResponseEntity<ToughJetResponse>(response, HttpStatus.OK);
	}

}
