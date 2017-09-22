package com.newlecture.javaWeb.dao;

import java.util.List;

import com.newlecture.javaWeb.entity.Notice;
import com.newlecture.javaWeb.entity.NoticeView;

public interface NoticeDao {
	//어짜피 인터페이스는 모두 퍼블릭이라서 퍼블릭이라고 하면 된다.
	List<NoticeView> getList(int page,String query);	
	int getCount();
	NoticeView get(String id);
	int update(String id, String title, String content);
}
