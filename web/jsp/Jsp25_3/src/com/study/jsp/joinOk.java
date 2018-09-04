package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class joinOk implements Service {

	public joinOk() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request,
						HttpServletResponse response)
					throws ServletException, IOException 
	{
		System.out.println("joinOk");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		HttpSession session = request.getSession();


		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		
		dto.setId(request.getParameter("id"));
		dto.setPw(request.getParameter("pw"));
		dto.setName(request.getParameter("name"));
		dto.seteMail(request.getParameter("eMail"));
		dto.setAddress(request.getParameter("address"));

		dto.setrDate(new Timestamp(System.currentTimeMillis()));
		if (dao.confirmId(dto.getId()) == MemberDao.MEMBER_EXISTENT) {
			writer.println("<script>alert('아이디가  중복입니다..'); ");
			writer.println("javascript:window.location='join.jsp';</script>");
			writer.close();
			
		} else {
			int ri = dao.insertMember(dto);
			session.setAttribute("id", dto.getId());
			if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
				writer.println("<script>alert('회원가입을 축하 합니다..'); ");
				
				writer.println("javascript:window.location='login.jsp';</script>");
				writer.close();
				
				
			} else {
				writer.println("<script>alert('회원가입을 실패했습니다..'); ");
				writer.println("javascript:window.location='join.jsp';</script>");
				
				writer.close();
				
			}
		}

	}

}
