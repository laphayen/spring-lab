package com.ssafy.edu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.MemberDto;

@Repository("MemberRepositoryImpl")
public class MemberRepositoryImpl implements MemberRepository{ww
	
	@Autowired
	private DataSource ds;
	
	@Override
	public int insertMember(MemberDto m) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "insert into members(id,pw,name,age) values(?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getId());
		pstmt.setString(2, m.getPw());
		pstmt.setString(3, m.getName());
		pstmt.setInt(4, m.getAge());
		int res = pstmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "update members set pw = ?,name=?,age=? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, m.getPw());
		pstmt.setString(2, m.getName());
		pstmt.setInt(3, m.getAge());
		pstmt.setString(4, m.getId());
		int res = pstmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public int deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		Connection conn = ds.getConnection();
		String sql = "delete from members where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		int res = pstmt.executeUpdate();
		conn.close();
		return res;
	}

	@Override
	public List<MemberDto> selectMemberAll() throws Exception {
		// TODO Auto-generated method stub
		Connection conn = ds.getConnection();
		String sql = "select id, pw, name, age from members";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<MemberDto> list = new ArrayList<>();
		while (rs.next()) {
			list.add(new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getInt("age")));
		}
		conn.close();
		return list;
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "select id, pw, name, age from members where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		MemberDto m = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getInt("age"));
		
		conn.close();
		return m;
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		Connection conn = ds.getConnection();
		String sql = "select id, pw, name, age from members where id = ? and pw = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		ResultSet rs = pstmt.executeQuery();
		MemberDto m = null;
		if(rs.next()) {
			m = new MemberDto(rs.getString("id"), rs.getString("pw"), rs.getString("name"), rs.getInt("age"));
		}
		conn.close();
		return m;
	}
}
