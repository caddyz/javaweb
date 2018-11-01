package model;

import java.util.List;

public class Menus {
	private Long menuid;
	private String menuname;
	private String icon;
	private List<SubMenus> submenus;
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	
	public List<SubMenus> getSubmenus() {
		return submenus;
	}
	public void setSubmenus(List<SubMenus> submenus) {
		this.submenus = submenus;
	}
	@Override
	public String toString() {
		return "Menus [menuid=" + menuid + ", icon=" + icon + ", menuname=" + menuname + ", submenus=" + submenus + "]";
	}
	
}
