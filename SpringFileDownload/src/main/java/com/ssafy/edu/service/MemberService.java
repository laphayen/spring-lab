package com.ssafy.edu.service;

import java.util.List;

import com.ssafy.edu.dto.MemberDto;



public interface MemberService {
	int insertMember(MemberDto m) throws Exception;
	int updateMember(MemberDto m) throws Exception;
	int deleteMember(String id) throws Exception;
	int deleteMembers(String[] ids) throws Exception;
	List<MemberDto> selectMember() throws Exception;
	MemberDto selectMember(String id) throws Exception;
	MemberDto login(String id, String pw)throws Exception;
}
