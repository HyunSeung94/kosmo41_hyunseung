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

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list}" var="dto" >
		<tr>
			<td>${dto.bId}</td>
			<td>${dto.bName}</td>
			<td>
				<c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
				<a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a>
			</td>
			<td>${dto.bDate}</td>
			<td>${dto.bHit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"><a href="write_view.do">글 작성</a></td>
		</tr>
		<tr align="center">
			<td colspan="5" >
				<c:choose>
					<c:when test="${(page.curPage-1)<1}">
						[<<]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=1">[<<]</a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${(page.curPage-1)<1}">
						[<]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage-1}">[<]</a>
					</c:otherwise>
				</c:choose>
				
				<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
					<c:choose>
						<c:when test="${(page.curPage)==num}">
							[${num}]
						</c:when>
						<c:otherwise>
							<a href="list.do?page=${num}">[${num}]</a>
						</c:otherwise>
					</c:choose> 
				</c:forEach>
				
				<c:choose>
					<c:when test="${(page.curPage+1)>page.totalPage}">
						[>]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.curPage+1}">[>]</a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${(page.curPage+1)>page.totalPage}">
						[>>]
					</c:when>
					<c:otherwise>
						<a href="list.do?page=${page.totalPage}">[>>]</a>
					</c:otherwise>
				</c:choose> 
			</td>
		</tr>
	</table>
	
	totalCount : ${page.totalCount}<br>
	listCount : ${page.listCount}<br>
	totalPage : ${page.totalPage}<br>
	curPage : ${page.curPage}<br>
	pageCount : ${page.pageCount}<br>
	startPage : ${page.startPage}<br>
	endPage : ${page.endPage}<br>
</body>
</html>