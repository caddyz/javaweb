package model;

public class SubMenus {
	private Long menuid;
	private Long submenuid;
	private String menuname;
	private String icon;
	private String url;
	public Long getMenuid() {
		return menuid;
	}
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	public Long getSubmenuid() {
		return submenuid;
	}
	public void setSubmenuid(Long submenuid) {
		this.submenuid = submenuid;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "SubMenus [menuid=" + menuid + ", submenuid=" + submenuid + ", menuname=" + menuname + ", icon=" + icon
				+ ", url=" + url + "]";
	}
	
}
