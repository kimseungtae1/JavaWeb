package com.newlecture.javaWeb.controller.admin.notice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.javaWeb.dao.NoticeDao;
import com.newlecture.javaWeb.dao.jdbc.JdbcNoticeDao;
import com.newlecture.javaWeb.entity.Notice;

@WebServlet("/admin/notice/list")
public class NoticeListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인증한 적이 있는지 없다면 로그인하고와
		//돌아왔으면 인증정보 줘봐.. 그걸로 역할이 있는지 보자
		
		//없다면 에러 - 권한없음 페이지로 간다
		
		String _title = request.getParameter("title");
		String _page = request.getParameter("p"); 
		//3�������
		//notice?title = aa : title="aa"
		//notice?title = 	: title=""
		//notice			: title=null
		
		int page = 1;	//�������̵� ��� �⺻��
		//1page���� �Ѱ� ���� ��� get
		if(_page != null && !_page.equals(""))//���� ���� ��
			page = Integer.parseInt(_page);
				
		//int offset = (page-1)*10;
		String title = "";//�⺻��

		
		if(_title != null && !_title.equals(""))
			title = _title;
		
		NoticeDao noticeDao = new JdbcNoticeDao();//context.getDao("noticedao");

		
		
		request.setAttribute("list", noticeDao.getList(page,title));
		request.setAttribute("count", noticeDao.getCount());
		
		request.getRequestDispatcher("/WEB-INF/views/admin/notice/list.jsp").forward(request, response);
	}
}
