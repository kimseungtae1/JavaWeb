package com.newlecture.javaWeb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaWeb.dao.MemberDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcMemberDao;
import com.newlecture.javaWeb.entity.Member;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDao memberDao = new JdbcMemberDao();
		
		Member member = memberDao.get(id);
		
		if(member == null)
			response.sendRedirect("login?error");
		else if(!member.getPwd().equals(pwd))
			response.sendRedirect("login?error");
		else { 
			request.getSession().setAttribute("id", id);
			
			response.sendRedirect("../index");
		}
	}
}
