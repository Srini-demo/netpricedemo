package com.oreillyauto.netpricedemo.domain;

public class PriceFactorDomain {
	

	public String getPricing_value_type() {
		return pricing_value_type;
	}



	public void setPricing_value_type(String pricing_value_type) {
		this.pricing_value_type = pricing_value_type;
	}



	public String getPricing_value() {
		return pricing_value;
	}



	public void setPricing_value(String pricing_value) {
		this.pricing_value = pricing_value;
	}



	public ApiError getError() {
		return error;
	}



	public void setError(ApiError error) {
		this.error = error;
	}



	@Override
	public String toString() {
		return "PriceFactorDomain [pricing_value_type=" + pricing_value_type + ", pricing_value=" + pricing_value
				+ ", error=" + error + "]";
	}



	private String pricing_value_type;
	private String pricing_value;
	private ApiError error;
	


public PriceFactorDomain() {
		
		// TODO Auto-generated constructor stub
	}

}
