<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>작성자</td>
			<td>제목</td>
			<td>내용</td>
			<td>조회수</td>
		</tr>
		<tr>
		<td>${content_view.bId}</td>
		<td>${content_view.bName}</td>
		<td>${content_view.bTitle}</td>
		<td>${content_view.bContent}</td>
		<td>${content_view.bHit}</td>
		</tr>
		<tr>
			<td colspan="5">
			<a href="modify_view?bId=${content_view.bId}">수정</a>
				&nbsp;&nbsp; <a href="list">목록보기</a> &nbsp;&nbsp; <a
				href="delete?bId=${content_view.bId}">삭제</a> &nbsp;&nbsp; <a
				href="reply_view?bId=${content_view.bId}">답변</a></td>
		</tr>
	</table>
</body>
</html>