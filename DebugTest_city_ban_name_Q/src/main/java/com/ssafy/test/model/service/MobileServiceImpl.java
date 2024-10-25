package com.ssafy.test.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.model.dao.MobileDao;
import com.ssafy.test.model.dao.MobileDaoImpl;

public class MobileServiceImpl implements MobileService {

	private MobileDao mobileDao;
	
	private MobileServiceImpl() {
		mobileDao = MobileDaoImpl.getInstance();
	}
	
	private static MobileServiceImpl instance;
	
	public static MobileServiceImpl getInstance() {
		if (instance == null) {
				instance = new MobileServiceImpl();
		}
		return instance;
	}
	
	

	@Override
	public List<Mobile> selectAll() throws SQLException {
		return mobileDao.selectAll();
	}

	@Override
	public Mobile selectByCode(String code) throws SQLException {
		return mobileDao.selectByCode(code);
	}

	@Override
	public int insert(Mobile mobile) throws SQLException {
		return mobileDao.insert(mobile);
	}

	@Override
	public int update(Mobile mobile) throws SQLException {
		return mobileDao.update(mobile);
	}

	@Override
	public int delete(String code) throws SQLException {
		return mobileDao.delete(code);
	}
	
}
