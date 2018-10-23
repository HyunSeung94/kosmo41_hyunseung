package com.study.spring.dao;

import java.util.ArrayList;

import com.study.spring.dto.ContentDto;


public interface IDao {

	public ArrayList<ContentDto> listDao();
	public void writeDao(String bName, String bTitle, String bContent);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
	public ContentDto content_view(String bId,String bName, String bTitle, String bConten,String bHit);
	public void modify_view(String bId);
	public void modify(String bId,String bName,String bTitle,String bContent);
	public String reply_view(String bid);
	public String reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent);
	public void replyShape(String strGroup, String strStep);
}
