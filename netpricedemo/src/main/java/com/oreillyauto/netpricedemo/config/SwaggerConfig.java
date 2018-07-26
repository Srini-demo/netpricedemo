package com.oreillyauto.netpricedemo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
/*	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }*/
	private static final Logger logger = LoggerFactory.getLogger(SwaggerConfig.class);
	 
    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message"+SwaggerConfig.class);
        logger.error("Error log message");
    }
	
	@Bean
	public Docket productApi() {    		
	    return new Docket(DocumentationType.SWAGGER_2)          
	      .select()                                       
	      .apis(RequestHandlerSelectors.basePackage("com.oreillyauto.netpricedemo.controller"))
	      .paths(regex("/api.*"))                     
	      .build();
	}
	
}
