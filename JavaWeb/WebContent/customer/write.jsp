<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8"); 
	if(request.getMethod().equals("POST")){ //POST는 무조건 대문자로!
 		String status = request.getParameter("status");
		String btn = request.getParameter("btn");
		System.out.println(btn);
		
		if(btn.equals("세션저장")){ // 서버자원이용
			session.setAttribute("st", status);	
		}
		else if(btn.equals("쿠키저장")){ // 네트웍자원 이용 => 효율이 좋아져서 활용도가 증가하고있음
			Cookie cookie = new Cookie("st", status); //쿠키생성(키,값)
			cookie.setMaxAge(60*24); //유효시간 설정 60 = 60분
			response.addCookie(cookie); //쿠키 리스펀스에 저장
		}
		else if(btn.equals("어플리케이션저장")){
			application.setAttribute("st", status);
		}
	}

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<label>입력값</label><input name="status"/><br/>
		<input type="submit" name="btn" value="세션저장"/>
		<input type="submit" name="btn" value="쿠키저장"/>
		<input type="submit" name="btn" value="어플리케이션저장"/>
	</form>
	<div>
		<a href="view.jsp">상태 저장소로 가기</a>
	</div>
</body>
</html>