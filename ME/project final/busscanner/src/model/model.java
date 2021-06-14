package model;

import java.sql.*;

public class model {
	int userid;
	String fname=null;
	String lname=null;
	String email=null;
	String password=null;
	String contact=null;;
	String balance=null;
	String exp_date=null;
	String user=null;
	String url="jdbc:mysql://localhost:3306/buspass?characterEncoding=utf8";
	String uname="root";
	String pass="root123";
	Connection con=null;
	PreparedStatement pstmt=null;
	int res=0;
	ResultSet tes=null;
	
	public  model()

	{
	  	try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection(url, uname, pass);
			System.out.println("database connected and loaded");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("not connected");
		}
	}
	 
	public int Register()
	{
		try {
			pstmt=con.prepareStatement(" INSERT INTO USERS(first_name,last_name,email,contact_no,password) VALUES(?,?,?,?,?) ");
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, email);
			pstmt.setString(4, contact);
			pstmt.setString(5, password);
			res=pstmt.executeUpdate();
			if(res==1)
			{
				System.out.println("Querry Excecuted ");
			}
			else
			{
				System.out.println("Querry not Excecuted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Querry not Excecuted");
		}
		
		
		
		return res;
	}
	public boolean Login()
	{
		try {
			pstmt=con.prepareStatement("SELECT * FROM USERS WHERE EMAIL=? AND PASSWORD=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			tes=pstmt.executeQuery();
			if(tes.next()==false)
			{
				return false;
			}
			else
			{
				userid=tes.getInt(1);
				fname=tes.getString(2);
				email=tes.getString(4);
				contact=tes.getString(5);
				exp_date=tes.getString(8);
				balance=tes.getString(9);
				System.out.println("Query excecuted");
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean Addbal()
	{
	  try {
		pstmt=con.prepareStatement("Update users set Balance=0+? Where user_id=?");
		pstmt.setString(1, balance);
		pstmt.setInt(2, userid);
		int j=pstmt.executeUpdate();
		pstmt=con.prepareStatement("update users set exp_date=? where user_id=?");
		pstmt.setString(1, exp_date);
		pstmt.setInt(2, userid);
		pstmt.executeUpdate();
		if(j==1)
		{
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("not executed");
		
		return false;
	}
	  return false;
	}
	
	public boolean AdminLogin()
	{
		try {
			pstmt=con.prepareStatement("SELECT * FROM admin WHERE user_name=? AND PASSWORD=?");
			pstmt.setString(1, user);
			pstmt.setString(2, password);
			tes=pstmt.executeQuery();
			if(tes.next()==false)
			{
				return false;
			}
			else
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	public boolean View()
	{
		try {
			pstmt=con.prepareStatement("SELECT * from users where user_id=?");
			pstmt.setInt(1, userid);
			tes=pstmt.executeQuery();
			if(tes.next()==false)
			{
				return false;
			}
			else
			{
				userid=tes.getInt(1);
				fname=tes.getString(2);
				lname=tes.getString(3);
				email=tes.getString(4);
				contact=tes.getString(5);
				exp_date=tes.getString(8);
				balance=tes.getString(9);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	
	
	
	
	
	

}
