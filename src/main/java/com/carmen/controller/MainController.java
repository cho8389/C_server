package com.carmen.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.carmen.domain.MemberVO;
import com.carmen.domain.RoleVO;
import com.carmen.service.MemberService;
import com.carmen.service.ReqService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

@Controller
public class MainController {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private ReqService rs;
	
	@RequestMapping(value="/main",method=RequestMethod.GET)
	public void main(HttpSession session) throws Exception{
	}
	
	@RequestMapping(value="/m/main",method=RequestMethod.GET)
	public void mmain(HttpSession session,Model model) throws Exception{
		Gson gson=new Gson();
		MemberVO mem=(MemberVO) session.getAttribute("loginUser");
		session.setAttribute("emp_id",mem.getEmp_id());
	}
	
}
