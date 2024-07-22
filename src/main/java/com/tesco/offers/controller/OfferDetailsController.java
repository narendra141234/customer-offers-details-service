package com.tesco.offers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tesco.offers.model.OfferDetailsRequest;
import com.tesco.offers.model.OfferDetailsResponse;
import com.tesco.offers.service.IOfferDetailsService;
import com.tesco.offers.validator.OfferDetailsRequestValidator;

@RestController
@RequestMapping("/v1")
public class OfferDetailsController {
	
	@Autowired
	IOfferDetailsService offerDetailsService;
	
	@Autowired
	OfferDetailsRequestValidator offerDetailsReqValidator;
	
	
	
	@GetMapping("/offers/{cardnum}")
	public OfferDetailsResponse getOffers(@PathVariable("cardnum") String cardnum,
											@RequestHeader("X-Client-Id") String clentid,
											@RequestHeader("X-Channel-Id") String channelid,
											@RequestHeader("X-request-Id") String requestId,
											@RequestHeader("X-messagets-Id") String messageTs,
											@RequestHeader("X-authtoken-Id") String authtoken) {
		
		OfferDetailsRequest offerDetailsRequest = new OfferDetailsRequest();
		
		//1.Validate the request
		offerDetailsReqValidator.validateRequest(offerDetailsRequest);
		
		OfferDetailsResponse offerResponse = offerDetailsService.getOffers(offerDetailsRequest );
		return offerResponse;
	}
	@GetMapping("/offers/{cardnum}/{offerType}")
	public OfferDetailsResponse getOffersByType(@PathVariable("cardnum") String cardnum,
											@PathVariable("offerType") String offerType,
											@RequestHeader("X-Client-Id") String clentid,
											@RequestHeader("X-Channel-Id") String channelid,
											@RequestHeader("X-request-Id") String requestId,
											@RequestHeader("X-messagets-Id") String messageTs,
											@RequestHeader("X-authtoken-Id") String authtoken) {
		
		OfferDetailsRequest offerDetailsRequest = new OfferDetailsRequest();
		
		offerDetailsReqValidator.validateRequest(offerDetailsRequest);
		OfferDetailsResponse offerResponse = offerDetailsService.getOffers(offerDetailsRequest );
		return offerResponse;
	}
	@PostMapping("/offers/{cardnum}/offerType")
	public OfferDetailsResponse getOffersByTypes(@RequestBody OfferDetailsRequest offerDetailsRequest,
											@RequestHeader("X-Client-Id") String clentid,
											@RequestHeader("X-Channel-Id") String channelid,
											@RequestHeader("X-request-Id") String requestId,
											@RequestHeader("X-messagets-Id") String messageTs,
											@RequestHeader("X-authtoken-Id") String authtoken) {
		
		
		offerDetailsReqValidator.validateRequest(offerDetailsRequest);
		OfferDetailsResponse offerResponse = offerDetailsService.getOffers(offerDetailsRequest );
		return offerResponse;
	}
}
