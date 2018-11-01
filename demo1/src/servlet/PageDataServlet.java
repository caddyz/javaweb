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

import model.Book;
import model.Page;
import service.IGetBookService;
import service.impl.GetBookServiceImpl;

@WebServlet("/PageDataServlet")
public class PageDataServlet extends HttpServlet{
	private IGetBookService book = new GetBookServiceImpl();
	private Page page = new Page();
	private static final long serialVersionUID = -8489979399097190708L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String size = req.getParameter("pageSize");
		String number = req.getParameter("pageNumber");
		int pageSize = 10;
		int pageNumber = 1;
		if(size != null){
			pageSize = Integer.parseInt(size);
		}
		if(number!=null){
			pageNumber = Integer.parseInt(number);
		}
		String name = req.getParameter("name");
		String value = req.getParameter("value");
		String startDate = req.getParameter("date1");
		String endDate = req.getParameter("date2");
		String lowPrice = req.getParameter("bottomPrice");
		String topPrice = req.getParameter("topPrice");
		String kind = req.getParameter("kind");
		List<Book> list = book.findPageBooks(name, value, lowPrice, topPrice, startDate, endDate, kind);
		page.setTotal(list.size());
		int num = (pageNumber-1)*pageSize;
		page.setRows(list.subList(num, (num+pageSize)));
		PrintWriter pw = resp.getWriter();
		String str = JSON.toJSONString(page);
		pw.write(str);
		pw.flush();
		pw.close();
	}

	
}
