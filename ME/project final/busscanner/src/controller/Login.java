package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.model;


public class Login extends HttpServlet {	
	HttpSession hs=null;
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		int userid;
		String fname=null;
		String Email=null;
		String contact=null;
		String exp_date=null;
		String balance=null;
		String email=x.getParameter("email");
		String password=x.getParameter("password");
		model m=new model();
		{
			hs=x.getSession();
			m.setEmail(email);
			m.setPassword(password);
			boolean temp=m.Login();
			if(temp==true)
			{
				try {
					
					fname=m.getFname();
					Email=m.getEmail();
					contact=m.getContact();
					exp_date=m.getExp_date();
					balance=m.getBalance();
					userid=m.getUserid();
					y.sendRedirect("Home.jsp");
					hs=x.getSession(true);
					hs.setAttribute("fname", fname);
					hs.setAttribute("email", Email);
					hs.setAttribute("contact", contact);
					hs.setAttribute("exp_date", exp_date);
					hs.setAttribute("balance", balance);
					hs.setAttribute("userid", userid);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					y.sendRedirect("failed.html");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
