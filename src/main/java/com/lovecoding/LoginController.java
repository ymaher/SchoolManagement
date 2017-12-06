package com.lovecoding;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lovecoding.dao.LoginDao;
import com.lovecoding.model.Login;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("pass");
		System.out.println("Controller called");
		
		LoginDao dao = new LoginDao();
		Login l1 = dao.getLogin(userName);
		
		request.setAttribute("Login", l1);
		
		if((userName.equals(l1.getUserName().toString()))&&(password.equals(l1.getPassword().toString()))) 
		{
			
			HttpSession session = request.getSession();
			session.setAttribute("userName", userName);
			
			RequestDispatcher rd =  request.getRequestDispatcher("welcome.jsp");
			rd.forward(request, response);
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
		

	}


}
