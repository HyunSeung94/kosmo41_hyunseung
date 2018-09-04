package com.study.jsp.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.BDao;
import com.study.jsp.BDto;
import com.study.jsp.command.BCommand;

public class modifyOk implements BCommand {

	public modifyOk() {

	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("modifyOk");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		BDao dao = BDao.getInstance();
		BDto dto = new BDto();
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		dto.setId(id);
		dto.setPw(request.getParameter("pw"));
		dto.seteMail(request.getParameter("eMail"));
		dto.setAddress(request.getParameter("address"));
		
		PrintWriter writer = response.getWriter();
		int ri = dao.updateMember(dto);
		System.out.println(ri);
		System.out.println("------111111------");
		if (ri == 1) {
			
			writer.println("<script>alert('회원정보를 수정했습니다.'); ");

			writer.println("javascript:window.location='main.jsp';</script>");
			writer.close();
		} else {
			writer.println("<script>alert('정보수정 실패했습니다..'); ");

			writer.println("javascript:window.location='login.jsp';</script>");
			writer.close();
			
		}

	}

}
