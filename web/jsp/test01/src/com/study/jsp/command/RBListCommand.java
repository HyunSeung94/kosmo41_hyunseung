package com.study.jsp.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.BPageInfo;

public class RBListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int nPage = 1;
		String boardname= null;
		try {
			String sPage = request.getParameter("page");
			nPage = Integer.parseInt(sPage);
		} catch (Exception e) {
		}

		//아이디 저장 
		String Memberid = request.getParameter("id");
		// 게시판 검색 저장
		String search = request.getParameter("search");
		String condition = request.getParameter("condition");
		// 게시판 구분

		boardname = request.getParameter("board");
		

		BDao dao = BDao.getInstance();
		BPageInfo pinfo = dao.articlePage(nPage, search, condition, boardname);
		request.setAttribute("page", pinfo);
		nPage = pinfo.getCurPage();
		
		

		HttpSession session = null;
		session = request.getSession();
		session.setAttribute("cpage", nPage);
		session.setAttribute("cboard", boardname);

		// 세션이 저장되서 검색페이징처리가 됨
		session.setAttribute("search", search);
		session.setAttribute("condition", condition);
		

		ArrayList<BDto> dtos = dao.list(nPage, search, condition, boardname);
		request.setAttribute("list", dtos);

	}

}
