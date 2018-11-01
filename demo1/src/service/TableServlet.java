package service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetDao;
import dao.impl.GetDaoImpl;
import model.Admin;

@WebServlet("/main")
public class TableServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6749431210713989284L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		GetDao gd = new GetDaoImpl();
		//设定每页数据量
		Integer branches = 16;
		//获取总数据量
		Integer count = gd.getAllCount();
//		System.out.println(count);
		//获取总的分页页数
		Integer page = 0;
		if(count%branches==0){
			page = count/branches;
		}else{
			page = count/branches+1;
		}
		req.setAttribute("page", page);
		//获取当前页
		Integer pageNow = 1;
		String str = req.getParameter("num");
		if(str!=null){
			pageNow = Integer.parseInt(str);
		}
		req.setAttribute("pageNow", pageNow);
		
		List<Integer> li = new ArrayList<Integer>();
		Integer end = pageNow+2;
		Integer start = pageNow-1;
		if(end>=page){
			end = page;
			start = end-3;
		}
		if(start<=1){
			start = 1;
			end = 4;
		}
		for (int i = start; i <= end; i++) {
			li.add(i);
		}
		req.setAttribute("li", li);
		String sql = "SELECT * FROM t_user LIMIT ?,?;";
		//获取分页数据
		List<Admin> list = gd.getAll(sql, Admin.class, (pageNow-1)*branches,branches);
//		System.out.println(list);
		req.setAttribute("list", list);
		req.getRequestDispatcher("main.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
