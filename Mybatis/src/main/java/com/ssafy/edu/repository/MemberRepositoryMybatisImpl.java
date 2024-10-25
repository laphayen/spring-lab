package com.ssafy.edu.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.MemberDto;

@Repository("MemberRepositoryMybatisImpl")
public class MemberRepositoryMybatisImpl implements MemberRepository {

	@Autowired
	private SqlSession session;
	
	private String ns = "com.ssafy.edu.repository.";
	
	@Override
	public int insertMember(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return session.insert(ns+"insertMember", m);
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return session.update(ns+"updateMember", m);
	}

	@Override
	public int deleteMember(String id) throws Exception {
	    return session.delete(ns + "deleteMember", id);
	}

	
	@Override
	public List<MemberDto> selectMemberAll() throws Exception {
		List<MemberDto> selectList = session.selectList(ns+"selectMember");
		return selectList;
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(ns + "selectMember", id);
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		Map map = new HashMap();
		map.put("id", id);
		map.put("pw", pw);
		
		return session.selectOne(ns + "login", map);
	}
	
}
