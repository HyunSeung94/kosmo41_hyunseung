package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.study.room.RDao;


public class RBDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		String rid = request.getParameter("rid");
		String roomname = request.getParameter("roomname");
		System.out.println("rid:delete:"+rid);
		System.out.println("roomname:delete:"+roomname);
		
		RDao dao = RDao.getInstance();
		dao.delete(rid,roomname);
	}

}
