package dao.impl;

import java.util.List;

import dao.IGetKindDao;
import util.GetData;

public class GetKindDaoImpl implements IGetKindDao {

	@Override
	public List<String> getKind(String sql) {
		return GetData.getKind(sql);
	}

}
