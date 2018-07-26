package com.oreillyauto.netpricedemo.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

@Repository
public class PriceFactorDAO {
	
	private final NamedParameterJdbcTemplate namedParameterJbbcTemplate;

	@Autowired
	public PriceFactorDAO(NamedParameterJdbcTemplate namedParameterJbbcTemplate) {
	
		this.namedParameterJbbcTemplate = namedParameterJbbcTemplate;
	}


		public String priceFactor(String priceFactor1) {
			
			MapSqlParameterSource namedParameters = new MapSqlParameterSource();
			
			namedParameters.addValue("DIVIDE_BY_FACTOR",priceFactor1);
		
			String sql = "select PRICING_VALUE from PRICING_VALUES where PRICING_VALUE_TYPE= :DIVIDE_BY_FACTOR";
									
			return   namedParameterJbbcTemplate.queryForObject(sql, namedParameters, String.class);
			
			   
		}
	

}
