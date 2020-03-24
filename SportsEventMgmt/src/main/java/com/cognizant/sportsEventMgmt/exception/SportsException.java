package com.cognizant.sportsEventMgmt.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class SportsException {
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception ex) {
		ModelAndView model = new ModelAndView();
		// model.addObject("errMsg", "Email Id is already in use. Please Sign
		// in.");
		System.out.println("Exception");
		model.setViewName("index");
		return model;
	}

}
