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

		//아이디 저장 
		String Rid = request.getParameter("Rid");
		String Roomname = request.getParameter("Roomname");
	


		RDao dao = RDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage);
		request.setAttribute("page", pinfo);
		nPage = pinfo.getCurPage();
		System.out.println("roomid:"+Rid);
		System.out.println("roomname:"+Roomname);
		

		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);


		

		ArrayList<RDto> dtos = dao.Rlist(nPage);
		request.setAttribute("Rlist", dtos);

	}

}
