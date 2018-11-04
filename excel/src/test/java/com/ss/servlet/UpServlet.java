package com.ss.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.ss.util.GetData;
@WebServlet("/UpServlet")
@MultipartConfig
public class UpServlet extends HttpServlet{
	private GetData gd = new GetData();
	private static final long serialVersionUID = 5995465785263611576L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取到数据库的路径
		String path = gd.getFilePath().replace("\\", File.separator);
		System.out.println(path);
		Part part = req.getPart("file");
		String header = part.getHeader("content-disposition");
		String[] sp = header.split("=");
		String filename = sp[sp.length-1].replace("\"", "").trim();
		System.out.println(filename);
//		String[] fileFirstName = filename.split(".");
//		System.out.println(Arrays.toString(fileFirstName));
//		System.out.println(fileFirstName);
//		String a = fileFirstName[0];
		String endPath = path+filename;
		System.out.println(endPath);
//		System.out.println(filename);
//		String savePath = req.getSession().getServletContext().getRealPath("/");
//		System.out.println(savePath);
		part.write(endPath);
		String csvPath = gd.excelToCsv(endPath, filename);
		System.out.println(csvPath);
		gd.fileToData(csvPath);
		resp.getWriter().write("successful!");
	}

	
}
