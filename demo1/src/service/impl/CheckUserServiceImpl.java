package service.impl;

import java.util.List;

import dao.GetDao;
import dao.impl.GetDaoImpl;
import model.User;
import service.CheckUserService;

public class CheckUserServiceImpl implements CheckUserService {

	@Override
	public boolean checkUser(String name, String password) {
		boolean b = false;
		String sql = "SELECT * FROM te WHERE name=? AND password=?;";
		GetDao dao = new GetDaoImpl();
		List<User> list = dao.getAll(sql, User.class,name,password);
		if(list.size()>0){
			b = true;
		}
		return b;
	}

}
