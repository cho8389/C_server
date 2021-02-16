package com.carmen.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSocketController {
	@RequestMapping(value="/chat",method=RequestMethod.GET)
	public String chat() {
		/*mv.setViewName("chat/chattingview");
		User user=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mv.addObject("userid",user.getUsername());
		return mv;*/
		return "/chat";
	}
}
