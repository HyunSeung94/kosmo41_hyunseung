package com.study.spring;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.spring.dao.IDao;
import com.study.spring.dto.ContentDto;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	   ContentDao dao;

//	   @Autowired
//	   public void setDao(ContentDao dao) {
//	      this.dao = dao;
//	   }
	
	// log4j.xml로들어가라 src/main/resources에 있음
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private SqlSession sqlSession;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
//		ArrayList<ContentDto> dtos = dao.listDao();
		IDao dao= sqlSession.getMapper(IDao.class);
		model.addAttribute("list",dao.listDao());
		
		return "/list";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		
		return "/writeForm";
	}
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.writeDao(request.getParameter("bName"), request.getParameter("bTitle"),request.getParameter("bContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/view")
	public String view() {
		return "/view";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.deleteDao(request.getParameter("bId"));
		return "redirect:list";
	}
	
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.upHit(request.getParameter("bId"));
		model.addAttribute("content_view",dao.content_view(request.getParameter("bId"),request.getParameter("bName"), request.getParameter("bTitle"),request.getParameter("bContent"),request.getParameter("bHit")));
		return "/content_view";
	}
	
	@RequestMapping("modify_view")
	public String modify_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("content_view",dao.content_view(request.getParameter("bId"),request.getParameter("bName"), request.getParameter("bTitle"),request.getParameter("bContent"),request.getParameter("bHit")));
		return "/modify_view";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.modify(request.getParameter("bId"),request.getParameter("bName"), request.getParameter("bTitle"),request.getParameter("bContent"));
		return "redirect:list";
	}
	
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("reply_view",dao.content_view(request.getParameter("bId"),request.getParameter("bName"), request.getParameter("bTitle"),request.getParameter("bContent"),request.getParameter("bHit")));
		return "reply_view";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.replyShape(request.getParameter("bGroup"),request.getParameter("bStep"));
		dao.reply(request.getParameter("bId"),request.getParameter("bName"),request.getParameter("bTitle"),request.getParameter("bContent"),request.getParameter("bGroup"),request.getParameter("bStep"),request.getParameter("bIndent"));
		return "redirect:list";
	}
	
//	@RequestMapping("/replyShape")
//	public String replyShape(HttpServletRequest request, Model model) {
//		IDao dao = sqlSession.getMapper(IDao.class);
//		dao.replyShape(request.getParameter("bGroup"),request.getParameter("bStep"));
//		return "redirect:list";
//	}
	
}
