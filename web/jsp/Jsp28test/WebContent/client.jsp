<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery.js"></script>
<!-- Required meta tags -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous">
</script>
</head>
<style>
html, body {
	margin: 0;
	padding: 0; `
	height: 100%;
}

.header {
	width: 100%;
	height: 20%;
}

.left {
	width: 30%;
	height: 70%;
	float: left;
}

.center {
	width: 35%;
	height: 70%;
	float: left;
}

.aside {
	width: 35%;
	height: 70%;
	float: right;
	/* background:#008B8B; */
}

.footer {
	width: 100%;
	height: 10%;
	clear: both;
	background: plum;
}
</style>
<script>
      $(document).ready(function(){
         $('#messageinput').keypress(function(e){
            if(e.which == 13){
               $(this).blur();                     
               $('#button1').focus().click();   //엔터로 버튼 누르기
               $('#messageinput').focus();      //텍스트에 포커스
               
            }            
         });   
      });
      
   </script>
<body>

	<!-- client2를 대신해서 만든것 다수정하고 client2 지우면됨 -->
	<%
		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);
		String roomname = (String) session.getAttribute("roomname");
		session.setAttribute("roomname", roomname);
	%>

	<%-- <%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");


	if(id == null){
%>
	<jsp:forward page="login.jsp" />
<%
	} else {	
		session.setAttribute("uid", id);
	}
%> --%>
	<br>
	<br>
	<div class="header" align="left">
		<%
			if (roomname == null) {
		%>

		<h3 align="center">대기실 입니다.</h3>

		<%
			} else {
		%>
		<h3><%=roomname%>
			방입니다.
		</h3>
		<%
			}
		%>
	</div>



	<div class="aside" style="border: 1px solid black">
	<div class="container">
		<%
			if ((String) session.getAttribute("roomlist") == null) {
		%>

		  <!--  <iframe src="list_chat.jsp" id=listchat width="100%" height="400px" frameborder="0" marginwidth="0"></iframe> -->
		  <jsp:include page="list_chat.jsp" />

		<%
			}
			session.removeAttribute("roomlist");
			session.removeAttribute("roomname");
		%>
	
	</div>
	</div>
	<div class="left">
	<div>
			<button type="button" onclick="openSocket();"
				class="btn btn-outline-secondary">Open</button>
			<!-- <button type="button" onclick="send();">Send</button> -->
			<button type="button" onclick="closeSocket();"
				class="btn btn-outline-secondary">Close</button>	
			<input class="btn btn-outline-secondary" type="button"
				onclick="javascript:window.location= 'list.do'" value=메인>
			<input class="btn btn-outline-secondary" type="button" name="roomlist"
				onclick="javascript:window.location= 'list_chat.do'"
				value="방리스트">
				<button class="btn btn-outline-secondary" type="button" onclick="roomgo();">초대</button>
				<button class="btn btn-outline-secondary" type="button" onclick="alllist();">전체리스트</button>
				<button class="btn btn-outline-secondary" type="button" onclick="myroomlist();">내방리스트</button>
				<button class="btn btn-outline-secondary" type="button" onclick="roomout();">추방</button>
			 <%-- <input class="btn btn-outline-secondary" type="button" onclick="javascript:window.location='roomgo?id=<%=id%>&roomname=<%=roomname%>'"
			value="초대"> --%>
			
	</div>
	 	
		<!-- 	<div class="row">
				&nbsp;&nbsp;&nbsp;&nbsp;<div class="col-sm-4" style="border: 1px solid black" align="center" ><h>전체 접속자</h></div>&nbsp;

				<div class="col-sm-4" style="border: 1px solid black" align="center">대기실 접속자</div>&nbsp;&nbsp;&nbsp;&nbsp;
			</div> -->
		</div> 

	</div>
	<!--  Server responses get written here -->
	<div class="center">

		<div>
			<textarea id="messages" cols="50" rows="20" readonly
				class="container"></textarea>
		</div>

		사용자 아이디1 :
		<%=id%>
		, 룸 :
		<%=roomname%>
		<%
			System.out.println("roomname1:" + roomname);
		%>
		<div>
			<input type="text" id="messageinput" />
			<button type="button" onclick="send();" id="button1" class="btn btn-outline-secondary"
				>Send</button>
		</div>

		
	</div>

	<footer class="footer">footer</footer>

	<!-- Script to utilise the WebSocket -->
	<script type="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");
		
		function openSocket(){
			
			if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			
			webSocket = new WebSocket("ws://localhost:8081/Jsp28test/websocketendpoint2");
			
			
			
			webSocket.onopen = function(event) {		
				/* sendin();  */		
				<%if (roomname == null) {
				System.out.println("roomname2:" + roomname);%>
				waiting();
				
				<%} else {
				System.out.println("roomname3:" + roomname);%>
				send();
				
				<%}%>
				
				if (event.data === undefined)
					return ;
				
				writeResponse(event.data);
				
			};
			
			webSocket.onmessage = function(event) {
				writeResponse(event.data);
				
			};
			
			webSocket.onclose = function(event) {
				/* sendin(); */
				 send();
				writeResponse("connection closed");
			};
		}
		function roomout() {
			var id = "<%=id%>"; 
			var text = document.getElementById("messageinput").value;
			text = "/roomout";
			webSocket.send(id + " : " +text);
		}
		
		function alllist() { //전체리스트
			var id = "<%=id%>"; 
			var text = document.getElementById("messageinput").value;
			text = "/alllist";
			webSocket.send(id + " : " +text);		
		}
		function myroomlist() { //전체리스트
			var id = "<%=id%>"; 
			var text = document.getElementById("messageinput").value;
			text = "/myroomlist";
			webSocket.send(id + " : " +text);		
		}
		
		function send() {
			var id = "<%=id%>";
			var text = document.getElementById("messageinput").value;
			
		/* 	if(id==null){
				webSocket.send(text);
			} else */
			 
			webSocket.send(id + " : " +text);
			messageinput.value="";
			
		}
		
	 	function sendin() {
			var id = "<%=id%>";
			
			webSocket.send(id);
		}
		
	 	function waiting(){
	 		var id = "<%=id%>"; 
			var waitingroom = "waitingroom";
			text = waitingroom;
			webSocket.send(id + " : " + waitingroom);
		}
		function closeSocket() {
			webSocket.close();
		}

		function writeResponse(text) {
			/* messages.innerHTML += "<br>" + text; */
			messages.innerHTML += text + "\n";

			var objDiv = document.getElementById("messages"); //스크롤 하단내리기
			objDiv.scrollTop = objDiv.scrollHeight;
		}

/* 		window.onload = function() { //새창일때 바로 오픈소켓
			openSocket();
		} 난안됨  */
		
	</script>

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