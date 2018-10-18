package com.study.spring.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.study.spring.dao.BDao;
import com.study.spring.dto.BDto;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model)  
	{
		Map<String,Object> map= model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao =  new BDao();
//		BDao dao = BDao.getInstance();
		dao.Write(bName, bTitle, bContent);

	}

}
