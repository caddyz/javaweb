package dao.impl;

import java.util.List;

import dao.IMenusDao;
import model.Menus;
import util.GetData;

public class MenusDaoImpl implements IMenusDao {

	@Override
	public List<Menus> getMenusData() {
		String sql = "SELECT menuid,menuname,icon FROM menus;";
		return GetData.getAll(sql, Menus.class);
	}

}
