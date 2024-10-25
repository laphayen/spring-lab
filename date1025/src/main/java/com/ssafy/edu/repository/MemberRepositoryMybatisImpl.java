package com.ssafy.edu.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.MemberDto;

@Repository("MemberRepositoryMybatisImpl")
public class MemberRepositoryMybatisImpl implements MemberRepository{
	
	private String ns = "com.ssafy.edu.repository.MemberRepository";
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertMember(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(m + "123412341234 insert!");
		return session.insert(ns+"insertMember", m);
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return session.update(ns+ "updateMember", m);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(id + "123123412341234     delete");
		return session.delete(ns+"deleteMember", id);
	}
	
	@Override
	public List<MemberDto> selectMemberAll() throws Exception {
		// TODO Auto-generated method stub'
		System.out.println(ns+"selectMemberAll" + "이건 잘 나옴????????");
		List<MemberDto> selectList = session.selectList(ns+"selectMemberAll");
		return selectList;
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(ns+"selectMember", id);
	}

	@Override
	public MemberDto login(Map<String, Object> params) throws Exception {
		System.out.println(params);
	    return session.selectOne(ns + "login", params);
	}
}
