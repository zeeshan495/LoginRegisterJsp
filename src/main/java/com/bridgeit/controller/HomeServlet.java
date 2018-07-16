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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String mailId = request.getParameter("mailId");

		// ****httpsession***
		HttpSession session = request.getSession();
		session.setAttribute("mail", mailId);
		session.setMaxInactiveInterval(15 * 60);

		// ****cookies****
		Cookie ck = new Cookie("mail", mailId);
		ck.setMaxAge(10 * 60);
		System.out.println("cookie : " + ck);
		response.addCookie(ck);

		// Get the encoded URL string
		String encodedURL = response.encodeURL("home.jsp");
		response.sendRedirect(encodedURL);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
