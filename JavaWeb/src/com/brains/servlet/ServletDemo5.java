package com.brains.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo5 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 设置 content-disposition响应头，让浏览器下载文件
		 */
		response.setHeader("content-disposition", "attachment;filename=demo5.jpg");
		InputStream inputStream = this.getServletContext().getResourceAsStream("/img/timg.jpg");
		OutputStream outputStream = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = 0;
		while((len = inputStream.read(b))!=-1) {
			outputStream.write(b,0,len);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		this.doGet(req, resp);
	}

}
