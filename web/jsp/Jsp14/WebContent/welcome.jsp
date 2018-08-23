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
		
		Object obj1 = session.getAttribute("id");
		String sID = (String)obj1;
		
		/* while(enumeration.hasMoreElements()){
	      
        sID = enumeration.nextElement().toString();
        sID2 = session.getAttribute(sID).toString();
        
      	if (sID2.equals("abcde")){
      		out.println(sID2+"님 반갑습니다."+"<br />");
      		}
		} */
		
		
		if(sID == null) {
			response.sendRedirect("login.html");
		} else {
			out.println(sID + "님 어서오세요. "+"<br />");
		}
		
		
		

	%>
	
	<a href="logout.jsp">로그아웃</a><br/>
	
	<a href="sessiontest.jsp">세션 테스트</a>
</body>
</html>