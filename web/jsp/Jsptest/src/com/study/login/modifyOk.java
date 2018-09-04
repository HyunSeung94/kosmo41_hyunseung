package com.study.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.command.BCommand;

public class modifyOk implements Service {

	public modifyOk() {

	}

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) 
			throws ServletException, IOException {
		
		System.out.println("modifyOk");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
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
			writer.println("<html><head><body>");
			writer.println("정보가 수정되었습니다..");
			writer.println("</body></head></html>");
			response.sendRedirect("main.jsp");
			writer.close();	
		} else {
			writer.println("정보수정에 실패하였습니다.");
			response.sendRedirect("modify.jsp");
			writer.close();
			
		}

	}

}
