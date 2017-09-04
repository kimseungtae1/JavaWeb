<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="../../css/reset.css" type ="text/css" rel ="stylesheet">
<link href ="../../css/style.css" type ="text/css" rel ="stylesheet">
</head>
<body>   
	<!-- header부분 -->
	<jsp:include page="../../inc/header.jsp"/>
	<!-- visual부분 -->
	<jsp:include page="../inc/visual.jsp"/>
	
	<div id="body" class="clearfix">
		<div class="content-container">
		
		<!-- aside부분 -->
		<jsp:include page="../inc/aside.jsp"/>

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
				<th class="w60">번호</th>
				<th>제목</th>
				<th class="w100">작성자</th>
				<th class="w100">작성일</th>
				<th class="w60">조회수</th>
			</tr>
			<c:forEach var="n" items="${list}" >
				<tr>
					<td>${n.id}</td>
					<td class="title text-left text-indent"><a href="detail?id=${n.id}">${n.title}[${n.countCmt}]</a></td>
					<td>newLec</td>
					<td>${n.regDate}</td>
					<td>${n.hit }</td>
				</tr>
			</c:forEach>
		</table>		
		<c:set var="page" value="${param.p}"/>	<!--view에서도 파라미터에서 값을 탐색  -->
		<c:set var="startNum" value="${page-(page-1)%5}"/>
		<c:set var="lastNum" value="${fn:substringBefore((count%10 == 0 ? count/10 : count/10+1), '.')}"/><!-- 1항 ? 2항 : 3항  // 1항 참이면 2항, 1항 거짓이면 3항 -->
		<%-- <fn:substringBefore("23.45", ".")/> --%> <!-- 소수점을 기준으로 앞부분만 남기고 잘라버리겠다~! -->
		<div>
			<div><a href="?p=1">이전</a></div>
				<ul>
					<c:forEach var="i" begin="0" end="4">
						<!-- 현재 페이지 번호 오렌지색으로 표시 // 임시변수 이용!-->
						<c:set var="strong" value=""/>
						<c:if test="${page == startNum+i}">
							<c:set var="strong" value="text-strong"/><!-- text-strong은 style에 class이름임! -->
						</c:if>
						<c:if test="${startNum + i <= lastNum}">
							<li><a class="${strong}" href="?p=${startNum+i}">${startNum+i}</a></li>
						</c:if>
						
						<c:if test="${startNum + i > lastNum}">
							<li>${startNum+i}</li>
						</c:if>
					</c:forEach>
				</ul>
			<div>
				<c:if test="${lastNum >= startNum+5}">
				<a href="?p=${startNum+5}">다음</a>
				</c:if>
			</div>
		</div>
		<a class="btn btn-default" href="reg">글쓰기</a>
		<a class="btn btn-default" href="">취소</a>
		</main>
		</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../../inc/footer.jsp"/>

</body>
</html>