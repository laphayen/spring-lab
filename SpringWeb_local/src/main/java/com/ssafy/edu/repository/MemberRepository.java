package com.ssafy.edu.repository;

import java.util.List;

import com.ssafy.edu.dto.MemberDto;



public interface MemberRepository {
	int insertMember(MemberDto m) throws Exception;
	int updateMember(MemberDto m) throws Exception;
	int deleteMember(MemberDto m) throws Exception;
	List<MemberDto> selectMember() throws Exception;
	MemberDto selectMember(String id) throws Exception;
	MemberDto login(String id, String pw)throws Exception;
}
