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
if(session.getAttribute("mail")==null)
{
	response.sendRedirect("index.jsp");
}
else 
	user = (String) session.getAttribute("mail"); 


/* String userName = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("mail"))
	{
		userName = cookie.getValue();
		
	}
}
}
if(userName == null) 
	response.sendRedirect("index.jsp");  */
%>
<h1>welcome to home page</h1>

<form action="LogoutUrl" method="post">
<input type="submit" value="logout">
</form>
</body>
</html>