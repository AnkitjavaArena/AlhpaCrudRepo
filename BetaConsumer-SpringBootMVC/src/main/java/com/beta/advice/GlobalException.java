package com.beta.advice;

import java.util.StringTokenizer;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(Exception.class)
	public ModelAndView  processIOException(Exception e)
	{
		ModelAndView mav = new ModelAndView();
		String response=e.getMessage();
		//use strintokenizer
		StringTokenizer st=new StringTokenizer(response,":");
		String s=new String();
		while(st.hasMoreTokens()) {
			s=st.nextToken();
			//System.out.println(s);
			
		}
		
	//System.out.println("s::"+s);
	//System.out.println("====substring::====");
	s=s.substring(1);
	
	st=new StringTokenizer(s,"\"");
	
		s=st.nextToken();
		//System.out.println(s);
		


		mav.setViewName("error");
		 mav.addObject("name", e.getClass().getSimpleName());
	     mav.addObject("message", s);
	 
	     return mav;
	}
	
	
	@ExceptionHandler(Error.class)
	public ModelAndView  processIOException(Error e)
	{
		ModelAndView mav = new ModelAndView();
		//mav.setViewName("error");
		// mav.addObject("name", e.getClass().getSimpleName());
	    // mav.addObject("message", "hello");
	 
	     return mav;
	}
}//end of class
