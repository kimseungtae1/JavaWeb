package com.newlecture.javaWeb.dao;

import java.util.List;

import com.newlecture.javaWeb.entity.Notice;
import com.newlecture.javaWeb.entity.NoticeView;

public interface NoticeDao {
	//��¥�� �������̽��� ��� �ۺ��̶� �ۺ��̶�� �ϸ� �ȴ�.
	List<NoticeView> getList(int page,String query);	
	int getCount();
	NoticeView get(String id);
	int update(String id, String title, String content);
}
