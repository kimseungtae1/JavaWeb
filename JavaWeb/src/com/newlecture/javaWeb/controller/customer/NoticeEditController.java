package com.newlecture.javaWeb.controller.customer;

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

@WebServlet("/customer/notice-edit")
public class NoticeEditController extends HttpServlet{
	
	
	
	
	
	
	
	/*특화된 함수를 오버라이드를 가능함.*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String id= request.getParameter("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		/*String sql = "UPDATE Notice SET title= ?,content=? where id=?";
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		// JDBC 드라이버 로드
		try {
				Class.forName("com.mysql.jdbc.Driver");
		
				// 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");
		
			    // 실행
			    PreparedStatement st = con.prepareStatement(sql);

			    st.setString(1, title);
			    st.setString(2, content);
			    st.setString(3, id);
			    
			    // 결과 가져오기 0보다 크면 업데이트된 로우값 나타나ㅁ
			    int result = st.executeUpdate();
			    			    
			      
			      st.close();
			      con.close();
			      
			    System.out.println("db닫히고 확인");
			    //System.out.println(title);
				System.out.println(id);
			      
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		NoticeDao noticeDao = new JdbcNoticeDao();
		int result = noticeDao.update(id,title,content);
		
		response.sendRedirect("notice-detail?id="+id);
		
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String id = request.getParameter("id");

		
	/*	List<Notice> list = null;*/
		Notice n = null;

		String sql = "SELECT * FROM Notice where id=?";
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		// JDBC 드라이버 로드
		try {
				Class.forName("com.mysql.jdbc.Driver");
		
				// 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");
		
			    // 실행
			    PreparedStatement st = con.prepareStatement(sql);

			    st.setString(1, id);
			    
			    // 결과 가져오기
			    ResultSet rs = st.executeQuery();
			    
			    // Model => 출력된 데이터 
			    
			      
			    // 결과 사용하기
			    if (rs.next()) {
			       n = new Notice();
			       n.setId(rs.getString("ID"));
			       n.setTitle(rs.getString("TITLE"));
			       n.setWriterId(rs.getString("writerId"));
			       n.setContent(rs.getString("content"));
			       n.setHit(rs.getInt("hit"));
			       //..
			         
			       /*list.add(n);*/
			    }
			      rs.close();
			      st.close();
			      con.close();
			      
/*			    System.out.println("db닫히고 확인");
			    //System.out.println(title);
				System.out.println(id);*/
			      
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("notice", n);
		
		request.getRequestDispatcher("/WEB-INF/views/customer/notice/edit.jsp").forward(request, response);
	}
}
