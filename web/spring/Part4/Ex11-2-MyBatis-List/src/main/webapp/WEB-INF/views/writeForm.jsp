<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="resources/naver_editor/js/service/HuskyEZCreator.js" charset="utf-8"></script>
</head>
<body>
	write.jsp
	<br />

	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<form action="write" method="post">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="bName" size="50"></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="bTitle" size="50"></td>
			</tr>
			<tr>
				<td> 내용 </td>
				<td> 
				 <textarea name="bContent" id="ir1" rows="10" cols="100">${content_view.bContent}</textarea>
					<script type="text/javascript">
						var oEditors = [];
						nhn.husky.EZCreator.createInIFrame({
							oAppRef : oEditors,
							elPlaceHolder : "ir1",
							sSkinURI : "resources/naver_editor/SmartEditor2Skin.html",
							fCreator : "createSEditor2"
						});
					</script>
			</tr>
		<tr>

			<td colspan="2"><input type="submit" value="입력">
				&nbsp;&nbsp; <a href="list">목록보기</a></td>
		</tr>
		</form>
	</table>
</body>
</html>