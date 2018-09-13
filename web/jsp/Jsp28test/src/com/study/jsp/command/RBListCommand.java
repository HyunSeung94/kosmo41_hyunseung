package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.room.BPageInfo;
import com.study.room.RDao;
import com.study.room.RDto;

public class RBListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}
		HttpSession session = null;
		//아이디 저장 
		String Rid = request.getParameter("id");
		String Roomname = request.getParameter("Roomname");
		String roomlist = request.getParameter("roomlist");
		


		RDao dao = RDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage);
		request.setAttribute("page", pinfo);
		nPage = pinfo.getCurPage();
		
		
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		session.setAttribute("Rid", Rid);
		session.setAttribute("roomlist", roomlist);

		

		ArrayList<RDto> dtos = dao.Rlist(nPage);
		request.setAttribute("Rlist", dtos);		

	}

}
