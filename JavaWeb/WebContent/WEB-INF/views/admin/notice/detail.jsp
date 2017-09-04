<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<jsp:include page="../../customer/inc/visual.jsp"/>
	
	<div id="body" class="clearfix">
		<div class="content-container">
		
		<!-- aside부분 -->
		<jsp:include page="../../customer/inc/aside.jsp"/>
		
		

		
		<table class="table">
		<tr>
		<th>제목</th>
		<td colspan="3">${notice.title}</td>
		</tr>
		<tr> 
		<th>작성일</th>
		<td colspan="3">${notice.regDate}</td>
		</tr>
		<tr>
		<th >작성자</th>
		<td> ${notice.writerId}</td>
		<th>조회수</th>
		<td>${notice.hit}</td>
		</tr>
		<tr>
		<th>첨부파일</th>
		<td colspan="3"></td>
		</tr>
		<tr>
		<th>내용</th>
		<td colspan="4">${notice.content}</td>
		</tr> 
		
		
		</table>
		
		<div><!--get요청은 추가 옵션이 필요하다. 그럴떄는? 뒤에 넘길 값을 받을 것 get요청의 전달 값 = 쿼리스트링 id=${notice.id } 프로그램이 문서를 ㅁ나듦-->
		<a href="list" class="btn btn-default">목록으로 가기</a>
		<a href="edit?id=${notice.id }" class="btn btn-default">수정으로 가기</a>
		<a href="del" class="btn btn-default">삭제</a>
		</div>
		

	</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../../inc/footer.jsp"/>

</body>
</html>