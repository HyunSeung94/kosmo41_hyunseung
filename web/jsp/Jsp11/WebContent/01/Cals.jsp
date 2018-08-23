<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! 
   String num1, num2, calc2;
   int num3, num4, nResult;
   
%>

<% 
   request.setCharacterEncoding("UTF-8");

    num1 = request.getParameter("number01");
     num2 = request.getParameter("number02");
    calc2 = request.getParameter("calc");   

    num3 = Integer.parseInt(num1);
    num4 = Integer.parseInt(num2);
    nResult = 0;

   response.setContentType("text/html; charset=UTF-8");
   
%>

<%
   if(calc2.equals("+")) {
   
      nResult = num3 + num4;
         
   }else if(calc2.equals("-")) {
   
      nResult = num3 - num4;

   }else if(calc2.equals("*")) {

      nResult = num3 * num4;

   }else if(calc2.equals("/")) {
   
      nResult = num3 / num4;
   }
%>


첫번째수 : <%= num3%><br>
두번째수 : <%=num4 %><br>
결과는: <%=nResult %> <br>


</body>
</html>