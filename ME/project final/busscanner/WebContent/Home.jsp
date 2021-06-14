<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Success</title>
<style>
 body {font-family: Arial, Helvetica, sans-serif;
background:linear-gradient(to right, #0099cc 0%, #ccffff 100%);}
h2 { color: rgb(0, 0, 0); text-shadow: 0 0 10px rgba(0,0,0,0.3);
   letter-spacing:1px; text-align:center; }

.center {
  margin: auto;
  text-align: center;
  border: 2px solid rgb(0, 0, 0);
  padding: 70px 0;
}
</style>

</head>

<body>

<div class="center">
<% HttpSession hs=request.getSession();
String fname =(String)hs.getAttribute("fname");
out.println("Welcome u have  logged in,   : "+fname);
%><br/>
<%
int userid=(int)hs.getAttribute("userid");
out.println("Your UserID is  : " +userid);
%><br/>
<%
String email=(String)hs.getAttribute("email");
out.println("Your Registered email is  : " +email);
%><br/>
<% String contact =(String)hs.getAttribute("contact");
out.println("Your contact number is  : "+contact); %><br/>
<% String balance =(String)hs.getAttribute("balance");
out.println("Your Remaining balance is  : "+balance); %><br/>
<% String exp_date =(String)hs.getAttribute("exp_date");
out.println("Your validity expire on : "+exp_date); %><br/>

<h2> <a href="http://192.168.43.139:9091/busscanner/Addbal.html">Click here to add Money and validity</a> </h2>
</div>
</body>
</html>
