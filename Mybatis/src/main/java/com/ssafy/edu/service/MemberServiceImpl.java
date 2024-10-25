package com.ssafy.edu.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.repository.MemberRepository;


@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	@Qualifier("MemberRepositoryImpl")
	private MemberRepository repo;
	
	@Override
	public int insertMember(MemberDto m) throws Exception {
		return repo.insertMember(m);
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
		return repo.login(id, pw);
	}

}
