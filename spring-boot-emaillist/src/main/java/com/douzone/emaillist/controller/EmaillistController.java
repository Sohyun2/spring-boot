package com.douzone.emaillist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmaillistVO;

@Controller
public class EmaillistController {
	
	@Autowired // EmaillistDao initiallize하는 방법
	private EmaillistDao emaillistDao;
	
	@RequestMapping({ "", "/list" })
	public String list(Model model) {
		model.addAttribute("list", emaillistDao.getList());
		
		//forwarding
		return "list";
	}
	
	@RequestMapping("/form")
	public String form() {
		return "form";
	}	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(@ModelAttribute EmaillistVO emaillistVO) {
		System.out.println(emaillistVO.toString());
		emaillistDao.insert(emaillistVO);
		
		//redirect
		return "redirect:/";
	}	
}
