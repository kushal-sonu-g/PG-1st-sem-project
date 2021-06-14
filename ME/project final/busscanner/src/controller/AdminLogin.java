package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.model;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String user=x.getParameter("user");
		String password=x.getParameter("password");
		model m=new model();
		
		int temp=m.Register();
		if(temp==1)
		{
			try {
				y.sendRedirect("/busscanner/AdminPage.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try {
				y.sendRedirect("/busscanner/Adminfailed.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
