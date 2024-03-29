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

import com.proj4.spacepool.dao.HostContentDao;

@Controller
public class HostContentController {

	private static final Logger logger = LoggerFactory.getLogger(HostContentController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	private SqlSession sqlSession;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String board_search(Locale locale, Model model) {
		HostContentDao dao = sqlSession.getMapper(HostContentDao.class);
		model.addAttribute("hlist", dao.listHDao());
		return "search";
	}

}
