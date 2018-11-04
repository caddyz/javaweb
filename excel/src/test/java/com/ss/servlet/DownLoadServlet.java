package com.ss.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ss.util.GetData;
@WebServlet("/DownLoadServlet")
public class DownLoadServlet extends HttpServlet{
	private GetData gd = new GetData();
	private static final long serialVersionUID = 401371019460342848L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取数据库下载
		gd.exportFile("demo");
		resp.getWriter().write("下载成功");
	}

	
}
