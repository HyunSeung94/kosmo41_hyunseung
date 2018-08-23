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
		Cookie[] cookies = request.getCookies();
	
		if(cookies != null) {
			for(int i=0; i<cookies.length; i++){
					cookies[i].setMaxAge(0);
					response.addCookie(cookies[i]);
			}
		}
		
		response.sendRedirect("login.html");
		//response.sendRedirect("cookietest.jsp");
	%>
</body>
</html>