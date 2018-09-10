<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- client2를 대신해서 만든것 다수정하고 client2 지우면됨 -->
<%
	String id = (String) session.getAttribute("id");
	session.setAttribute("id", id);
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
	<div>
		사용자 아이디 : <%= id %>
	</div>
	<div>
		<input type ="text" id="messageinput"/>
	</div>
	<div>
		<button type="button" onclick="openSocket();">Open</button>
		<button type="button" onclick="send();">Send</button>
		<button type="button" onclick="closeSocket();">Close</button>
		<input type="button" onclick="javascript:window.location= 'list.do'" value=메인1>
	</div>
	<!--  Server responses get written here -->
	<div id="messages"></div>
	
	<!-- Script to utilise the WebSocket -->
	<script type="text/javascript">
		var webSocket;
		var messages = document.getElementById("messages");
		
		function openSocket(){
			//Ensures only one connection is open at a time
			if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED) {
				writeResponse("WebSocket is already opened.");
				return;
			}
			
			// Create a new instance of the websocket
			// webScoket = new WebSocket("ws://localhost/  *projectName*/echo");
			webSocket = new WebSocket("ws://localhost:8081/WebSocketEx/websocketendpoint2");
			
			/*
			Binds functions to the listeners for the websocket.
			*/
			webSocket.onopen = function(event) {
				// for reasons I can't determine, onopen gets called twice
				// and the first time event.data is undefined
				// Leave a comment if you know the answer.
				if (event.data === undefined)
					return ;
				
				writeResponse(event.data);
			};
			
			webSocket.onmessage = function(event) {
				writeResponse(event.data);
			};
			
			webSocket.onclose = function(event) {
				writeResponse("connection closed");
			};
		}
		
		/*
		* Sends the value of the text input to the server
		*/
		
		function send() {
			var id = "<%= id %>";
			var text = document.getElementById("messageinput").value;
			<% System.out.println("1234");%>
			webSocket.send(id +": "+text);
		}
		
		function closeSocket() {
			webSocket.close();
		}
		
		function writeResponse(text){
			messages.innerHTML += "<br>" + text;
		}
	</script>
</body>
</html>