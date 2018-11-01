<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- jQuery  -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.5.6/firebase.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.4.0/firebase-app.js"></script>
<script src="https://www.gstatic.com/firebasejs/5.0.0/firebase-auth.js"></script>
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="210163008821-qejcedisnpd6njk117i2ucmddri6tefl.apps.googleusercontent.com">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script>
  // Initialize Firebase
  var config = {
    apiKey: "AIzaSyDwq6BBZhhqKz693OgZsXbeGZqS3jb-g7k",
    authDomain: "pro4-5b4e8.firebaseapp.com",
    databaseURL: "https://pro4-5b4e8.firebaseio.com",
    projectId: "pro4-5b4e8",
    storageBucket: "pro4-5b4e8.appspot.com",
    messagingSenderId: "210163008821"
  };
  firebase.initializeApp(config);
</script>

<!--google 로그인 및 회원가입 -->
<script>
var provider = new firebase.auth.GoogleAuthProvider();
provider.addScope('https://www.googleapis.com/auth/contacts.readonly');

function OAuth()
{
//구글 로그인
firebase.auth().signInWithPopup(provider).then(function(result) {
	  // This gives you a Google Access Token. You can use it to access the Google API.
	  var token = result.credential.accessToken;
	  // The signed-in user info.
	  var user = result.user;
	  // ...
	}).catch(function(error) {
	  // Handle Errors here.
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  // The email of the user's account used.
	  var email = error.email;
	  // The firebase.auth.AuthCredential type that was used.
	  var credential = error.credential;
	  // ...
	});
}

firebase.auth().getRedirectResult().then(function(result) {
	  if (result.credential) {
	    // This gives you a Google Access Token. You can use it to access the Google API.
	    var token = result.credential.accessToken;
	    // ...
	  }
	  // The signed-in user info.
	  var user = result.user;
	})
	.catch(function(error) {
	  // Handle Errors here.
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  // The email of the user's account used.
	  var email = error.email;
	  // The firebase.auth.AuthCredential type that was used.
	  var credential = error.credential;
	  // ...
	});
	
//구글 로그아웃
firebase.auth().signOut().then(function() {
	 // Sign-out successful.
	})
	.catch(function(error) {
	  // An error happened.
	});

</script>
<!-- email 로그인 및 회원가입 -->
<script>
function Email(){
	
	var email= "gustmd8593@naver.com";
	var password= "1234562";
	alert("bbbb:["+email+"]"+"["+password+"]");
	firebase.auth().createUserWithEmailAndPassword(email, password).catch(function(error) {
		  // Handle Errors here.
		  var errorCode = error.code;
		  var errorMessage = error.message;
		  // ...  
		});	 
}

</script>

</head>
<style>
body {
	padding: 2em;
}

/* Shared */
.loginBtn {
	box-sizing: border-box;
	position: relative;
	/* width: 13em;  - apply for fixed size */
	margin: 0.2em;
	padding: 0 15px 0 46px;
	border: none;
	text-align: left;
	line-height: 34px;
	white-space: nowrap;
	border-radius: 0.2em;
	font-size: 16px;
	color: #FFF;
}

.loginBtn:before {
	content: "";
	box-sizing: border-box;
	position: absolute;
	top: 0;
	left: 0;
	width: 34px;
	height: 100%;
}

.loginBtn:focus {
	outline: none;
}

.loginBtn:active {
	box-shadow: inset 0 0 0 32px rgba(0, 0, 0, 0.1);
}

/* Facebook */
.loginBtn--facebook {
	background-color: #4C69BA;
	background-image: linear-gradient(#4C69BA, #3B55A0);
	/*font-family: "Helvetica neue", Helvetica Neue, Helvetica, Arial, sans-serif;*/
	text-shadow: 0 -1px 0 #354C8C;
}

.loginBtn--facebook:before {
	border-right: #364e92 1px solid;
	background:
		url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_facebook.png')
		6px 6px no-repeat;
}

.loginBtn--facebook:hover, .loginBtn--facebook:focus {
	background-color: #5B7BD5;
	background-image: linear-gradient(#5B7BD5, #4864B1);
}

/* Google */
.loginBtn--google {
	/*font-family: "Roboto", Roboto, arial, sans-serif;*/
	background: #DD4B39;
}

.loginBtn--google:before {
	border-right: #BB3F30 1px solid;
	background:
		url('https://s3-us-west-2.amazonaws.com/s.cdpn.io/14082/icon_google.png')
		6px 6px no-repeat;
}

.loginBtn--google:hover, .loginBtn--google:focus {
	background: #E74B37;
}
</style>
<body>

		 <form name="eamilForm" id="eamilForm" >
		메일1 : <input type="text" name="email" id="email2" size="20"><br>	
		비밀번호22 : <input type="password" name="pw" id="pw2" size="20"><br>
		 <input type="reset" value="로그인" onclick="test()">
		<input type="button" id=login onClick="Email()" value="이메일회원가입">
		<button id=login2 onClick="Email()">이메일회원가입2</button>
		</form>	 
		
		<button id=login3 onClick="Email()" >이메일회원가입3</button>
		
	<button id='auth_button' class="g-signin2" data-theme="dark"
		onClick='OAuth()' type='button'>Auth</button>
	<!-- <input type="button" value="구글" onclick="firebase.initializeApp(config)"> -->
	<button class="loginBtn loginBtn--google" onClick='OAuth()'>
		Login with Google</button>

</body>
</html>