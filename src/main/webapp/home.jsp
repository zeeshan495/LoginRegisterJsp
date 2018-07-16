<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>
<%
/* /*HttppSession*/
 String user=null;
/* 
if(session.getAttribute("mail")==null)
{
	response.sendRedirect("index.jsp");
}
else 
	user = (String) session.getAttribute("mail");  */

 String userName = null;
 String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("mail"))
	{
		userName = cookie.getValue();	
	}
	if(cookie.getName().equals("JSESSIONID"))
	{
		sessionID = cookie.getValue();
	}
	else{
		sessionID = session.getId();
	}
}
} 
if(userName == null) response.sendRedirect("index.jsp");
%>
<h1>welcome to home page</h1>

<p><%String mailIdUser=null;
mailIdUser=(String) request.getAttribute("mailIdUser"); 
String user1=null;

if(session.getAttribute("mail")!=null)
{
	mailIdUser=(String) session.getAttribute("mail");
}
out.print("User : "+userName);%></p>

<form action="LogoutUrl" method="post">
<input type="submit" value="logout">
</form>

<h2>Hi <%=userName %>, Login successful. Your Session ID=<%=sessionID %></h2>
</body>
</html>