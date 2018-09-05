//package com.study.jsp.command;
//
//import java.util.ArrayList;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.study.jsp.BDao;
//import com.study.jsp.BDto;
//import com.study.jsp.BPageInfo;
//
//public class BboardnameListCommand implements BCommand {
//
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) 
//	{
//		int nPage = 1;
//		String boardname = null;
//		try {
//			String sPage = request.getParameter("page");
//			nPage = Integer.parseInt(sPage);
//		} catch (Exception e) {
//		}
//		
////		HttpSession session = null;
////		session = request.getSession();
////		
//		
//		String search = request.getParameter("search");
//		String condition = request.getParameter("condition");
//
//		
//		//게시판 구분
//
//		//String boardname = request.getParameter("table");
//
//				
//
//		
//		BDao dao = BDao.getInstance();
//		BPageInfo pinfo = dao.articlePage(nPage,search,condition);
//		request.setAttribute("page", pinfo);
//		
//		
//		nPage = pinfo.getCurPage();
//		
//		HttpSession session = null;
//		session = request.getSession();
//		session.setAttribute("cpage", nPage);
//
//
//		boardname = request.getParameter("boardname");		
//	
//		session.setAttribute("board", boardname);
//		//boardname = (String) session.getAttribute("boardname");
//		
////		session.invalidate();
//		
//		
//		System.out.println(boardname+"BboardnameListCommand");
//		
//		
//		ArrayList<BDto> dtos = dao.boardlist(nPage,search,condition,boardname);
//		request.setAttribute("list", dtos);
//		
//		
//		
//		
//		
//		
//			
//		
//	}
//
//}
