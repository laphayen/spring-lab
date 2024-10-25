package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.test.dto.Mobile;
import com.ssafy.test.util.DBUtil;

public class MobileDaoImpl implements MobileDao {

	private DBUtil dbUtil;
	private MobileDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}
	private static MobileDaoImpl instance = new MobileDaoImpl();
	public static MobileDaoImpl getInstance() {
		return instance;
	}

	@Override
	public List<Mobile> selectAll() throws SQLException {
		List<Mobile> mobileList = new ArrayList<>();
		String sql = "select code, model, price, company from mobiles";
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)){
			try(ResultSet rs = pstmt.executeQuery();){

				while(rs.next()) {
					String code = rs.getString("code");
					String model = rs.getString("model");
					int price = rs.getInt("price");
					String company = rs.getString("company");
					
					Mobile mobile = new Mobile();
					mobile.setCode(code);
					mobile.setModel(model);
					mobile.setPrice(price);
					mobile.setCompany(company);
					
					
					mobileList.add(mobile);
				}
			}
		}
		
		return mobileList;
	}


	@Override
	public Mobile selectByCode(String code) throws SQLException {
		String sql = "select code, model, price, company, user_id from mobiles where code=?";
		Mobile mobile = null; 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			rs = pstmt.executeQuery();
				if(rs.next()) {
					mobile = new Mobile();
					mobile.setCode(rs.getString("code"));
					mobile.setModel(rs.getString("model"));
					mobile.setPrice(rs.getInt("price"));
					mobile.setCompany(rs.getString("company"));
					mobile.setUserId(rs.getString("user_id"));
				}
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return mobile;
	}


	@Override
	public int insert(Mobile mobile) throws SQLException {
		String sql = "insert into mobiles (code, model, price, company, user_id) values (?, ?, ?, ?, ?)";
		int cnt = 0;
		Connection conn =null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mobile.getCode());
			pstmt.setString(2, mobile.getModel());
			pstmt.setInt(3, mobile.getPrice());
			pstmt.setString(4, mobile.getCompany());
			pstmt.setString(5, mobile.getUserId());
			
			pstmt.execute();

		}finally {			
			dbUtil.close(pstmt, conn);
		}
		return cnt;

	}


	@Override
	public int update(Mobile mobile) throws SQLException {
		String sql = "update mobiles model=?, price=?, company=? where code=?";
		int cnt = 0;
		try(
				Connection conn = dbUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, mobile.getModel());
			pstmt.setInt(2, mobile.getPrice());
			pstmt.setString(3, mobile.getCompany());
			pstmt.setString(4, mobile.getCode());
			
			cnt = pstmt.executeUpdate();
		}
		return cnt;
	}


	@Override
	public int delete(String code) throws SQLException {
		String sql = "delete from mobiles where code=?";
		int cnt = 0;
		try(Connection conn = dbUtil.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);){
			pstmt.setString(1, code);
			
			pstmt.executeUpdate();
		}
		return cnt;
		
	}
	

}
