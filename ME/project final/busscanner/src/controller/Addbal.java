package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.model;

public class Addbal extends HttpServlet
{
	public void service(HttpServletRequest x,HttpServletResponse y)
	{
		String userid=x.getParameter("userid");
		String balance=x.getParameter("balance");
		String exp_date=null;
		int ba=Integer.parseInt(balance);
		int user=Integer.parseInt(userid);
		model m=new model();
		m.setBalance(balance);
		if(ba==500)
		{
			exp_date="2021-2-12";
		}
		else if(ba==1000)
		{
			exp_date="2021-5-12";
		}
		else if(ba==2500)
		{
			exp_date="2021-12-12";
		}
		else if(ba==5000)
		{
			exp_date="2022-12-12";
		}
		m.setUserid(user);
		m.setExp_date(exp_date);
		boolean temp=m.Addbal();
		if(temp=true)
		{
			try {
				y.sendRedirect("/busscanner/BalanceUpdated.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				
				e.printStackTrace();
			}
		}
		else
		{
			try {
				y.sendRedirect("/busscanner/BalanceFailure.html");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}