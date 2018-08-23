<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP/Servlet 13-2</title>
</head>
<body>
	
	<%
		request.setCharacterEncoding("UTF-8");
		
		Enumeration enumeration = session.getAttributeNames();
			if(enumeration.hasMoreElements()){
			session.removeAttribute("id");
			session.removeAttribute("pw");
			session.removeAttribute("name");		
		}
		
		response.sendRedirect("login.html");
		//response.sendRedirect("cookietest.jsp");
	%>
</body>
</html>