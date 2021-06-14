<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% HttpSession hs=request.getSession();
String fname =(String)hs.getAttribute("fname");
String lname =(String)hs.getAttribute("lname");
out.println("Users name is   : "+fname);
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

</body>
</html>