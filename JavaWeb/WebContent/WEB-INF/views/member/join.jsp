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
	<jsp:include page="../inc/header.jsp"/>
	<!-- visual부분 -->
	<jsp:include page="inc/visual.jsp"/>
	
	<div id="body" class="clearfix">
		<div class="content-container">
		
		<!-- aside부분 -->
		<jsp:include page="inc/aside.jsp"/>
		<main id= "main">
		<h2 class="main title">회원가입</h2>
		
		<div>
			<h3>경로</h3>
			<ol>
				<li><a href="">home</a></li>
				<li><a href="">고객센터</a></li>
				<li><a href="">공지사항</a></li>
			</ol>
		</div>
		<a class="btn btn-default" href="notice-reg">글쓰기</a>
		<a class="btn btn-default" href="">취소</a>
		</main>
		
		<div><!--get요청은 추가 옵션이 필요하다. 그럴떄는? 뒤에 넘길 값을 받을 것 get요청의 전달 값 = 쿼리스트링 id=${notice.id } 프로그램이 문서를 ㅁ나듦-->
		<a href="notice-list" class="btn btn-default">목록으로 가기</a>
		<a href="notice-edit?id=${notice.id }" class="btn btn-default">수정으로 가기</a>
		<a href="notice-del" class="btn btn-default">삭제</a>
		</div>
		

	</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>