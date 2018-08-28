<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="member" class="com.study.jsp.MemberInfo" scope="page" />
<jsp:setProperty name="member" property="name" value="홍길동"/>
<jsp:setProperty name="member" property="id" value="abc"/>
<jsp:setProperty name="member" property="pw" value="123"/>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP/Servlet 23-2</title>
</head>
<body>
	이름 : <jsp:getProperty name="member" property="name" /><br>
	아이디 : <jsp:getProperty name="member" property="id" /><br>
	비밀번호 : <jsp:getProperty name="member" property="pw"/><br>
	
		<!-- 실무에 많이쓰임! -->
	<hr>
	이름 : ${member.name }<br>
	이름 : ${member.id }<br>
	이름 : ${member.pw }<br>
	
	
</body>
</html>