package dao;

import java.util.List;

public interface GetDao {
	<E>List<E> getAll(String sql,Class<E> clazz,Object...obj);
	Integer getAllCount();
	Integer upDate(String sql,Object...obj);
}
