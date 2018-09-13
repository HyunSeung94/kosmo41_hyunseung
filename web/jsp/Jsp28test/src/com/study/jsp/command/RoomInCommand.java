package com.study.jsp.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.room.RDao;



public class RoomInCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		HttpSession session = null;
		
		
		String id = request.getParameter("Memberid");
		String roomname = request.getParameter("roomname");

		RDao dao = RDao.getInstance();
		
		session = request.getSession();
//		String name = (String) session.getAttribute("name");
//		String Memberid = (String) session.getAttribute("id");
//		session.setAttribute("id", Memberid);
//		session.setAttribute("name", name);

		id = (String) session.getAttribute("id");
		session.setAttribute("id", id);
		session.setAttribute("roomname", roomname);
		System.out.println("roomname:"+ roomname);	
		System.out.println("id:"+ id);
//		System.out.println("position2:"+position);
//		
//		
//		System.out.println("roomid:"+rid);
//		System.out.println("roomname:"+roomname);
		dao.Roomin(id,roomname,request);
	}

}
