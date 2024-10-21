package com.ssafy.edu.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.repository.MemberRepositoryImpl;


@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{
	private MemberRepositoryImpl dao = new MemberRepositoryImpl();
	
	@Override
	public int insertMember(MemberDto m) throws Exception {
		return dao.insertMember(m);
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		return dao.updateMember(m);
	}

	@Override
	public int deleteMember(MemberDto m) throws Exception {
		return dao.deleteMember(m);
	}

	@Override
	public List<MemberDto> selectMember() throws Exception {
		return dao.selectMember();
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		return dao.selectMember(id);
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(id, pw);
	}

}
