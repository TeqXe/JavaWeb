package com.brains.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String data = "abcdabcdabcdabcdabcdabcdab" + "cdabcdabcdabcdabcdabcdabcdabcdabc"
				+ "dabcdabcdabcdabcdabcdabcdabcdabc" + "dabcdabcdabcdabcdabcdabcdabcdabcdab"
				+ "cdabcdabcdabcdabcdabcdabcdabcdabcdab" + "cdabcdabcdabcdabcdabcdabcdabcdabcdab"
				+ "cdabcdabcdabcdabcdabcdabcdabcdabcdab" + "cdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
		
		System.out.println("原始数据的大小为："+ data.length());
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		GZIPOutputStream gzipOutputStream = new GZIPOutputStream(byteArrayOutputStream);//buffer
		gzipOutputStream.write(data.getBytes());
		gzipOutputStream.close();
		byte g[] = byteArrayOutputStream.toByteArray();//得到压缩后的数据
		response.setHeader("Content-Encoding", "gzip");
		response.setHeader("Content-Length", g.length+"");
		response.getOutputStream().write(g);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
