package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.model;

import javax.servlet.http.HttpServletRequest;

public class Register extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String fname=x.getParameter("fname");
		String lname=x.getParameter("lname");
		String email=x.getParameter("email");
		String contact=x.getParameter("number");
		String password=x.getParameter("password");
		model m=new model();
		m.setFname(fname);
		m.setLname(lname);
		m.setEmail(email);
		m.setContact(contact);
		m.setPassword(password);
		int temp=m.Register();
		if(temp==1)
		{
			try {
				y.sendRedirect("/busscanner/AccountCreate.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				y.sendRedirect("/busscanner/AccountFailed.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}