package com.oreillyauto.netpricedemo.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreillyauto.netpricedemo.dao.PriceFactorDAO;
import com.oreillyauto.netpricedemo.domain.ListPrice;


@Service
public class ListPriceService{
	
	private static final String LIST_PRISE_DIVIDE_FACTOR="LIST_PRISE_DIVIDE_FACTOR";
	
	private static final Logger logger = LoggerFactory.getLogger(ListPriceService.class);
	
	private PriceFactorDAO priceFactorDAO;

	@Autowired
	public ListPriceService(PriceFactorDAO priceFactorDAO) {
	
		this.priceFactorDAO = priceFactorDAO;
	}

/*	public ItemPrice calclulateListPrice(ItemPrice itemPrice) {
		
		System.out.println("Reched list Prise");
			
	BigDecimal priceFrom1 = itemPrice.getPriceFrom();
	
	BigDecimal priceFactor1 = itemPrice.getPriceFactor();
	
		System.out.println("Reched list Prise2");
		
		if(priceFrom1!=null && priceFactor1!=null) {
			
			itemPrice.setListPrice(calculateListPrise(priceFrom1,priceFactor1 ));
			
		}
				
		return itemPrice;
	}
	*/
	
	public ListPrice calclulateListPrice(int storeNumber, String line, String item, BigDecimal price_to_calculate_list_price_from, BigDecimal list_price_divide_by_factor) {
		
		ListPrice itemPrice = new ListPrice();
		itemPrice.setStoreNumber(storeNumber);
		itemPrice.setLine(line);
		itemPrice.setItem(item);
		
		
		
		if (price_to_calculate_list_price_from!=null && list_price_divide_by_factor!=null){
		
			logger.info("Info log message Not Null");
			
			itemPrice.setListPrice(calculateListPrise(price_to_calculate_list_price_from, list_price_divide_by_factor));
		
		}
		if(list_price_divide_by_factor==null) {
						
									
			BigDecimal list_price_divide_by_factor1 = new BigDecimal(priceFactorDAO.priceFactor(LIST_PRISE_DIVIDE_FACTOR));
			
			logger.info("Info log message"+list_price_divide_by_factor1);
			
			itemPrice.setListPrice(calculateListPrise(price_to_calculate_list_price_from, list_price_divide_by_factor1));
		}
		
		if(price_to_calculate_list_price_from==null) {
			
			
		BigDecimal price_to_calculate_list_price_from1 = new BigDecimal("200.00");			
			
			
			itemPrice.setListPrice(calculateListPrise(price_to_calculate_list_price_from1, list_price_divide_by_factor));
		}
		
		return itemPrice;
	}

		
	private static  BigDecimal calculateListPrise(BigDecimal priceFrom1, BigDecimal priceFactor1) {
				
		return priceFrom1.divide(priceFactor1,2, BigDecimal.ROUND_HALF_UP);
		
		// TODO Auto-generated method stub
	
		}

}
