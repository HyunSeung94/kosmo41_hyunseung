<%@ page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
		 
		 String sName;
         String sValue;
         Enumeration enumeration = session.getAttributeNames();
         int a = 0; 
      	 while(enumeration.hasMoreElements()){
 			 a++;
 			 
        	 sName = enumeration.nextElement().toString();
      	 	 sValue = (String)session.getAttribute(sName);
       	 	 out.println( sName + ": " + sValue +"<br />");
         }
      	
      	if(a == 0)
      		out.println("잘못된 접근입니다. 다시 로그인 하세요.");
      %>
</body>
</html>