package com.newlecture.javaWeb.controller.admin.notice;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

import com.newlecture.javaWeb.entity.Notice;

@WebServlet("/admin/notice/reg")
public class NoticeRegController extends HttpServlet{
	/*특화된 함수를 오버라이드를 가능함.*/
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		/*String id= request.getParameter("id");*/
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		String sql = "INSERT INTO Notice(id,title,content,writerId) VALUES((select ifnull(MAX(CAST(id AS UNSIGNED)),0)+1 from Notice n),?,?,?)";
		
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
			    st.setString(3, "newlec");
			    
			    // 결과 가져오기 0보다 크면 업데이트된 로우값 나타나ㅁ
			    int result = st.executeUpdate();
			    			    
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
		
		response.sendRedirect("notice-list");	
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");//물음표가 아니라 중국어가 나오는 경우는 type을 모르고있다는 뜻
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter(); // 출력도구
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id") == null)
			out.write("<script>alert('로그인이 필요합니다.');location.href='../../member/login?returnURL=../admin/notice/reg';</script>");
		
		else
			request.getRequestDispatcher("/WEB-INF/views/admin/notice/reg.jsp").forward(request, response);
	}
}
