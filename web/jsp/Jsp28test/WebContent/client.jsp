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
		<h3>대기실 입니다.</h3>		
	</div>


	<!--  Server responses get written here -->
	<div>
	<textarea id="messages" cols="40" rows="10" readonly class="section"></textarea>
	</div>
사용자 아이디 : <%= id %>
		<div>
		<input type ="text" id="messageinput" />
		<button type="button" onclick="send();"   id="button1">Send</button>
	</div>
	
	<div>
		<button type="button" onclick="openSocket();">Open</button>
		<!-- <button type="button" onclick="send();">Send</button> -->
		<button type="button" onclick="closeSocket();">Close</button>
		<input type="button" onclick="javascript:window.location= 'list.do'" value=메인>
		<input type="button" onclick="javascript:window.location= 'list_chat.do'" value=방리스트>
	</div>
	
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
				 sendin(); 
				/* send(); */
				if (event.data === undefined)
					return ;
				
				writeResponse(event.data);
				
			};
			
			webSocket.onmessage = function(event) {
				writeResponse(event.data);
				
			};
			
			webSocket.onclose = function(event) {
				sendin();
				/* send(); */
				writeResponse("connection closed");
			};
		}
		
	
		
		function send() {
			var id = "<%= id %>";
			var text = document.getElementById("messageinput").value;
			
			if(id==null){
				webSocket.send(text);
			} else
			 
			webSocket.send(id + " : " +text);
			messageinput.value="";
			
		}
		
	 	function sendin() {
		var id = "<%= id %>";
		webSocket.send(id);
		} 
		
		function closeSocket() {
			webSocket.close();
		}
		
		function writeResponse(text){
			/* messages.innerHTML += "<br>" + text; */
			messages.innerHTML += text +"\n";
			
			 var objDiv = document.getElementById("messages");    //스크롤 하단내리기
	            objDiv.scrollTop = objDiv.scrollHeight;
		}
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