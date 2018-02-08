package com.brains.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo3 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 浏览器能接收(Accept)的数据类型有: 
		 * application/x-ms-application, 
		 * image/jpeg, 
		 * application/xaml+xml, 
		 * image/gif, 
		 * image/pjpeg, 
		 * application/x-ms-xbap, 
		 * application/vnd.ms-excel, 
		 * application/vnd.ms-powerpoint, 
		 * application/msword, 
		 */
		response.setHeader("Content-type", "image/jpeg");//使用content-type响应头指定发送给浏览器的数据类型为"image/jpeg"
		//读取位于项目根目录下的img文件夹下的一张图片
		InputStream inputStream = this.getServletContext().getResourceAsStream("/img/timg.jpg");
		byte[] buffer = new byte[1024];
		int len=0;
		OutputStream outputStream = response.getOutputStream();
		while((len = inputStream.read(buffer))!=-1) {//读取输入流(in)里面的内容存储到缓冲区(buffer)
			outputStream.write(buffer,0,len);//将缓冲区里面的内容输出到浏览器
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
