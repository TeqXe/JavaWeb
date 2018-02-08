package com.brains.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo4 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设置refresh响应头，让浏览器每隔3s定时刷新
		 * response.setHeader("refresh"."3");
		 * 
		 * 设置refresh响应头，让浏览器3s后跳转到https://www.baidu.com
		 */
		
		response.setHeader("refresh", "3;url='https://www.baidu.com'");
		response.getWriter().write("3s later jump to www.baidu.com");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		this.doGet(req, resp);
	}

}
