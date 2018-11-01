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

import model.ComBo;
import service.IGetKindService;
import service.impl.GetKindServiceImpl;
@WebServlet("/GetKindServlet")
public class GetKindServlet extends HttpServlet{
	private IGetKindService kind = new GetKindServiceImpl();
	private static final long serialVersionUID = 1317041903707128176L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		List<String> list = kind.getKind();
		List<ComBo> comli = new ArrayList<ComBo>();
		System.out.println(list);
		for (int i = 0; i < list.size(); i++) {
			ComBo com = new ComBo();
			com.setId(list.get(i));
			com.setText(list.get(i));
//			System.out.println(com);
			comli.add(com);
		}
		System.out.println(comli);
		
		PrintWriter pw = resp.getWriter();
		pw.write(JSON.toJSONString(comli));
		pw.flush();
		pw.close();
	}
	
	
}
