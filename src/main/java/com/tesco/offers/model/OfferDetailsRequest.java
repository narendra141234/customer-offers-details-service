package com.tesco.offers.model;

import java.util.List;

import lombok.Data;

@Data
public class OfferDetailsRequest {
	
	private String cardnum;
	private List<String> offersType;

}
