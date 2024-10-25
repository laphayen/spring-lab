package com.ssafy.edu.service;

import java.util.List;
import java.util.Map;

import com.ssafy.edu.dto.MemberDto;



public interface MemberService {
	int insertMember(MemberDto m) throws Exception;
	int updateMember(MemberDto m) throws Exception;
	int deleteMember(String id) throws Exception;
	int deleteMembers(String[] ids) throws Exception;
	List<MemberDto> selectMemberAll() throws Exception;
	MemberDto selectMember(String id) throws Exception;
	public MemberDto login(String id, String pw) throws Exception;
}
