package com.ssafy.edu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.repository.MemberRepository;


@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	@Qualifier("MemberRepositoryMybatisImpl")
	private MemberRepository repo;
	
	@Override
	@Transactional
	public int insertMember(MemberDto m) throws Exception {
//		repo.insertMember(m);
		int cnt = repo.insertMember(m);
		return cnt;
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		return repo.updateMember(m);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		return repo.deleteMember(id);
	}
	
	@Override
	public int deleteMembers(String[] ids) throws Exception {
		int cnt = 0;
		for (String id : ids) {
			repo.deleteMember(id);
			cnt++;
		}
		return cnt;
	}

	@Override
	public List<MemberDto> selectMemberAll() throws Exception {
		return repo.selectMemberAll();
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		return repo.selectMember(id);
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
		// TODO Auto-generated method stub
		MemberDto map = new MemberDto();
		return map;
	}

}
