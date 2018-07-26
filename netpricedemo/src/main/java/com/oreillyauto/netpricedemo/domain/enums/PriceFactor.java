package com.oreillyauto.netpricedemo.domain.enums;

public enum PriceFactor {
	
	
	
	LIST_PRISE_DIVIDE_FACTOR("list_prise_divide_factor"),
	
	JOBBER_DIVIDE_FACTOR("jobber_divide_factor");
	
	private final String priceFactor;

	private PriceFactor(String priceFactor) {
		this.priceFactor = priceFactor;
	}

	public String getPriceFactor() {
		return priceFactor;
	}
	


}
