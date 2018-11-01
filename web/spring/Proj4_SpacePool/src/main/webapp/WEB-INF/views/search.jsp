<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>SpacePool</title>
	
	<style>
		body {
		    font-family: "Lato", sans-serif;
		}
		
		.sidenav {
		    height: 100%;
		    width: 0;
		    position: fixed;
		    z-index: 1;
		    top: 0;
		    right: 0;
		    background-color: #111;
		    overflow-x: hidden;
		    transition: 0.5s;
		    padding-top: 60px;
		}
		
		.sidenav a {
		    padding: 8px 8px 8px 32px;
		    text-decoration: none;
		    font-size: 25px;
		    color: #818181;
		    display: block;
		    transition: 0.3s;
		}
		
		.sidenav a:hover {
		    color: #f1f1f1;
		}
		
		.sidenav .closebtn {
		    position: absolute;
		    top: 0;
		    right: 25px;
		    font-size: 36px;
		    margin-left: 50px;
		}
		
		@media screen and (max-height: 450px) {
		  .sidenav {padding-top: 15px;}
		  .sidenav a {font-size: 18px;}
		}
		
	</style>
	
	<script>
		function openNav() {
		    document.getElementById("mySidenav").style.width = "400px";
		}
		
		function closeNav() {
		    document.getElementById("mySidenav").style.width = "0";
		}
	</script>
</head>
<body>

<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="home">SpacePool</a>

    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsMain01">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="notice">공지사항&nbsp;&nbsp;&nbsp;&nbsp;<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="search">&nbsp;&nbsp;&nbsp;&nbsp;공간 검색&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="review">&nbsp;&nbsp;&nbsp;&nbsp;사용자 리뷰&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="help">&nbsp;&nbsp;&nbsp;&nbsp;도움말&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">ㅣ</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">&nbsp;&nbsp;&nbsp;공간 등록&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
        </ul>
    </div>
    <button class="btn btn-outline-secondary my-2 my-sm-0" type="button" onclick="openNav()">
       	<span class="navbar-toggler-icon"></span>
    </button>
</nav>

<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  	<ol class="carousel-indicators">
    	<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    	<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    	<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  	</ol>
  	<div class="carousel-inner">
    	<div class="carousel-item active">
      		<img class="d-block h-50 w-100" src="resources/images/slide1.jpg" alt="First slide">
    	</div>
    	<div class="carousel-item">
      		<img class="d-block h-50 w-100" src="resources/images/slide2.jpg" alt="Second slide">
    	</div>
    	<div class="carousel-item">
      		<img class="d-block h-50 w-100" src="resources/images/slide3.jpg" alt="Third slide">
    	</div>
  	</div>
  	<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    	<span class="carousel-control-prev-icon" aria-hidden="true"></span>
    	<span class="sr-only">Previous</span>
  	</a>
  	<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    	<span class="carousel-control-next-icon" aria-hidden="true"></span>
    	<span class="sr-only">Next</span>
  	</a>
</div>

<div id="mySidenav" class="sidenav">
  	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  	<a href="#">About</a>
  	<a href="#">Services</a>
  	<a href="#">Clients</a>
  	<a href="#">Contact</a>
</div>
	
	<div class="album py-5 bg-light">
        <div class="container">

          <div class="row">
            
             <c:forEach items="${hlist}" var="dto" >	   
	            <div class="col-md-4">
	              <div class="card mb-4 shadow-sm">
	              	<div class="thumbnail-wrapper"><img src="resources/images/hostImages/${dto.mFileName1}" style="width:100%;"></div>
	                <div class="card-body">
	                  <p class="card-text">${dto.hContent}</p>
	                  <div class="d-flex justify-content-between align-items-center">
	                    <div class="btn-group">
	                      <button type="button" class="btn btn-sm btn-outline-secondary">추천 ${dto.mReview}</button>
	                      <button type="button" class="btn btn-sm btn-outline-secondary">후기 ${dto.mVote}</button>
	                    </div>
	                    <small class="text-muted">${dto.hDate}</small>
	                  </div>
	                </div>
	              </div>
	            </div>
	          </c:forEach>
	          
          </div>
        </div>
      </div>
	

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    
</body>
</html>
