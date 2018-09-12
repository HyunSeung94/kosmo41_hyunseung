<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="./naver_editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script>

</script>
</head>
<body>
	<%
		
		String id = (String) session.getAttribute("id");
		String rid = (String) session.getAttribute("rid");
		String king = "king";
		session.setAttribute("position", king);
	%>
	<div class="container">
		<table class="table table-bordered">
					<form name="write_form" action="rwrite.do?rid=${id}"
						method="post">
						<thead>
							<tr>
								<th scope="col">방장</th>
								<td>${id}</td>
							</tr>
							<tr>
								<th scope="col">방제목</th>
								<td><input type="text" name="roomname" size="50"></td>
							</tr>
							<tr>
								<td colspan="2" align="right">
								<input type="submit" value="방 만들기">
								<a href="list_chat.do">방목록보기</a></td>
							</tr>
						</thead>
					</form>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
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