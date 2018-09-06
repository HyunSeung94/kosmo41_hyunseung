<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
</head>
<body>

<%
			String boardname = request.getParameter("board");
			
			session.setAttribute("cboard", boardname);
			System.out.println("content_View :"+ boardname);
			%>
	<div class="container">
	<table class="table table-bordered" >
  	<thead>
		<tr>
			<th scope=row align="center">번호</th>
			<td>${content_view.bId}</td>
		</tr>
		<tr>
			<th scope=row align="center">히트</th>
			<td>${content_view.bHit}</td>
		</tr>
		<tr>
			<th scope=row align="center">이름</th>
			<td>${content_view.bName}</td>
		</tr>
		<tr>
			<th scope=row align="center">제목</th>
			<td >${content_view.bTitle}</td>
		</tr>
		<tr>
			<th scope=row align="center">내용</th>
			<td colspan="3">${content_view.bContent}</td>
		</tr>
		<tr align="right">
			<td colspan="2"><a href="modify_view.do?bId=${content_view.bId}&board=${cboard}">수정</a>&nbsp;&nbsp;
				<a href="list.do?page=<%=session.getAttribute("cpage")%>">목록보기</a>&nbsp;&nbsp;
				<a href="delete.do?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; <a
				href="reply_view.do?bId=${content_view.bId}">답변</a></td>
		</tr>
	</table>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
</body>
</html>