package com.michael.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.michael.model.LoginBean;
@WebServlet("/loginServlet")
public class LoginController extends HttpServlet{
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException{
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		String username= req.getParameter("un");
		String password= req.getParameter("pwd");
		
		LoginBean bean = new LoginBean();
		bean.setUsername(username);
		bean.setPassword(password);
		HttpSession session=req.getSession();
		session.setAttribute("abc", bean);
		boolean status= bean.validateLogin();
		if(status) {
			//RequestDispatcher rd= req.getRequestDispatcher("success.jsp");
			//rd.forward(req, res); (Forwarding)
			res.sendRedirect("success.jsp"); //(Redirecting)
		}
		else {
			pw.println("<font color='red' > Invalid Username/Password Error</font>");
			RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
			rd.include(req, res);
		}
	}
}
