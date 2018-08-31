<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table width ="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var = "dto">
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view.do?bId=${dto.bId}&page=$">${dto.bTitle}</a></td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		
		<tr>
			<td colspan="5"> 
			<a href="write_view.do">글작성</a>
			
			<a href="">처음</a>
			<a href="">이전</a>
			
			<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
            <a href="list.do?page=${num}">[${num}]</a>
            </c:forEach> 
			
			<a href="">다음</a>
			<a href="">끝</a>
			</td>
		</tr>
	</table>
	
	totalCount : ${page.totalCount}<br>
	listCount : ${page.listCount }<br>
	totalPage : ${page.totalPage }<br>
	curPage : ${page.curPage }<br>
	pageCount : ${page.pageCount }<br>
	startPage : ${page.startPage }<br>
	endPage : ${page.endPage }<br>
	
</body>
</html>