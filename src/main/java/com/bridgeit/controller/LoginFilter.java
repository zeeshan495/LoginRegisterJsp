package com.bridgeit.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import com.bridgeit.service.Service;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String mailId = request.getParameter("mailId");
		String pwd = request.getParameter("pwd");
		Service service = new Service();
		boolean userExist;
		try {
			userExist = service.checkLoginUser(mailId, pwd);
			if (userExist) {
				chain.doFilter(request, response);
			} else {

				String loginError = "Please check entered mail id and password";
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("loginError", loginError);
				rd.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
