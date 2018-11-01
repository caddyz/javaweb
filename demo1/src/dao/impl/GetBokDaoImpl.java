package dao.impl;

import java.util.Date;
import java.util.List;

import dao.IGetBookDao;
import model.Book;
import util.GetData;

public class GetBokDaoImpl implements IGetBookDao {

	@Override
	public List<Book> getBookByName(String name) {
		String sql = "select * from t_book where bookName like %?%";
		return GetData.getAll(sql, Book.class, name);
	}

	@Override
	public List<Book> getBookByAuhtor(String auhtor) {
		String sql = "select * from t_book where author like %?%";
		return GetData.getAll(sql, Book.class, auhtor);
	}

	@Override
	public List<Book> getBookByPrice(Double price1, Double price2) {
		String sql = "select * from t_book where price between ? and ?";
		return GetData.getAll(sql, Book.class, price1,price2);
	}

	@Override
	public List<Book> getBookByDate(Date date1, Date date2) {
		String sql = "select * from t_book where publishDate between ? and ?";
		return GetData.getAll(sql, Book.class, date1,date2);
	}

	@Override
	public List<Book> getBookByKind(String kind) {
		String sql = "select * from t_book where kind = ?";
		return GetData.getAll(sql, Book.class, kind);
	}

	@Override
	public List<Book> getPageBooks(String name, String value, Double lowPrice, Double topPeice, String startDate, String endDate,
			String kind) {
		String sql = "select * from t_book where price between ? and ? "
				+ "and publishDate between ? and ? and kind = ? "
				+ "and "+name+" like concat('%',?,'%')";
		return GetData.getAll(sql, Book.class, lowPrice,topPeice,startDate,endDate,kind,value);
	}

}
