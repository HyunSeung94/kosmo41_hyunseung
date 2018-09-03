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
		function form_check() {
		// 에디터의 내용이 textarea에 적용된다.
		oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
		document.write_form.submit();

	}
	</script>
</head>
<body>
	<div class="container">
		<table class="table table-bordered">
			<form name="write_form" action="write.do" method="post">
			<thead>
				<tr>
					<th scope="col" >이름</th>
					<td><input type="text" name="bName" size="50"></td>
				</tr>
				<tr>
					<th scope="col">제목</th>
					<td><input type="text" name="bTitle" size="50"></td>
				</tr>
				<tr>
					<th scope="col">내용</th>
					<td><textarea name="bContent" id="ir1" rows="10" cols="70">${content_view.bContent}</textarea>
						<script type="text/javascript">
							var oEditors = [];
							nhn.husky.EZCreator
									.createInIFrame({
										oAppRef : oEditors,
										elPlaceHolder : "ir1",
										sSkinURI : "./naver_editor/SmartEditor2Skin.html",
										fCreator : "createSEditor2"
									});
						</script>
				</tr>
				<tr>
					<td colspan="2" align="right"><a href="JavaScript:form_check();">입력</a>&nbsp;&nbsp;
						<a href="list.do">목록보기</a></td>
				</tr>
				</form>
			</thead>
		</table>
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