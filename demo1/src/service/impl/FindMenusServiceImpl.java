package service.impl;

import java.util.ArrayList;
import java.util.List;

import dao.IMenusDao;
import dao.ISubMenusDao;
import dao.impl.MenusDaoImpl;
import dao.impl.SubMenusDaoImpl;
import model.Menus;
import model.SubMenus;
import service.IFindMenusService;

public class FindMenusServiceImpl implements IFindMenusService {

	private IMenusDao menusDao = new MenusDaoImpl();
	private ISubMenusDao submenusDao = new SubMenusDaoImpl();
	@Override
	public List<Menus> findMenus() {
		List<Menus> menus = menusDao.getMenusData();
		List<SubMenus> submenus = submenusDao.getSubMenusData();
		for (Menus menu : menus) {
			List<SubMenus> men = new ArrayList<SubMenus>();
			for (SubMenus submenu : submenus) {
				if(submenu.getMenuid()==menu.getMenuid()){
					men.add(submenu);
				}
			}
			menu.setSubmenus(men);
		}
		return menus;
	}

}
