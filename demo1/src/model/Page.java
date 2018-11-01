package model;

import java.util.ArrayList;
import java.util.List;

public class Page {
	private List<Book> rows = new ArrayList<Book>();
	private Integer total;
	public List<Book> getRows() {
		return rows;
	}
	public void setRows(List<Book> rows) {
		this.rows = rows;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Page [rows=" + rows + ", total=" + total + "]";
	}
}
