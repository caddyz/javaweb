package service.impl;

import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import dao.IGetBookDao;
import dao.impl.GetBokDaoImpl;
import model.Book;
import service.IGetBookService;

public class GetBookServiceImpl implements IGetBookService {
	private IGetBookDao bookDao = new GetBokDaoImpl();
	@Override
	public List<Book> findPageBooks(String name, String value, String lowPrice, String topPrice, String startDate,
			String endDate, String kind) {
		if(startDate == null){
			startDate = "1900-01-01";
		}
		if(endDate == null){
			Calendar c = Calendar.getInstance();
			endDate = c.get(c.YEAR)+"-"+(c.get(c.MONTH)+1)+"-"+c.get(c.DATE);
//			endDate = new Date();
		}
		if(lowPrice==null){
			lowPrice = "0";
		}
		if(topPrice==null){
			topPrice = Double.MAX_VALUE+"";
		}
		return bookDao.getPageBooks(name, value, Double.parseDouble(lowPrice), Double.parseDouble(topPrice), startDate, endDate, kind);
	}
	/*public static void main(String[] args) throws ParseException {
//		c.get(c.YEAR)
		Calendar c = Calendar.getInstance();
		System.out.println(c.get(c.YEAR)+"-"+(c.get(c.MONTH)+1)+"-"+c.get(c.DATE));
	}*/
}
