package com.ssafy.edu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.util.DBUtil;



@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository {

	@Override
	public int insertMember(MemberDto m) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "insert into members(id,pw,name,age) values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		pstmt.setString(3, m.getName());
		pstmt.setInt(4, m.getAge());
		int res = pstmt.executeUpdate();
		DBUtil.close(pstmt,conn);
		return res;
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "update members set pw = ?,name=?,age=? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getPw());
		pstmt.setString(2, m.getName());
		pstmt.setInt(3, m.getAge());
		pstmt.setString(4, m.getId());
		int res = pstmt.executeUpdate();
		DBUtil.close(pstmt,conn);
		return res;
	}

	@Override
	public int deleteMember(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "delete from members where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		int res = pstmt.executeUpdate();
		DBUtil.close(pstmt,conn);
		return 0;
	}

	@Override
	public List<MemberDto> selectMember() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		String sql = "select id, pw, name, age from members";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getInt("age")));
		}
		DBUtil.close(conn);
		return list;
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select id, pw, name, age from members where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		MemberDto m = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getInt("age"));
		
		DBUtil.close(conn);
		return m;
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		Connection conn = DBUtil.getConnection();
		String sql = "select id, pw, name, age from members where id = ? and pw = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		MemberDto m = null;
		if(rs.next()) {
			m = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getInt("age"));
		}
		DBUtil.close(conn);
		return m;
	}

}
