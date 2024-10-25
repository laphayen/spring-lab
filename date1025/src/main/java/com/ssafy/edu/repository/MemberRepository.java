package com.ssafy.edu.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.edu.dto.MemberDto;

@Mapper
public interface MemberRepository {
	int insertMember(MemberDto m) throws Exception;
	int updateMember(MemberDto m) throws Exception;
	int deleteMember(String id) throws Exception;
	List<MemberDto> selectMemberAll() throws Exception;
	MemberDto selectMember(String id) throws Exception;
	public MemberDto login(Map<String, Object> params) throws Exception;
}
