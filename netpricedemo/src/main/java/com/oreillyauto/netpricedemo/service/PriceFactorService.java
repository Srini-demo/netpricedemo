package com.oreillyauto.netpricedemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.netpricedemo.dao.PriceFactorDAO;
import com.oreillyauto.netpricedemo.domain.PriceFactorDomain;
import com.oreillyauto.netpricedemo.domain.enums.PriceFactor;

@Service
public class PriceFactorService {
	
	private PriceFactorDAO priceFactorDAO;
	
	
	@Autowired
	public PriceFactorService(PriceFactorDAO priceFactorDAO) {
			this.priceFactorDAO = priceFactorDAO;
	}



	public PriceFactorDomain getPriceFactor(String priceFactor) {
		// TODO Auto-generated method stub
		PriceFactorDomain priceFactorDomain = new PriceFactorDomain();
		
		priceFactorDomain.setPricing_value_type(priceFactor);
		priceFactorDomain.setPricing_value(priceFactorDAO.priceFactor(priceFactor));
				 
		return priceFactorDomain;
	}
	

}
