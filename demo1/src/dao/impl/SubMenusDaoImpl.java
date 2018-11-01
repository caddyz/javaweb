package dao.impl;

import java.util.List;

import dao.ISubMenusDao;
import model.SubMenus;
import util.GetData;

public class SubMenusDaoImpl implements ISubMenusDao {

	@Override
	public List<SubMenus> getSubMenusData() {
		String sql = "SELECT menuid,menuname,icon,submenuid,url FROM submenus;";
		return GetData.getAll(sql, SubMenus.class);
	}
}
