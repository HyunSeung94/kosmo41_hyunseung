package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class BSearchCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
	{
		int nPage = 1;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
			System.out.println("111");
		}
		
		
		String search = request.getParameter("search");
		String condition = request.getParameter("condition");
		
		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage,search,condition);
		request.setAttribute("page", pinfo);
		nPage = pinfo.getCurPage();
		
		
		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		
		session.setAttribute("search",search);
		session.setAttribute("condition",condition);
		
		
		
		ArrayList<BDto> dtos = dao.list(nPage,search,condition);
		request.setAttribute("list", dtos);
	}

}
