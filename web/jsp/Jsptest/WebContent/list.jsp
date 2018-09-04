<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
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
<script>
</script>
<style>
</style>
</head>
<body>
	<div class="container">
	<table class="table" >
		<thead class="thead-dark">
			<tr align = "center">
				<th scope="col">번호</th>
				<th scope="col">이름</th>
				<th scope="col">제목</th>
				<th scope="col">날짜</th>
				<th scope="col">히트</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="dto">
				<tr align = "center">
					<th scope="row">${dto.bId}</th>
					<td>${dto.bName}</td>
					<td><c:forEach begin="1" end="${dto.bIndent}">-</c:forEach> <a
						href="content_view.do?bId=${dto.bId}&page=$">${dto.bTitle}</a></td>
					<td>${dto.bDate}</td>
					<td>${dto.bHit}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align= "right"><a href="write_view.do">글작성</a></td>
			</tr>
			<tr>
				<td colspan="5" align = "center">
					<!-- 처음 --> 
					<c:choose>
						<c:when test="${(page.curPage-1)<1}">
							[처음]
						</c:when>
						<c:otherwise>
							<a href="list.do?page=1">[ 처음 ]</a>
						</c:otherwise>
						</c:choose>
						<!-- 이전 --> 
						<c:choose>
						<c:when test="${(page.curPage -1) < 1}">
							[ &lt; ]
						</c:when>
						<c:otherwise>
							<a href="list.do?page=${page.curPage -1}">[ &lt;]</a>
						</c:otherwise>
						</c:choose> 
						<!-- 개별 페이지 --> 
						<c:forEach var="num" begin="${page.startPage}"
						end="${page.endPage}" step="1">
						<c:choose>
						<c:when test="${page.curPage == num}">
            				[${num}] &nbsp;
            			</c:when>

						<c:otherwise>
							<a href="list.do?page=${num}">[${num}]</a> &nbsp;	
            			</c:otherwise>
						</c:choose>
						</c:forEach>
						<!-- 다음 -->
						<c:choose>
						<c:when test="${(page.curPage +1 ) > page.totalPage }">
							[ &gt; ]
						</c:when>
						<c:otherwise>
							<a href="list.do?page=${page.curPage +1 }">[ &gt;]</a>
						</c:otherwise>
						</c:choose>
					 	<!-- 끝 -->
					 	<c:choose>
						<c:when test="${page.curPage == page.totalPage}">
							[끝]
						</c:when>
						<c:otherwise>
							<a href="list.do?page=${page.totalPage}">[끝]</a>
						</c:otherwise>
						</c:choose>
					</td>
				</tr>
			</tbody>
		</table>

		
		<div id="searchForm" align="center">
			<form action = "search.do">
				<select name="search">
					<option value="0">제목</option>
					<option value="1">내용</option>
					<option value="2">작성자</option>
					<option value="3">제목+내용</option>
					<option value="all">전체</option>
				</select>
				<input type="text" size="20" name="condition"/> &nbsp;
				<input type="submit" value="검색" />
 			</form>
		</div>
		




	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->

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