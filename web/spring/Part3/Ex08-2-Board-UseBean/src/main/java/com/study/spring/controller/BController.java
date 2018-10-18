package com.study.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.spring.command.BCommand;
import com.study.spring.command.BContentCommand;
import com.study.spring.command.BDeleteCommand;
import com.study.spring.command.BListCommand;
import com.study.spring.command.BModifyCommand;
import com.study.spring.command.BReplyCommand;
import com.study.spring.command.BReplyViewCommand;
import com.study.spring.command.BWriteCommand;

@Controller
public class BController {
	
	@Autowired
	private ApplicationContext context;
	
	BCommand command = null;
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
//		command= new BListCommand();
		command = context.getBean(BListCommand.class);
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request,Model model) {
		System.out.println("write()");
		
		model.addAttribute("request", request);
//		command= new BWriteCommand();
		
//		 class를 호출하는 방법 
	   //command = context.getBean(BWriteCommand.class);
		
		// board.xml에 빈등록후 빈호출 방법
		command = (BWriteCommand) context.getBean("writeHandler");
		command.execute(model);
		
		return "redirect:list";
	}
	@RequestMapping("/content_view")
	public String content_view(HttpServletRequest request,Model model) {
		System.out.println("content_view()");
		
		model.addAttribute("request", request);
//		command= new BContentCommand();
		
//		 class를 호출하는 방법 
//		command = context.getBean(BContentCommand.class);
		
		// board.xml에 빈등록후 빈호출 방법
		command = (BCommand) context.getBean("contentHandler");

		command.execute(model);	
		return "content_view";
	}
	@RequestMapping("/modify_view")
	public String modify_view(HttpServletRequest request,Model model) {
		System.out.println("modify_view()");
		
		model.addAttribute("request", request);
//		command= new BContentCommand();
		command = context.getBean(BContentCommand.class);
		command.execute(model);	
		return "modify_view";
	}
	@RequestMapping("/modify")
	public String modify(HttpServletRequest request,Model model) {
		System.out.println("modify()");
		model.addAttribute("request", request);
//		command= new BModifyCommand();
		// 클래스 호출
		//command = context.getBean(BModifyCommand.class);
		
		// board.xml에 빈등록후 빈호출 방법
		command = (BModifyCommand) context.getBean("modifyHandler");
		command.execute(model);	
		
//		command= new BContentCommand();
		command = context.getBean(BContentCommand.class);
		command.execute(model);	
		return "content_view";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,Model model) {
		System.out.println("delete()");
		model.addAttribute("request", request);
//		command= new BDeleteCommand();
		// 클래스 호출
//		command = context.getBean(BDeleteCommand.class);
		
		// board.xml에 빈등록후 빈호출 방법
		command = (BDeleteCommand) context.getBean("deleteHandler");
		command.execute(model);	
		
		return "redirect:list";
	}
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		System.out.println("reply_view()");
		model.addAttribute("request", request);
		
//		command= new BReplyViewCommand();
		// 클래스 호출
//		command = context.getBean(BReplyViewCommand.class);
		
		// board.xml에 빈등록후 빈호출 방법
		command = (BReplyViewCommand) context.getBean("replyViewHandler");
		command.execute(model);	
		
		return "reply_view";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request,Model model) {
		System.out.println("reply()");
		model.addAttribute("request", request);
//		command= new BReplyCommand();
		// 클래스 호출 
		command = context.getBean(BReplyCommand.class);
		
		command.execute(model);	
		//보정해야함
		return "redirect:list";
	}
	@RequestMapping("/write_view")
	public String write_view(Model model) {
		System.out.println("write_view()");
		command.execute(model);
		
		return "write_view";
	}
	
}
