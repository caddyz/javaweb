package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.impl.CheckUserServiceImpl;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7576426582974954009L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		CheckUserService cus = new CheckUserServiceImpl();
//	if(cus.checkUser(name, password)){
//		System.out.println("name:"+name+"----pssword:"+password);
		boolean b = cus.checkUser(name, password);
//		System.out.println(b);
//		System.out.println(b);
		PrintWriter pw = resp.getWriter();
		pw.write("{\"exist\":"+b+"}");
		pw.flush();
		pw.close();
//		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
