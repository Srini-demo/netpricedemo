package com.oreillyauto.netpricedemo.domain.enums;

import java.math.BigDecimal;
import java.util.stream.Stream;

public enum PriceType {
	
	RETAIL_PRICE ("Retail_Price"),
	RETAIL_CORE_PRICE ("Retail_Core_Price"),
	PROFESSIONAL_PRICE ("Professional_Price"),
	ALL("all"),
	NULL("null"),
	BLANK("blank");	
	
	
	private final String name;
	
	
	PriceType(String name){
		
		this.name= name;
	
	}

	public String getName() {
		return name;
	}

}
