package com.ssafy.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.repository.MemberRepository;
import com.ssafy.edu.service.MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class MybatisTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	MemberService service;
	
	@Autowired
	@Qualifier("")
	MemberRepository repo;
	
	@Autowired
	SqlSession session;
	private String ns = "com.ssafy.edu.repository.";
	
//	@Test
//	public void test1() {
//		
//		session.insert(ns+"insertMember", new MemberDto("99","99","99",99));
//		
//	}
//	@Test
//	public void test2() {
//		List<MemberDto> selectList = session.selectList(ns+"selectMemberAll");
//		System.out.println(selectList);
//	}
	
	@Test
	public void test3() {
		Map map = new HashMap();
		map.put("col", "pw");
		map.put("data", "99");
		List<MemberDto> selectList = session.selectList(ns+"test1",map);
		System.out.println(selectList);
	}
	
	
	
//	@Test
//	public void test2() {
//		assertEquals(0, 1);
//	}

}
