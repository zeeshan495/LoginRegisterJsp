 /******************************************************************************
 *  Purpose:	home servlet for Login Registeration Form
 *
 *  @author  Zeeshan
 *  @version 1.0
 *  @since   12-07-2018
 *
 ******************************************************************************/ 
package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bridgeit.service.Service;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Service service=new Service();
		String mailId=request.getParameter("mailId");
		String pwd=request.getParameter("pwd");
		try {
			boolean userExist=service.checkLoginUser(mailId,pwd);
			if(userExist)
			{
		//		****cookies****
//				Cookie ck=new Cookie("mail",mailId);
//				System.out.println("cookie : "+ck);
//				response.addCookie(ck);
//				response.sendRedirect("home.jsp");
//				****httpsession***
				HttpSession session = request.getSession();
				session.setAttribute("mail", mailId);
				session.setMaxInactiveInterval(15*60);
				
			//retriving data from servletContext ****Listeners****
				
//				ServletContext ctx=request.getServletContext();
//				int total=(Integer)ctx.getAttribute("totalUsers");
//				int current=(Integer)ctx.getAttribute("currentUsers");
//				pw.println("total users "+total);
//				pw.println("current users "+current);
	//			response.sendRedirect("https://www.google.com");
				RequestDispatcher rd=request.getRequestDispatcher("home.jsp");
				request.setAttribute("mailIdUser", mailId);
				rd.include(request, response);
			}
				else
			{
				
				String loginError="Please check entered mail id and password";
//				Cookie ck=new Cookie("loginError",loginError);
//				response.addCookie(ck);
//				HttpSession session = request.getSession();
//				session.setAttribute("loginError", loginError);
//				session.setMaxInactiveInterval(10*60);
				RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
				
				
				request.setAttribute("loginError", loginError);
				rd.include(request, response);
			//	response.sendRedirect("index.jsp");
			//	request.getRequestDispatcher("index.jsp").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	


}
