package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import model.Menus;
import service.IFindMenusService;
import service.impl.FindMenusServiceImpl;
@WebServlet("/GetMenusServlet")
public class GetMenusServlet extends HttpServlet{
	private IFindMenusService ifm = new FindMenusServiceImpl();
	private static final long serialVersionUID = 4198733765814977839L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		List<Menus> menus = ifm.findMenus();
		String menu = JSON.toJSONString(menus);
		System.out.println(menu);
		PrintWriter pw = resp.getWriter();
		pw.write(menu);
	}
	
}
