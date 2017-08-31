<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="../css/reset.css" type ="text/css" rel ="stylesheet">
<link href ="../css/style.css" type ="text/css" rel ="stylesheet">
</head>
<body>   
	<!-- header부분 -->
	<jsp:include page="../../inc/header.jsp"/>
	<!-- visual부분 -->
	<jsp:include page="../../customer/inc/visual.jsp"/>
	
	<div id="body" class="clearfix">
		<div class="content-container">
		
		<!-- aside부분 -->
		<jsp:include page="../../customer/inc/aside.jsp"/>

		<main id= "main">
		<h2 class="main title">공지사항</h2>
		
		<div>
			<h3>경로</h3>
			<ol>
				<li><a href="">home</a></li>
				<li><a href="">고객센터</a></li>
				<li><a href="">공지사항</a></li>
			</ol>
		</div>

		<div>
			<h3>공지사항 검색 폼</h3>
			<form action="hello">
				<label>검색어</label>
				<input type="text" name="title"/>
				<input type="submit"/>
			</form>
		</div>
		<table class="table table-list">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="n" items="${list}" >
				<tr>
					<td class="w60">${n.id }</td>
					<td class="title"><a href="notice-detail?id=${n.id }">${n.title }</a></td>
					<td class="w100">newLec</td>
					<td class="w100">${n.regDate }</td>
					<td class="w100">${n.hit }</td>
				</tr>
			</c:forEach>
		</table>
		<c:set var="page" value="${param.p}"/>	<!--view에서도 파라미터에서 값을 탐색  -->
		<c:set var="startNum" value="${page-(page-1)%5 }"/>
		<c:set var="lastNum" value="${count/10}"/>
		${lastnum}
		<div>
			<div><a href="?p=1">이전</a></div>
				<ul>
					
					<c:forEach var="i" begin="0" end="4">
						<li><a href="?p=${startNum+i}">${startNum+i}</a></li>
					</c:forEach>
				</ul>
			<div><a href="?p=6">다음</a></div>
		</div>
		<a class="btn btn-default" href="notice-reg">글쓰기</a>
		<a class="btn btn-default" href="">취소</a>
		</main>
	</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../../inc/footer.jsp"/>

</body>
</html>