package com.oreillyauto.netpricedemo.controller;


import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.oreillyauto.netpricedemo.config.SwaggerConfig;
import com.oreillyauto.netpricedemo.domain.ItemPrice;
import com.oreillyauto.netpricedemo.domain.ListPrice;
import com.oreillyauto.netpricedemo.domain.PriceFactorDomain;
import com.oreillyauto.netpricedemo.domain.enums.PriceFactor;
import com.oreillyauto.netpricedemo.service.ListPriceService;
import com.oreillyauto.netpricedemo.service.PriceFactorService;

@RestController
@RequestMapping("/api/")
public class PriceController {
	
	private static final Logger logger = LoggerFactory.getLogger(PriceController.class);
	
	private ListPriceService listPriceService;
	private PriceFactorService priceFactorService;
	
	@Autowired
	public PriceController(ListPriceService listPriceService, PriceFactorService priceFactorService) {
			this.listPriceService = listPriceService;
			this.priceFactorService=priceFactorService;
	}
	
	
	
	@GetMapping(value = "/listPrice", produces="application/json")
	public ListPrice getListPrice(
			@RequestParam(value = "storeNumber", required = true) int storeNumber,
			@RequestParam(value = "line", required = true) String line,
			@RequestParam(value = "item", required = true) String item,
			@RequestParam(value = "price_to_calculate_list_price_from", required = false) BigDecimal price_to_calculate_list_price_from,
			@RequestParam(value = "list_price_divide_by_factor", required = false) BigDecimal list_price_divide_by_factor) {
				
	       logger.info("Info log message"+"storeNumber"+storeNumber+"line"+line+"item"+item
        		+"price_to_calculate_list_price_from"+price_to_calculate_list_price_from+"list_price_divide_by_factor"+list_price_divide_by_factor);
   
        System.out.println("ListPrice Service Reached");
        
		return this.listPriceService.calclulateListPrice(storeNumber, line, item, price_to_calculate_list_price_from, list_price_divide_by_factor );
	}
	
	@GetMapping(value = "/priceFactor/{priceFactor}", produces="application/json")
	public PriceFactorDomain getDivideFactor(@PathVariable("priceFactor") PriceFactor priceFactor) {
		 
		logger.info("Info log message"+priceFactor.toString());
		
		return this.priceFactorService.getPriceFactor(priceFactor.toString());
	}
	
	
	
	@PostMapping(value="/priceList",  produces="application/json")
	@ResponseStatus(HttpStatus.OK)
	public ItemPrice getPriceList(@RequestBody ItemPrice itemPrice) {
				
		return null;
		//this.listPriceService.calclulateListPrice(itemPrice);
	}
	

}
