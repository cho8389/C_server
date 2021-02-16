package com.carmen.security;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.carmen.dao.impl.MemberDAOImpl;

public class CLoginSuccessHandler extends 
			 SavedRequestAwareAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws ServletException, IOException {
		
		String loginUser=authentication.getName();		
		
		String accept=request.getHeader("accept");
			
			response.setContentType("application/json;charset=utf-8");
			String data = StringUtils.join(new String[]{
					"{\"response\":{","\"error\":false,",
					"\"message\" : \"로그인하였습니다.\",",
					" \"userid\" : \"",loginUser,"\"",
					"}}"
					});
			PrintWriter out=response.getWriter();
			out.print(data);
			out.flush();
			out.close();			
		
		
		
		
	}

	
}
