package com.study.jsp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.study.jsp.command.BCommand;
import com.study.jsp.command.BContentCommand;
import com.study.jsp.command.BDeleteCommand;
import com.study.jsp.command.BListCommand;
import com.study.jsp.command.BModifyCommand;
import com.study.jsp.command.BReplyCommand;
import com.study.jsp.command.BReplyViewCommand;
import com.study.jsp.command.BSearchCommand;
import com.study.jsp.command.BWriteCommand;
import com.study.jsp.command.BboardnameListCommand;
import com.study.jsp.command.joinOk;
import com.study.jsp.command.loginOk;
import com.study.jsp.command.modifyOk;

@WebServlet("*.do")
public class Frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Frontcontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		BCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		HttpSession session = null;
		session = request.getSession();
		int curPage = 1;
		if (session.getAttribute("cpage") != null) {
			curPage = (int) session.getAttribute("cpage");
		}

		if (com.equals("/joinOk.do")) {
			command = new joinOk();
			command.execute(request, response);
			return;
		} else if (com.equals("/loginOk.do")) {
			command = new loginOk();
			command.execute(request, response);
			return;
		} else if (com.equals("/modifyOk.do")) {
			command = new modifyOk();
			command.execute(request, response);
			return;
		} else if (com.equals("/logout.do")) {
			session = request.getSession();

			session.invalidate();
			viewPage="login.jsp";
			// logout(request, response);
		} else if (com.equals("/write_view.do")) {
			viewPage = "write_view.jsp";
		} else if (com.equals("/write.do")) {
			command = new BWriteCommand();
			command.execute(request, response);
			viewPage = "list.do";
		} else if (com.equals("/list.do")) {
			command = new BListCommand();
			command.execute(request, response);
			viewPage = "list.jsp";
		} else if (com.equals("/content_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if (com.equals("/modify_view.do")) {
			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "modify_view.jsp";
		} else if (com.equals("/modify.do")) {
			command = new BModifyCommand();
			command.execute(request, response);

			command = new BContentCommand();
			command.execute(request, response);
			viewPage = "content_view.jsp";
		} else if (com.equals("/delete.do")) {
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;
		} else if (com.equals("/reply_view.do")) {
			command = new BReplyViewCommand();
			command.execute(request, response);
			viewPage = "reply_view.jsp";
		} else if (com.equals("/reply.do")) {
			command = new BReplyCommand();
			command.execute(request, response);
			viewPage = "list.do?page=" + curPage;
		} else if (com.equals("/search.do")) {
			command = new BSearchCommand();
			command.execute(request, response);
			viewPage = "list_search.jsp";
		} else if (com.equals("/boardname.do")) {
			command = new BboardnameListCommand();
			command.execute(request, response);
			viewPage = "list.do";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		session.invalidate();
		response.sendRedirect("login.jsp");
	}

}
