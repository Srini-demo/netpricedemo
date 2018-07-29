package com.oreillyauto.netpricedemo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.oreillyauto.netpricedemo.domain.ApiError;
import com.oreillyauto.netpricedemo.domain.ListPrice;
import com.oreillyauto.netpricedemo.domain.PriceFactorDomain;


@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	public ApiError apiError;
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
	  MethodArgumentNotValidException ex, 
	  HttpHeaders headers, 
	  HttpStatus status, 
	  WebRequest request) {
	    List<String> errors = new ArrayList<>();
	   for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(error.getField() + ": " + error.getDefaultMessage());
	        //+ ": " +error.getRejectedValue()+ ": " +error.getCode());
	    }
	    for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
	        errors.add(error.getObjectName() + ": " + error.getDefaultMessage());
	    }
	     
	    apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	    return handleExceptionInternal(
	      ex, apiError, headers, apiError.getStatus(), request);
	}	
	
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
	  MethodArgumentTypeMismatchException ex, WebRequest request) {
	    String error = 
	      ex.getName() + " should be of type " + ex.getRequiredType().getName();
	    	     
	    apiError = 
	      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	
	//@ExceptionHandler({ItemNotFoundException.class })
	protected ResponseEntity<Object> handleNotFound(Exception ex, WebRequest request){
		 String error = "The requested Item is not found";
			     
		apiError = 
			      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		
		
			    return new ResponseEntity<Object>(
			      apiError, new HttpHeaders(), apiError.getStatus());
	
	}
	
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
			  MissingServletRequestParameterException ex, HttpHeaders headers, 
			  HttpStatus status, WebRequest request) {
			    String error = ex.getParameterName() + "parameter is missing";
			     
			     apiError = 
					      new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);  
			  /*  
			    
		    ListPrice listPrice = new ListPrice();

			   // request.getParameterMap();
			    
			    if(request.getParameter("storeNumber")!=null){
			    
			    	listPrice.setStoreNumber(Integer.parseInt(request.getParameter("storeNumber")));
			    }
			    
			    if(request.getParameter("line")!=null)
			    {
			    	listPrice.setLine(request.getParameter("line"));
			    	
			    }
			    
			    if(request.getParameter("item")!=null)
			    {
			    	listPrice.setItem(request.getParameter("item"));
			    	
			    }
				   listPrice.setError(apiError); 
			  
			    */
			    
			    return new ResponseEntity<Object>(
			    		apiError, new HttpHeaders(), apiError.getStatus());
			}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	    apiError = new ApiError(
	      HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "error occurred");
	    return new ResponseEntity<Object>(
	      apiError, new HttpHeaders(), apiError.getStatus());
	}
}
