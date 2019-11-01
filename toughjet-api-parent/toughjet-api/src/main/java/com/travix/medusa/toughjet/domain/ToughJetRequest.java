package com.travix.medusa.toughjet.domain;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author skh
 *
 */
public class ToughJetRequest {

	private static final int IATA_CODE_LENGTH = 3;

	@NotNull(message = "Please provide from")
	@Size(min = IATA_CODE_LENGTH, max = IATA_CODE_LENGTH, message = "from must be between 3 and 3")
	private String from;

	@NotNull(message = "Please provide to")
	@Size(min = IATA_CODE_LENGTH, max = IATA_CODE_LENGTH, message = "to must be between 3 and 3")
	private String to;

	@NotNull(message = "Please provide outboundDate")
	private LocalDate outboundDate;

	@NotNull(message = "Please provide inboundDate")
	private LocalDate inboundDate;

	private int numberOfAdults;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public LocalDate getOutboundDate() {
		return outboundDate;
	}

	public void setOutboundDate(LocalDate outboundDate) {
		this.outboundDate = outboundDate;
	}

	public LocalDate getInboundDate() {
		return inboundDate;
	}

	public void setInboundDate(LocalDate inboundDate) {
		this.inboundDate = inboundDate;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

}
