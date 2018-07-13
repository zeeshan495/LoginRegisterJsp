package com.bridgeit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgeit.model.UserInfo;
import com.bridgeit.service.Service;

/**
 * Servlet implementation class SaveServlet
 */
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String userName=request.getParameter("uName");
		String fullName=request.getParameter("fName");
		String mailId=request.getParameter("mail");
		String password=request.getParameter("Password");
		UserInfo info=new UserInfo();
		Service service=new Service();
		info.setUserName(userName);
		info.setFullName(fullName);
		info.setMailId(mailId);
		info.setPassword(password);
		try {
			boolean userExist=service.checkRegisterUser(mailId);
			if(userExist)
			{
				String userExistMsg="User already exists";
				RequestDispatcher rd=request.getRequestDispatcher("registerForm.jsp");
				request.setAttribute("userExist", userExistMsg);
				rd.include(request, response);
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		try {
			int status=service.save(info);
			if(status>0)
			{
				pw.println("You are successfully Register........");
				pw.println("Now you can login");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else
			{
				pw.println("oops......something went wrong");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
