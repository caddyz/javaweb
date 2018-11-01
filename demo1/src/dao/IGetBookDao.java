package dao;

import java.util.Date;
import java.util.List;

import model.Book;

public interface IGetBookDao {
	List<Book> getBookByName(String name);
	List<Book> getBookByAuhtor(String auhtor);
	List<Book> getBookByPrice(Double price1,Double price2);
	List<Book> getBookByDate(Date date1,Date date2);
	List<Book> getBookByKind(String kind);
	List<Book> getPageBooks(String name,String value,Double lowPrice,Double topPrice,String startDate,String endDate,String kind);
}
