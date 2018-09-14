<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

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
	<%
		String name = (String) session.getAttribute("name");
		String Memberid = (String) session.getAttribute("id");
		String Roomname = (String) session.getAttribute("Roomname");
		String Rid = (String) session.getAttribute("Rid");
		session.setAttribute("id", Memberid);
		session.setAttribute("name", name);
		session.setAttribute("Rid", Rid);
		session.setAttribute("Roomname", Roomname);

		System.out.println("listname :" + name);
		System.out.println("listID :" + Memberid);
	%>


	<br>
	<br>
	<div></div>


	<div align="center">
		<!-- <a class="btn btn-outline-secondary" href="client.jsp">대기실입장</a> -->
		<%
			if ((String) session.getAttribute("id") != null) {
		%>

		<%
			}
		%>
	</div>
	<br>

	<%
		if (name != null) {
	%>
	<h5 align="center">방리스트 입니다.</h5>
	<h6 align="right"><%=Memberid%>님 안녕하세요.</h6>

		<form action="logout.do" method="get" align="right">
			<input type="submit" value="로그아웃" class="btn btn-outline-secondary">&nbsp; <input
				type="button" value="정보수정" class="btn btn-outline-secondary"
				onclick="javascript:window.location= 'modify.jsp'">
		</form>
	</h5>
	<%
		} else if (name == null) {
	%>
	<h5 align="right">
		<a class="btn btn-outline-secondary" href="login.jsp">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a class="btn btn-outline-secondary" href="join.jsp">회원가입</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</h5>

	<%
		}
	%>

	<hr>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
				<tr align="center">
					<th scope="col">번호</th>
					<th scope="col">방장</th>
					<th scope="col">방제목</th>
					<th scope="col">방삭제여부</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${Rlist}" var="dto">
					<tr align="center">
						<th scope="row">${dto.rnum}</th>
						<td>${dto.rid}</td>
						<td><a href="room_view.do?roomname=${dto.roomname}">${dto.roomname}</a></td>
						<td><c:choose>
								<c:when test="${dto.rid == id}">
									<a href="deleteroom.do?rid=${dto.rid}&roomname=${dto.roomname}">삭제</a>
								</c:when>
							</c:choose></td>

					</tr>
				</c:forEach>
				<tr>
					<%
						if ((String) session.getAttribute("id") != null) {
					%>
					<td colspan="5" align="right"><a href="rwrite_view.do">방만들기</a></td>
					<%
						}
					%>
				</tr>
				<tr>
					<td colspan="5" align="center">
						<div>
							<c:choose>
								<c:when test="${(page.curPage-1)<1}">
							[처음]
						</c:when>
								<c:otherwise>
									<a href="list_chat.do?page=1">[ 처음 ]</a>
								</c:otherwise>
							</c:choose>
							<!-- 이전 -->
							<c:choose>
								<c:when test="${(page.curPage -1) < 1}">
							[ &lt; ]
						</c:when>
								<c:otherwise>
									<a href="list_chat.do?page=${page.curPage -1}">[ &lt;]</a>
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
										<a href="list_chat.do?page=${num}">[${num}]</a> &nbsp;	
            			</c:otherwise>
								</c:choose>
							</c:forEach>
							<!-- 다음 -->
							<c:choose>
								<c:when test="${(page.curPage +1 ) > page.totalPage }">
							[ &gt; ]
						</c:when>
								<c:otherwise>
									<a href="list_chat.do?page=${page.curPage +1 }">[ &gt;]</a>
								</c:otherwise>
							</c:choose>
							<!-- 끝 -->
							<c:choose>
								<c:when test="${page.curPage == page.totalPage}">
							[끝]
						</c:when>
								<c:otherwise>
									<a href="list_chat.do?page=${page.totalPage}">[끝]</a>
								</c:otherwise>
							</c:choose>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
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