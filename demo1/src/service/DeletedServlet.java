package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.GetDao;
import dao.impl.GetDaoImpl;

@WebServlet("/DeletedServlet")
public class DeletedServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer num = Integer.parseInt(req.getParameter("uid"));
		String sql = "DELETE FROM t_user WHERE uid = ?;";
		GetDao da = new GetDaoImpl();
		Integer count = da.upDate(sql, num);
		boolean b = false;
		if(count>0){
			b = true;
		}
		PrintWriter pw = resp.getWriter();
		pw.write("{\"deleted\":"+b+"}");
		pw.flush();
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
