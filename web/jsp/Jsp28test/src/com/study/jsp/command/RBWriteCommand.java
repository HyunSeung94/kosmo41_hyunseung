package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.room.RDao;



public class RBWriteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = null;
		
		String Rnum = request.getParameter("Rnum");
		String rid = request.getParameter("rid");
		String roomname = request.getParameter("roomname");
		String position= request.getParameter("position");
		System.out.println("position1:"+position);
		RDao dao = RDao.getInstance();
		
		session = request.getSession();
//		String name = (String) session.getAttribute("name");
//		String Memberid = (String) session.getAttribute("id");
//		session.setAttribute("id", Memberid);
//		session.setAttribute("name", name);

		session.setAttribute("rid", rid);
		session.setAttribute("roomname", roomname);
		position = (String) session.getAttribute("position");
//		System.out.println("position2:"+position);
//		System.out.println("roomid:"+rid);
//		System.out.println("roomname:"+roomname);
		dao.RWrite(rid,roomname,position,request);
		dao.Roomin(rid,roomname,request);
	}

}
