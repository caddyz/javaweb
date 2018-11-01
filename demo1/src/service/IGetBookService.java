package service;

import java.util.Date;
import java.util.List;

import model.Book;

public interface IGetBookService {
	List<Book> findPageBooks(String name,String value,String lowPrice,String topPrice,String startDate,String endDate,String kind);
}
