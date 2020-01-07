package com.michael.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/logout")

public class LogoutServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
		throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter pw= res.getWriter();
		HttpSession session= req.getSession();
		session.invalidate();
		pw.println("You are successfully logged out");
		RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
		rd.include(req, res);
	}
}
