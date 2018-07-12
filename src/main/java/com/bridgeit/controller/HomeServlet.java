package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgeit.service.Service;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Service service=new Service();
		String mailId=request.getParameter("mailId");
		String pwd=request.getParameter("pwd");
		try {
			boolean userExist=service.checkLoginUser(mailId,pwd);
			if(userExist)
				request.getRequestDispatcher("home.jsp").include(request, response);
			else
			{
				pw.println("Please check entered mail id and password");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
