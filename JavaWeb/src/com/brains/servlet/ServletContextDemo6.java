package com.brains.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletContextDemo6 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/**
		 * response.setContentType("content-type", "text/html;charset=UTF-8");  目的是控制浏览器使用UTF-8进行解码
		 * 避免出现中文乱码的情况
		 */
		response.setHeader("content-type", "text/html;charset=UTF-8");
		readSrcDirPropCfgFile(response);//读取src目录下的properties配置文件
		response.getWriter().println("<hr/>");
		readWebRootDirPropCfgFile(response);//读取WebRoot目录下的properties配置文件
		response.getWriter().println("<hr/>");
		readPropCfgFile(response);//读取src目录下的db.config包中的db3.properties配置文件
		response.getWriter().println("<hr/>");
		readPropCfgFile2(response);//读取src目录下的gacl.servlet.study包中的db4.properties配置文件
		response.getWriter().println("<hr/>");
	}
	
	

	private void readWebRootDirPropCfgFile(HttpServletResponse response) throws IOException {
		/**
		 * 通过ServletContext对象读取WebRoot目录下的properties配置文件 “/”代表的是项目根目录
		 */
		InputStream in = this.getServletContext().getResourceAsStream("/db2.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("读取WebRoot目录下的db2.properties配置文件：");
		response.getWriter().print(
				MessageFormat.format("driver={0},url={1},username={2},password={3}", driver, url, username, password));

	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub  
		this.doGet(req, resp);
	}
	
	private void readSrcDirPropCfgFile(HttpServletResponse response) throws IOException {
		/**
		 * 通过ServletContext对象读取src目录下的db1.properties配置文件
		 */
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db1.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("读取src目录下的db1.properties配置文件：");
		response.getWriter().println(
				MessageFormat.format("driver={0},url={1},username={2},password={3}", driver, url, username, password));

	}
	
	/**
	 * 读取src目录下的com.brains.servlet中的db4
	 * @param response
	 * @throws IOException
	 */
	private void readPropCfgFile2(HttpServletResponse response) throws IOException{
		InputStream inputStream = this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/brains/servlet/db4.properties");
		Properties prop = new Properties();
		prop.load(inputStream);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("读取src目录下的com.brains.servlet包中的db4.properties配置文件：");
		response.getWriter().println(
		        MessageFormat.format(
		                "driver={0},url={1},username={2},password={3}", 
		                driver,url, username, password));
	}
	
	/**
	 * 读取src目录下的db.config包中的db3.properties配置文件
	 * @param response
	 * @throws IOException
	 */
	private void readPropCfgFile(HttpServletResponse response) throws IOException {
		// 通过ServletContext获取web资源的绝对路径
		/*String path = this.getServletContext().getRealPath("/WEB-INF/classes/db/config/db3.properties");
		InputStream in = new FileInputStream(path);*/
		InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/classes/db/config/db3.properties");
		Properties prop = new Properties();
		prop.load(in);
		String driver = prop.getProperty("driver");
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		response.getWriter().println("读取src目录下的db.config包中的db3.properties配置文件：");
		response.getWriter().println(
				MessageFormat.format("driver={0},url={1},username={2},password={3}", driver, url, username, password));

	}
}
