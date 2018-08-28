package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontCon() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doGet");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("doPost");
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("actionDo");

		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);
		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);
		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);

		if (command.equals("/joinOk.do")) {
			joinOk(request, response);
		} else if (command.equals("/loginOk.do")) {
			loginOk(request, response);
		} else if (command.equals("/modifyOk.do")) {
			modifyOk(request, response);
		} else if (command.equals("/logout.do")) {
			logout(request, response);
		}
	}

	public void loginOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("loginOk");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		PrintWriter writer = response.getWriter();

		MemberDao dao = MemberDao.getInstance();
		int checkNum = dao.userCheck(id, pw);

		if (checkNum == -1) {
			// html 출력
			writer.println("아이디가 존재하지 않습니다.");
			writer.close();
		} else if (checkNum == 0) {
			// html 출력
			writer.println("비밀번호가 틀립니다.");
			writer.close();
		} else if (checkNum == 1) {
			MemberDto dto = dao.getMember(id);

			if (dto == null) {
				writer.println("존재하지 않는 회원 입니다.");
				writer.close();
			} else {
				String name = dto.getName();

				HttpSession session = request.getSession();

				session.setAttribute("id", id);
				session.setAttribute("name", name);
				session.setAttribute("ValidMem", "yes");
				response.sendRedirect("main.jsp");
			}
		}
	}

	public void joinOk(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			writer.println("아이디가 이미 존재합니다.");
			writer.close();
		} else {
			int ri = dao.insertMember(dto);
			session.setAttribute("id", dto.getId());
			if (ri == MemberDao.MEMBER_JOIN_SUCCESS) {
				writer.println(" 회원가입을 축하 합니다..");
				response.sendRedirect("login.jsp");
				writer.close();
				
			} else {
				writer.println(" 회원가입을 실패했어요 ㅜㅜ..");
				writer.close();
				response.sendRedirect("join.jsp");
			}
		}
	}

	public void modifyOk(HttpServletRequest request, HttpServletResponse response)
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
			writer.println("alert(정보가 수정되었습니다..)");
			writer.println("</body></head></html>");
			response.sendRedirect("main.jsp");
			writer.close();	
		} else {
			writer.println("정보수정에 실패하였습니다.");
			response.sendRedirect("modify.jsp");
			writer.close();
			
		}
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		response.sendRedirect("login.jsp");
	}
}

