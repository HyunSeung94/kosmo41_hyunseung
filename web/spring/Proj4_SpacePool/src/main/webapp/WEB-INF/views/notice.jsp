<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>SpcaePool</title>

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
function closeNav() {
    document.getElementById("mySidenav").style.width = "0";
}

	function openNav() {
	    document.getElementById("mySidenav").style.width = "400px";
	}
	
	
</script>

</head>
<body>
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <a class="navbar-brand" href="home">SpacePool</a>

    <div class="collapse navbar-collapse justify-content-md-center" id="navbarsMain01">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="notice">공지사항&nbsp;&nbsp;&nbsp;&nbsp;<span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="search">&nbsp;&nbsp;&nbsp;&nbsp;공간 검색&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="review">&nbsp;&nbsp;&nbsp;&nbsp;사용자 리뷰&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="help">&nbsp;&nbsp;&nbsp;&nbsp;도움말&nbsp;&nbsp;&nbsp;&nbsp;</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled">ㅣ</a>
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

<div id="mySidenav" class="sidenav">
  	<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  	<a href="#">About</a>
  	<a href="#">Services</a>
  	<a href="#">Clients</a>
  	<a href="#">Contact</a>
</div>

<table class="table table-striped container">
	<thead>
		<tr>
			<td colspan="5">
				<div class="container" style="border: 4px solid #555555; padding: 30px; margin-top: 50px; margin-bottom: 50px;" >
				공지사항 검색
					<div style="margin-top: 16px;">
						<form action="list.aa" align="center">
				            <input type="hidden" name=bnum value="${page.curBoard}" />
				            <div class="form-row">
					            <div class="col-10">
					            	<input class="form-control" type="text" name="condition" style="padding-left: 16px; padding-right: 16px;" placeholder="검색어를 입력해주세요."/>
					            </div>
					            <div class="col-2">
					            	<input type="submit" class="btn btn-dark" value="검색" />
					            </div>
				            </div>
				        </form>
					</div>			        
				</div>
			</td>
		</tr>
	</thead>
	<tbody style="border-top: 2px solid #555555; border-bottom: 2px solid #555555;">
		<c:forEach items="${mlist}" var="dto" >
		<tr>
			<c:choose>
				<c:when test="${dto.mBnum==0}">
					<td>리뷰</td>
				</c:when>
				<c:when test="${dto.mBnum==1}">
					<td>공지사항</td>
				</c:when>
				<c:when test="${dto.mBnum==2}">
					<td>도움말</td>
				</c:when>
			</c:choose>
			<td>
				<c:forEach begin="1" end="${dto.mIndent}">[RE:]</c:forEach>
				<a href="content_view.aa?bId=${dto.mId}">${dto.mTitle}</a>
			</td>
			<td>${dto.mDate}</td>
			<td>${dto.mHit}</td>
		</tr>
		</c:forEach>
		<thead>
			<tr align="right">
				<td colspan="5">
					<button type="button" class="btn btn-outline-primary" onclick="window.location.href='write_view.aa'">글 작성</button>
				</td>
			</tr>
		</thead>
		<thead>
		<tr>
			<td colspan="5" >
				<nav aria-label="...">
				  	<ul class="pagination justify-content-center">
				    	
				    	<c:choose>
							<c:when test="${(page.curPage)==1}">
								<li class="page-item disabled"><a class="page-link" ><<</a></li>
							</c:when>
							<c:when test="${ sessionScope.condition!=null }">
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=1&opt=<%=session.getAttribute("opt")%>&condition=<%=session.getAttribute("condition")%>"><<</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=1"><<</a></li>
							</c:otherwise>
						</c:choose>
				    	
				    	<c:choose>
							<c:when test="${(page.curPage)==1}">
								<li class="page-item disabled"><a class="page-link"><</a></li>
							</c:when>
							<c:when test="${ sessionScope.condition!=null }">
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${page.curPage-1}&opt=<%=session.getAttribute("opt")%>&condition=<%=session.getAttribute("condition")%>"><</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${page.curPage-1}"><</a></li>
							</c:otherwise>
						</c:choose>
				    	
				    	<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}">
							<c:choose>
								<c:when test="${(page.curPage)==num}">
									<li class="page-item active"><a class="page-link">${num}</a></li>
								</c:when>
								<c:when test="${ sessionScope.condition!=null }">
									<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${num}&opt=<%=session.getAttribute("opt")%>&condition=<%=session.getAttribute("condition")%>">[${num}]</a></li>
								</c:when>
								<c:otherwise>
									<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${num}">[${num}]</a></li>
								</c:otherwise>
							</c:choose> 
						</c:forEach>
						
						<c:choose>
							<c:when test="${(page.curPage)==page.totalPage}">
								<li class="page-item disabled"><a class="page-link">></a></li>
							</c:when>
							<c:when test="${ sessionScope.condition!=null }">
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${page.curPage+1}&opt=<%=session.getAttribute("opt")%>&condition=<%=session.getAttribute("condition")%>">></a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${page.curPage+1}">></a></li>
							</c:otherwise>
						</c:choose>
						
						<c:choose>
							<c:when test="${(page.curPage)==page.totalPage}">
								<li class="page-item disabled"><a class="page-link">>></a></li>
							</c:when>
							<c:when test="${ sessionScope.condition!=null }">
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${page.totalPage}&opt=<%=session.getAttribute("opt")%>&condition=<%=session.getAttribute("condition")%>">>></a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="list.aa?mbnum=${page.curBoard}&page=${page.totalPage}">>></a></li>
							</c:otherwise>
						</c:choose>
	
				  	</ul>
				</nav>
				
			</td>
		</tr>
		</thead>
	</tbody>
</table>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>

</body>
</html>