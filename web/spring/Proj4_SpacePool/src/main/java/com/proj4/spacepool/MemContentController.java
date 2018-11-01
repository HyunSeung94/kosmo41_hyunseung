package com.proj4.spacepool;

import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.proj4.spacepool.dao.MemContentDao;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemContentController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemContentController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		return "home";
	}
	
	@RequestMapping(value = "/home2", method = RequestMethod.GET)
	public String home2(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		return "home2";
	}
	
	@RequestMapping(value = "/notice", method = RequestMethod.GET)
	public String board_notice(Locale locale, Model model) {
		MemContentDao dao = sqlSession.getMapper(MemContentDao.class);
		model.addAttribute("mlist", dao.listMDao(1));
		
		return "notice";
	}
	
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String board_review(Locale locale, Model model) {
		
		return "review";
	}
	
	@RequestMapping(value = "/help", method = RequestMethod.GET)
	public String board_help(Locale locale, Model model) {
		
		return "help";
	}
	
}
