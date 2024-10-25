package com.ssafy.test.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.test.dto.Mobile;

public interface MobileDao {

	
	List<Mobile> selectAll() throws SQLException;
	Mobile selectByCode(String code) throws SQLException;
	int insert(Mobile mobile) throws SQLException;
	int update(Mobile mobile) throws SQLException;
	int delete(String code) throws SQLException;

}
