package com.study.jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CalcEx")
public class CalcEx extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{

		
		request.setCharacterEncoding("UTF-8");
		
		String num1 = request.getParameter("number01");
		String num2 = request.getParameter("number02");
		String calc2 = request.getParameter("calc");	
		
		int num3 = Integer.parseInt(num1);
		int num4 = Integer.parseInt(num2);
		int nResult = 0;
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
					
		
		if(calc2.equals("+")) {
			
			nResult = num3 + num4;
					
		}else if(calc2.equals("-")) {
			
			nResult = num3 - num4;
		
		}else if(calc2.equals("*")) {
		
			nResult = num3 * num4;
		
		}else if(calc2.equals("/")) {
			
			nResult = num3 / num4;
		}
		writer.println("<html><head></head><body>");
		writer.println("첫번째수 : " + num3 + "<br>");
		writer.println("두번째수 : " +	num4 + "<br>");
		
		writer.println("결과는: " + nResult + " 입니다. <br>");
		writer.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		
		
	}

}
