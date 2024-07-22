package com.tesco.offers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tesco.offers.builder.OfferDetailsRequestBuilder;
import com.tesco.offers.builder.OfferDetailsRespBuilder;
import com.tesco.offers.dao.IOfferDetailsDao;
import com.tesco.offers.model.EnrollmentRequest;
import com.tesco.offers.model.EnrollmentResponse;
import com.tesco.offers.model.OfferDetailsDaoRequest;
import com.tesco.offers.model.OfferDetailsDaoResp;
import com.tesco.offers.model.OfferDetailsRequest;
import com.tesco.offers.model.OfferDetailsResponse;
import com.tesco.offers.serviceclient.IEnrollmentServiceClient;

@Component
public class OfferDetailsServiceImpl implements IOfferDetailsService{
	
	@Autowired
	OfferDetailsRequestBuilder offerDtlsReqBuilder;
	
	@Autowired
	OfferDetailsRespBuilder offerDtlsResBuilder;
	
	@Autowired
	IEnrollmentServiceClient enrollmentSvcClient;
	
	@Autowired
	IOfferDetailsDao offersDao;

	@Override
	public OfferDetailsResponse getOffers(OfferDetailsRequest offerDetailsRequest) {
		
		EnrollmentRequest enrollmentRequest = new EnrollmentRequest();
		EnrollmentResponse enrollmentResp = enrollmentSvcClient.enrollment(enrollmentRequest);
		
		OfferDetailsDaoRequest daoDetailsDaoRequest = new OfferDetailsDaoRequest();
		OfferDetailsDaoResp offerDetailsDaoResp = offersDao.getOffers(daoDetailsDaoRequest);
		
		OfferDetailsResponse offerDetailsResponse = new OfferDetailsResponse();
		
		// TODO Auto-generated method stub
		return offerDetailsResponse;
	}

}
