/*
 * Target1:: cheeck whether Rest service is up or not 
 * if up then perform operations or 
 * revert back to some UI page informing the
 * user service is unavialble at the moment
 * 
 * Target 2::
 * Also We can use it to authenticate but let's do that via
 * Spring security module(more fun)
 * 
 */

/*Note
 * This handleinterceptor is java8 interface having all 3 methods
 * as concrete default methods
 * 
 */

package com.beta.interceptors;




import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class RestServiceTimeCheckInterceptor implements HandlerInterceptor{
@Override
public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
		throws Exception {
	
	System.out.println("HELLO CALLING FROM::RestServiceCheckInterceptor.preHandle()");
	
	//get system date and time
	LocalDateTime localDateTime=LocalDateTime.now();
	//get current hour of the day
	int hour=localDateTime.getHour();
	//int  serviceDowntime=8;
	if(hour>7&&hour<10) {
		System.out.println("Not allowed after 9AM");
		String  responseFromInterceptor="Service not allowed after&nbsp;"+hour+"&nbsp;Hour"+"<br>Try after some time";
		RequestDispatcher rd=req.getRequestDispatcher("/service_unavailable.jsp");
		req.setAttribute("response", responseFromInterceptor);
		rd.include(req, resp);
		
		return false;
	}//end of if
		
	

	// TODO Auto-generated method stub
	return true;
}//end of method

@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	System.out.println("HELLO CALLING FROM::RestServiceCheckInterceptor.postHandle()");
	
		
	}//end of method

@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("HELLO CALLING FROM::RestServiceCheckInterceptor.afterCompletion()");
	}//end of method
}//end of class

