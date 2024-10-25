package com.ssafy.edu.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.repository.MemberRepository;
import com.ssafy.edu.repository.MemberRepositoryImpl;

@Service("MemberServiceImplMapper")
public class MemberServiceImplMapper implements MemberService {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public int insertMember(MemberDto m) throws Exception {
		int cnt = session.getMapper(MemberRepository.class).insertMember(m);
		return cnt;
	}

	@Override
	public int updateMember(MemberDto m) throws Exception {
		// TODO Auto-generated method stub
		return session.getMapper(MemberRepository.class).updateMember(m);
	}

	@Override
	public int deleteMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.getMapper(MemberRepository.class).deleteMember(id);
	}

	@Override
	public int deleteMembers(String[] ids) throws Exception {
		// TODO Auto-generated method stub
		int cnt = 0;
		for (String id : ids) {
			session.getMapper(MemberRepository.class).deleteMember(id);
			cnt++;
		}
		return cnt;
	}

	@Override
	public List<MemberDto> selectMemberAll() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("전체 조회"  + "  🍦🍦🍦🍦🍦🍦🍦🍦🍦🍦 ??    " +   " "  );
		return session.getMapper(MemberRepository.class).selectMemberAll();
	}

	@Override
	public MemberDto selectMember(String id) throws Exception {
		// TODO Auto-generated method stub
		return session.getMapper(MemberRepository.class).selectMember(id);
	}

	@Override
	public MemberDto login(String id, String pw) throws Exception {
	    Map<String, Object> params = new HashMap<>();
	    
	    params.put("id", id);
	    params.put("pw", pw);

	    System.out.println(id + ": 이건 아니지! (아이디)!");
	    System.out.println(pw + ": pw 워드가 패스가 된다. ");
	    
	    return session.getMapper(MemberRepository.class).login(params);
	}
}
