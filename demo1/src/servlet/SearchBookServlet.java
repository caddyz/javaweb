package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet{
	private IGetBookService book = new GetBookServiceImpl();
	private Page page = new Page();
	private List<Book> list = new ArrayList<Book>();
	private static final long serialVersionUID = 4795168534299843158L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		Integer pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
		Integer pageSize = Integer.parseInt(req.getParameter("pageSize"));
		String name = req.getParameter("name");
		String value = req.getParameter("value");
		String startDate = req.getParameter("date1");
		String endDate = req.getParameter("date2");
		String lowPrice = req.getParameter("bottomPrice");
		String topPrice = req.getParameter("topPrice");
		String kind = req.getParameter("kind");
		if(pageNumber==1){
			List<Book> li = book.findPageBooks(name, value, lowPrice, topPrice, startDate, endDate, kind);
			list.addAll(li);
		}
//		System.out.println("list.size() "+list.size());
		/*System.out.println(
					name+" "+value+" "+date1+" "+date2+" "+bottomPrice+" "+topPrice+" "+kind
				);*/
//		System.out.println(list.size());
//		System.out.println(list);
		page.setTotal(list.size());
		Integer fromindex = (pageNumber-1)*pageSize;
		Integer toIndex = fromindex + pageSize;
//		System.out.println("fromindex "+fromindex+"  toIndex"+toIndex);
		if(toIndex<list.size()){
			page.setRows(list.subList(fromindex,toIndex));
		}else{
			page.setRows(list.subList(fromindex,(list.size()-1)));
		}
		PrintWriter pw = resp.getWriter();
		String str = JSON.toJSONString(page);
		pw.write(str);
		pw.flush();
		pw.close();
//		PrintWriter pw = resp.getWriter();
//		String str = JSON.toJSONString(list);
//		pw.write(str);
//		pw.flush();
//		pw.close();
	}

	
}
