package com.newlecture.javaWeb.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaWeb.dao.NoticeDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcNoticeDao;



@WebServlet("/member/agree")
public class AgreeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/views/member/agree.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String _agree = request.getParameter("agree");
		//�⺻��ó��
		String agree="no";
		if(_agree != null && !_agree.equals(""))
			agree = _agree;
			
		if(!agree.equals("ok"))
			response.sendRedirect("agree?error=1"); //���ϴ� ���ǰ���� �޶�� �Ͽ��µ� �����Ͽ���. 1�ܶ� �Ȱ��̱� ������ ���Ӱ� redirect�� �ؾ��Ѵ�
		else
			response.sendRedirect("join");
	}
}
