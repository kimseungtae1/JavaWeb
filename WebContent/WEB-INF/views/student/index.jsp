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
	<jsp:include page="../customer/inc/visual.jsp"/>
	
	<div id="body" class="clearfix">
		<div class="content-container">
		
		<!-- aside부분 -->
		<jsp:include page="../student/inc/aside.jsp"/>
		
		<main id="main">
			<h2>관리자 Index페이지</h2>
		
		</main>
		
		</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>