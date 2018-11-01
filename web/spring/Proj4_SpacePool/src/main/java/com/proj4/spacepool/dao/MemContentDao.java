package com.proj4.spacepool.dao;

import java.util.ArrayList;

import com.proj4.spacepool.dto.MemContentDto;

public interface MemContentDao {
	
	//게시판
	public ArrayList<MemContentDto> listMDao(int mBnum);
	public void writeMDao(String mName, String mTitle, String mContent);
	public MemContentDto contentViewMDao(String mId);
	public void deleteMDao(String mId);
	public void upHitMDao(String mId);
	public void modifyMDao(String mId, String mName, String mTitle, String mContent);
	public MemContentDto reply_viewMDao(String str);
	public void replyMDao(String mId, String mName, String mTitle, String mContent, String mGroup, String mStep, String mIndent);
	public void replyShapeMDao(String mGroup, String mStep);
	

	//호스트 M자리에 H

	
	//댓글 M자리에 C
}
