package com.brains.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo1 extends HttpServlet {
	
	/**
	 * 定义ServletConfig 对象来接收配置的初始化参数
	 * 
	 */
	private ServletConfig config;
	
	/**
	 * 当servlet配置了初始化参数后，web容器在创建servlet实例对象时，
	 * 会自动将这些初始化参数封装到ServletConfig对象中，并在调用servlet的init方法时，
	 * 讲ServletConfig对象传递给servlet，进而，程序猿通过ServletConfig对象就额可以
	 * 得到昂前servlet的初始化参数信息
	 */
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("content-type", "text/html;charset=UTF-8");
		//获取在web.xml中配置的初始化参数
		String nameValue = config.getInitParameter("name");
		response.getWriter().print(nameValue);
		response.getWriter().print("<hr/>");
		
		//获取所有的初始化参数
		Enumeration<String> enumeration = config.getInitParameterNames();
		while(enumeration.hasMoreElements()) {
			String name = enumeration.nextElement();
			String value = config.getInitParameter(name);
			response.getWriter().print(name + " = " + value + " <br/>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		this.doGet(req, resp);
	}

}
