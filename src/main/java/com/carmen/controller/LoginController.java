package com.carmen.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carmen.domain.MemberVO;
import com.carmen.domain.RoleVO;
import com.carmen.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService ms;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public void login() throws Exception {
	}
	
	@RequestMapping(value="/m/login",method=RequestMethod.GET)
	public void mlogin() throws Exception {
	}
	
	@RequestMapping(value="/test",method=RequestMethod.POST)
	@ResponseBody
	public MemberVO test(HttpSession session) throws Exception {
		return ms.selectmem("test");
	}
	
	@RequestMapping(value="/loginRequest",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String loginreuqest(LoginRequest loginReq,HttpSession session,HttpServletRequest request) throws Exception {
		
		String msg="";
		
		MemberVO mem=ms.selectmem(loginReq.getUid());
		
		if(mem!=null){
			if(loginReq.getUpwd().equals(mem.getEmp_pw())){
				//로그인 성공
				session.setAttribute("loginUser", mem);
				session.setAttribute("role",ms.selectrole(mem.getEmp_id()));
				msg="0";
			}else{// 패스워드 불일치
				msg="1";
			}
		}else{//아이디 부재...
			msg="2";
		}
		return msg;
	}
	
	@RequestMapping(value="/loginmain",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	public String loginmain(Device device,HttpSession session) throws Exception{
		String url="";
		if(session.getAttribute("loginUser")!=null) {
			if(device.isMobile()) {
				url="redirect:/m/main";
			}else {
				url="redirect:/main";
			}
		}else {
			if(device.isMobile()) {
				url="redirect:/m/login";
			}else {
				url="redirect:/login";
			}
		}
		return url;
	}
	
	@RequestMapping(value="/logincheck",method=RequestMethod.GET,produces="text/html;charset=utf-8")
	public String logincheck(Device device,HttpSession session) throws Exception{
		String url="";
		MemberVO mem=ms.selectmem((String) session.getAttribute("loginUser"));
		session.setAttribute("loginUser", mem);
		session.setAttribute("role",ms.selectrole(mem.getEmp_id()));
		
		if(device.isMobile()) {
			url="redirect:/m/main";
		}else {
			url="redirect:/main";
		}
		return url;
	}
	
	@RequestMapping(value="/clogin/loginRequest",method=RequestMethod.POST,produces="text/html;charset=utf-8")
	@ResponseBody
	public String clogin(LoginRequest loginReq,HttpSession session,HttpServletRequest request) throws Exception {
		
		String msg="";
		
		MemberVO mem=ms.selectmem(loginReq.getUid());
		
		if(mem!=null){
			if(loginReq.getUpwd().equals(mem.getEmp_pw())){
				//로그인 성공
				session.setAttribute("loginUser", mem);
				session.setAttribute("role",ms.selectrole(mem.getEmp_id()));
				msg="0";
			}else{// 패스워드 불일치
				msg="1";
			}
		}else{//아이디 부재...
			msg="2";
		}
		return msg;
	}
	
	@RequestMapping(value="/getmem/{id}",method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getmem(@PathVariable("id")String id){
		ResponseEntity<Map<String, Object>> entity = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			MemberVO mem = ms.selectmem(id);
			List<RoleVO> role=ms.selectrole(id);
			map.put("mem",mem);
			map.put("role",role);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return entity;
	}
	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public String logout(HttpSession session)throws Exception{
				
		session.invalidate();
				
		return "redirect:/m/login";
	}
}
