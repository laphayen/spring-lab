package com.ssafy.test.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.test.dto.User;
import com.ssafy.test.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private DBUtil dbUtil;

	private UserDaoImpl() {
		dbUtil = DBUtil.getInstance();
	}

	private static UserDaoImpl instance = new UserDaoImpl();

	public static UserDaoImpl getInstance() {
		return instance;
	}

	@Override
	public User login(User user) throws SQLException {
		String sql = "select id, pw, name from users where id=? and pw=?";
		User userInfo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String id=rs.getString("id");
				String pw= rs.getString("pw");
				String name = rs.getString("name");
				userInfo = new User();
				userInfo.setId(id);
				userInfo.setPw(pw);
				userInfo.setName(name);
			}
			
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return userInfo;
	}

	@Override
	public int register(User user) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into users (id, pw, name, birthdate, phone, email) ");
		sql.append("values (?, ?, ?, ?, ?, ?)");
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getBirthdate());
			pstmt.setString(5, user.getPhone());
			pstmt.setString(6, user.getEmail());
			
			cnt = pstmt.executeUpdate();
			
			
		}finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;
	}
	
	@Override
	public User detail(String id) throws SQLException {
		String sql  = "select * from users where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		User user = null;
		try {
			
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPw(rs.getString("pw"));
				user.setName(rs.getString("name"));
				user.setBirthdate(rs.getString("birthdate"));
				user.setPhone(rs.getString("phone"));
				user.setEmail(rs.getString("email"));
				user.setRegDate(rs.getString("reg_date"));
			}
		}finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return user;
	}

	@Override
	public int update(User user) throws SQLException {
		StringBuilder sql  = new StringBuilder();
		sql.append("update users set pw=?, name=?, birthdate=?, phone=?, email=? where id=?");
		int cnt = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, user.getPw());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getBirthdate());
			pstmt.setString(4, user.getPhone());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getId());
			
			cnt = pstmt.executeUpdate();
		}finally {
			dbUtil.close(pstmt, conn);
		}
		return cnt;

	}


}
