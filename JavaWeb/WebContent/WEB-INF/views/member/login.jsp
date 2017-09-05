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
			
			<form method="post">
		         <fieldset>
		            <legend>회원정보</legend>
		            <table>
		               <tbody>
		                  <tr>
		                     <th><label>아이디</label></th>
		                     <td>
		                        <input name="id" value=""/>                        
		                     </td>
		                  </tr>
		                  <tr>
		                     <th><label>비밀번호</label></th>
		                     <td><input name="pwd" /></td>
		                  </tr>
		                  
		                  <tr>                     
		                     <td><input type="submit" name="btn" value="로그인" /></td>
		                  </tr>
		               </tbody>
		            </table>
		         </fieldset>
		      </form>
	
		</main>
		</div>
	</div>
	<!-- footer부분 -->
	<jsp:include page="../inc/footer.jsp"/>

</body>
</html>