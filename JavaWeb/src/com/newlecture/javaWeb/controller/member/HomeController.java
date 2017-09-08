package com.newlecture.javaWeb.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newlecture.javaWeb.dao.MemberRoleDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcMemberRoleDao;


@WebServlet("/member/home")
public class HomeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Object _memberId = session.getAttribute("id");
		//1.로그인 한 적이 없다면 일단 로그인하러 가자
		if(_memberId==null) 
			response.sendRedirect("login?returnURL=home");//되돌아 오기 위한 상대경로는 간 페이지를 기준으로 한다. login을 기준으로 home은 같은 디렉토리
		else {
			String memberId = _memberId.toString();
			MemberRoleDao memberRoleDao = new JdbcMemberRoleDao();
			
			String defaultRole = memberRoleDao.getDefaultRoleId(memberId);
		//2. 다시 돌아가야되지
			
			if(defaultRole.equals("ROLE_ADMIN"))
				response.sendRedirect("../admin/index");
			else if(defaultRole.equals("ROLE_STUDENT"))
				response.sendRedirect("../stdent/index");
			else
				response.sendRedirect("../index");
		}
		//2. 로그인 하고 왔다면...
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
