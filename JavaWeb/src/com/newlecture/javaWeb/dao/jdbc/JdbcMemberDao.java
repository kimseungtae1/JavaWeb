package com.newlecture.javaWeb.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.javaWeb.dao.MemberDao;
import com.newlecture.javaWeb.dao.NoticeDao;
import com.newlecture.javaWeb.entity.Member;
import com.newlecture.javaWeb.entity.Notice;
import com.newlecture.javaWeb.entity.NoticeView;

public class JdbcMemberDao implements MemberDao {

	@Override
	public Member get(String id) {
		Member m = null;
		
		String sql = "SELECT * FROM Member where id=?";
		
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
			       m = new Member();
	    		   rs.getString("id"); 
	    		   rs.getString("pwd"); 
	    		   rs.getString("name"); 
	    		   rs.getString("gender"); 
	    		   rs.getString("birthday"); 
	    		   rs.getString("phone"); 
	    		   rs.getString("email");
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
		
		return m;
	}
	
	@Override
	public int insert(String id, String pwd, String name, String phone, String email) {

		return insert(new Member(id, pwd ,name, null, null, phone, email));
	}

	@Override
	public int insert(Member member) {
		int result = 0;
		String sql = "INSERT INTO Member(id, pwd, name, gender, birthday, phone, email) VALUES(?, ?, ?, ?, ?, ?, ?)";
		
		String url = "jdbc:mysql://211.238.142.247/newlecture?autoReconnect=true&amp;useSSL=false&characterEncoding=UTF-8";
		
		// JDBC 드라이버 로드
		try {
				Class.forName("com.mysql.jdbc.Driver");
		
				// 연결 / 인증
			    Connection con = DriverManager.getConnection(url, "sist", "cclass");
		
			    // 실행
			    PreparedStatement st = con.prepareStatement(sql);
			    st.setString(1, member.getId());
			    st.setString(2, member.getPwd());
			    st.setString(3, member.getName());
			    st.setString(4, member.getGender());
			    st.setString(5, member.getBirthday());
			    st.setString(6, member.getPhone());
			    st.setString(7, member.getEmail());
			    
			    // 결과 가져오기 0보다 크면 업데이트된 로우값 나타나ㅁ
			    result = st.executeUpdate();
			    			    
			    st.close();
			    con.close();
			      
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
