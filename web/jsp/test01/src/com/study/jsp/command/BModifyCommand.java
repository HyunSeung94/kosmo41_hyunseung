package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = null;
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String boardname= request.getParameter("board");
		
		System.out.println("BModifyCommand:" + boardname);
		session = request.getSession();
		session.setAttribute("cboard",boardname);
		BDao dao = BDao.getInstance();
		dao.modify(bId, bName, bTitle, bContent,boardname);
	}

}
