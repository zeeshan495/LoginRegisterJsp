package com.bridgeit.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener{
	ServletContext ctx=null;
	static int total=0,current=0;
	
	public void sessionCreated(HttpSessionEvent evnt)
	{
		total++;
		current++;
		ctx=evnt.getSession().getServletContext();
		ctx.setAttribute("totalUsers", total);
		ctx.setAttribute("currentUsers", current);
	}

	public void sessionDestroyed(HttpSessionEvent arg0) {
		current--;
		ctx.setAttribute("currentUsers", current);
		
	}
	

}
