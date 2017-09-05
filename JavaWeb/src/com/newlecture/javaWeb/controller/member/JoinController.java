package com.newlecture.javaWeb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaWeb.dao.MemberDao;
import com.newlecture.javaWeb.dao.NoticeDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcNoticeDao;
import com.newlecture.javaWeb.entity.Member;



@WebServlet("/member/join")
public class JoinController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/views/member/join.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String[] pwds = request.getParameterValues("pwd");
		if(!pwds[0].equals(pwds[1])) {
			response.sendRedirect("join?error=1");
		}
		String name = request.getParameter("name");
		String nicname = request.getParameter("nicname");
		String gender = request.getParameter("gender");
		String[] birthdays = request.getParameterValues("birthday");
		String birthday = birthdays[0] + "년" + birthdays[1] + "월" + birthdays[2] + "일";
		String isLunar = request.getParameter("is-lunar");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		
		System.out.printf("id:%s, pwd:%s, isLunar:%s\n", id, pwds[0], isLunar);
		MemberDao memberDao = new JdbcMemberDao();
		/*int result = memberDao.insert(id, pwds[0], name, gender, birthday, phone, email);*/ //직접 이렇게 쓸수도 있지만 새로운 member 객체를 만들어서 아래와 같이 할수도 있다.
		Member member = new Member(id, pwds[0], name, gender, birthday, phone, email);
		int result = memberDao.insert(member);
		
		if(result>0)
			response.sendRedirect("confirm");
		else
			response.sendRedirect("../error?code=1234");
	}
	
}
