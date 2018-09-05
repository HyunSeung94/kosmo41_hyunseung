package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.jsp.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String boardname= request.getParameter("board");
		BDao dao = BDao.getInstance();
		
		System.out.println(boardname+"BWriteCommand");
		dao.Write(bName, bTitle, bContent,boardname);
	}

}
