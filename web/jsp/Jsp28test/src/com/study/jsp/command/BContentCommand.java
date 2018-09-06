package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{	
		HttpSession session = null;
		String bId = request.getParameter("bId");
		String boardname= request.getParameter("board");
		BDao dao = BDao.getInstance();
		BDto dto = dao.contentView(bId);
		
		session = request.getSession();
		session.setAttribute("cboard",boardname);
		request.setAttribute("content_view", dto);
	}
	
}
