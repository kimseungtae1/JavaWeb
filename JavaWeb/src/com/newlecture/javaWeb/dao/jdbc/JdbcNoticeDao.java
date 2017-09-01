package com.newlecture.javaWeb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.javaWeb.dao.NoticeDao;
import com.newlecture.javaWeb.entity.Notice;
import com.newlecture.javaWeb.entity.NoticeView;

public class JdbcNoticeDao implements NoticeDao {
				//매개변수가 있으면 필수변수가 앞으로
	public List<NoticeView> getList(int page,String query) {
		
		List<NoticeView> list = null;
		
		String sql = "SELECT * FROM NoticeView where title like ? order by regDate DESC  limit ?,10";
	
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		int offset = (page-1)*10;
		
		// JDBC 드라이버 로드
		try {
				Class.forName("com.mysql.jdbc.Driver");
		
				// 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");
		
			    // 실행
			    PreparedStatement st = con.prepareStatement(sql);
			    st.setString(1, "%" + query + "%");
			    st.setInt(2, offset);

			    // 결과 가져오기
			    ResultSet rs = st.executeQuery();
			    
			    // Model => 출력된 데이터 
			    list = new ArrayList<>();
			      
			    // 결과 사용하기
			    while (rs.next()) {
			       NoticeView n = new NoticeView();
			       n.setId(rs.getString("id"));
			       n.setTitle(rs.getString("title"));
			       n.setWriterId(rs.getString("writerId"));
			       n.setWriterName(rs.getString("writerName"));
			       n.setContent(rs.getString("content"));
			       n.setHit(rs.getInt("hit"));
			       n.setCountCmt(rs.getInt("countCmt"));
			         
			       list.add(n);
			    }
			      rs.close();
			      st.close();
			      con.close();
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int getCount() {
		
		int count = 0;
		
		String sqlCount = "SELECT count(id) count FROM Notice";
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		// JDBC 드라이버 로드
		try {
				Class.forName("com.mysql.jdbc.Driver");
		
				// 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");
		
			    // 실행
			    PreparedStatement st = con.prepareStatement(sqlCount);
			    ResultSet rs = st.executeQuery();
			    rs.next();
			    count = rs.getInt("count");

			    // Model => 출력된 데이터 
			    rs.close();	
			    st.close();
			    con.close();
						
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	
	@Override
	public NoticeView get(String id) {
		
		NoticeView n = null;
		
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
			       n = new NoticeView();
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
			      
			    System.out.println("db닫히고 확인");
			    //System.out.println(title);
				System.out.println(id);
			      
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return n;
	}

	@Override
	public int update(String id, String title, String content) {
		// TODO Auto-generated method stub
		int result =0;
		String sql = "UPDATE Notice SET title= ?,content=? where id=?";
		
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
			    result = st.executeUpdate();
			    			    
			      
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
		}
		
		return result;
	}

}
