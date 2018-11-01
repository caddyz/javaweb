package service.impl;

import java.util.List;

import dao.IGetKindDao;
import dao.impl.GetKindDaoImpl;
import service.IGetKindService;

public class GetKindServiceImpl implements IGetKindService{
	private IGetKindDao kindDao = new GetKindDaoImpl();
	@Override
	public List<String> getKind() {
		String sql = "SELECT kind FROM t_book GROUP BY kind;";
		return kindDao.getKind(sql);
	}

}
