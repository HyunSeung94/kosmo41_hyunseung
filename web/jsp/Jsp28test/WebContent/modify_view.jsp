<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="./naver_editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
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
	function form_check() {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
		document.modify_form.submit();

	}
</script>
<body>
			<%
			String boardname = request.getParameter("board");
			String Memberid = (String) session.getAttribute("id");
			String name = (String) session.getAttribute("name");
			
			session.setAttribute("id", Memberid);
			session.setAttribute("name", name);
			session.setAttribute("cboard", boardname);
			System.out.println("modify_view :"+ boardname);
			%>

	<div class="container">
		<table class="table table-bordered">
			<% if (boardname.equals("")){ %>
		<thead>
				<form name="modify_form" action="modify.do" method="post">
			
			
			<% } else if (!boardname.equals("")){
			%>
			<thead>
				<form name="modify_form" action="modify.do?board=${cboard}" method="post">
		
	  <%
	  }
	  %>
			<<!-- thead>
				<form name="modify_form" action="modify.do" method="post"> -->
					<input type="hidden" name="bId" value="${content_view.bId }">
					<tr>
						<th scope=row >번호</th>
						<td>${content_view.bId}</td>
					</tr>
					<tr>
						<th scope=row >히트</th>
						<td>${content_view.bHit}</td>
					</tr>
				<tr>
					<th scope=row >이름</th>
					<td><input type="text" name="bName"
						value="${content_view.bName}"></td>
				</tr>
				<tr>
					<th scope=row >제목</th>
					<td><input type="text" name="bTitle"
						value="${content_view.bTitle}"></td>
				</tr>
				<tr>
					<th scope=row >내용</th>
					<td><textarea name="bContent" id="ir1" rows="10" cols="80">${content_view.bContent}</textarea>
						<script type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator.createInIFrame({
										oAppRef : oEditors,
										elPlaceHolder : "ir1",
										sSkinURI : "./naver_editor/SmartEditor2Skin.html",
										fCreator : "createSEditor2"
									});
						</script></td>
				</tr>

					<td colspan="2" align="right"><a href="JavaScript:form_check();">수정완료 </a>&nbsp;&nbsp;
					<a href="content_view.do?bId=${content_view.bId}">취소</a>
					&nbsp;&nbsp; <a
					href="list.do?page=<%=session.getAttribute("cpage")%>">목록보기</a>&nbsp;&nbsp;
					</td>




				
				</form>
		</table>

		<!-- Bootstrap CSS -->
		<link rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
			integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
			crossorigin="anonymous">

		<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
			integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
			crossorigin="anonymous"></script>
</body>
</html>