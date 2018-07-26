package com.oreillyauto.netpricedemo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemPrice implements Comparable<ItemPrice>, Serializable {

	
	public int getStoreNumber() {
		return storeNumber;
	}

	
	public void setStoreNumber(int storeNumber) {
		this.storeNumber = storeNumber;
	}


	public String getLine() {
		return line;
	}


	public void setLine(String line) {
		this.line = line;
	}


	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}

	public ApiError getError() {
		return error;
	}

	public void setError(ApiError error) {
		this.error = error;
	}


	public BigDecimal getPriceFrom() {
		return PriceFrom;
	}


	public BigDecimal getPriceFactor() {
		return PriceFactor;
	}

	
	public void setListPrice(BigDecimal listPrice) {
		this.listPrice = listPrice;
	}

	public ItemPrice() {

	}


	@Override
	public String toString() {
		return "ItemPrice [storeNumber=" + storeNumber + ", line=" + line + ", item=" + item + ", listPrice=" + listPrice + ", error=" + error + "]";
	}


	// PriceFrom="
		//		+ PriceFrom + ", PriceFactorDomain=" + PriceFactorDomain + ",


	private int storeNumber;
	private String line;
	private String item;
	private BigDecimal PriceFrom = BigDecimal.ZERO;
	private BigDecimal PriceFactor = BigDecimal.ZERO;
	private BigDecimal listPrice = BigDecimal.ZERO;
	private ApiError error;
	
	public BigDecimal getListPrice() {
		return listPrice;
	}

	
	public void setPriceFrom(BigDecimal priceFrom) {
		PriceFrom = priceFrom;
	}


	public void setPriceFactor(BigDecimal priceFactor) {
		PriceFactor = priceFactor;
	}

		
	@Override
	public int compareTo(ItemPrice arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
		

}
