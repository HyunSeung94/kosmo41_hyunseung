package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = null;
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String boardname= request.getParameter("board");
		BDao dao = BDao.getInstance();
		//System.out.println(boardname+"BWriteCommand1");
		
		session = request.getSession();
		
		session.setAttribute("cboard",boardname);
		//System.out.println(boardname+"BWriteCommand2");
		dao.Write(bName, bTitle, bContent,boardname);
	}

}
