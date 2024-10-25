//package com.ssafy.edu;
//
//
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.context.WebApplicationContext;
//
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(
//		locations = {"classpath:spring/root-context.xml",
//		"file:src/main/webapp/WEB-INF/servlet-context.xml"}
//)
//public class MockTest {
//
//   private static final Logger logger = LoggerFactory.getLogger(MockTest.class);
//
//    @Autowired // Dependency Injection(의존성 주입)
//    private WebApplicationContext wac;
//    //@Autowired
//    private MockMvc mock;
//
////    @Value("${userid}")
////	private String userId;
////	
////	@Value("${userpwd}")
////	private String userPwd;
////	
////	@Value("${username}")
////	private String userName;
//	
//    
//    @Before
//    public void beforeTest(){
//        logger.info("===== beforeTest() =====");
//        mock = MockMvcBuilders.webAppContextSetup(wac).build();
//        logger.info("wac: " + wac);
//        logger.info("mock: " + mock);
//    }
//
//    @Test
//    public void doTest(){
//        logger.info("===== doTest() =====");
//        RequestBuilder req = MockMvcRequestBuilders.get("/mem/login").
//                param("id","111").
//                param("pw","111");
//        try {
//            mock.perform(req)
//    		.andExpect(status().isOk())
//    		.andExpect(content().contentType(MediaType.ALL))
//    		.andDo(print());
//            
//            
//            logger.info("수행 성공");
//        } catch (Exception e) {
//            logger.error("수행 실패: " + e.getMessage());
//        }
//    }
//
//    @After
//    public void afterTest(){
//        logger.info("===== afterTest() =====");
//    }
//    
//    //@Test
////    @Disabled
////    @DisplayName("#### 회원 목록 테스트 ####")
//    public void testUserList() throws Exception{
//    	//log.debug("#### 회원 목록 테스트 시작 ####");
//    	mock.perform(get("/api/member"))
//    		.andExpect(status().isOk())
//    		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//    		.andDo(print());
//    	//log.debug("#### 회원 목록 테스트 종료 ####");
//    }
////
//    //@Test
//    @DisplayName("#### 회원 등록 테스트 ####")
//    @Transactional // test에서 transactional을 사용하면 commit 되지 않고 rollback 된다
//    public void testUserRegister() throws Exception{
//    	//log.debug("#### 회원 등록 테스트 시작 ####");
//    	MemberDTO dto = new MemberDTO();
//    	dto.setId("newunit");
//    	dto.setPw("777");
//    	dto.setName("유닛이예영");
//    	dto.setAge("21");
//    	dto.setAddr("대전");
//    	
//    	ObjectMapper objectMapper = new ObjectMapper();
//    	String content = objectMapper.writeValueAsString(dto);
//    	
//    	mock.perform(post("/api/member").content(content).contentType(MediaType.APPLICATION_JSON))
//    		.andExpect(status().is2xxSuccessful()) // 응답 코드 200번 대
//    		.andExpect(content().contentType(MediaType.APPLICATION_JSON)) // 리턴 리스트
//    		.andDo(print());
//    	//log.debug("#### 회원 등록 테스트 종료 ####");
//    }
////
//   // @Test
//    @DisplayName("#### 회원 정보 얻기 테스트 ####")
//    public void testUserInfo() throws Exception{
//    	//log.debug("#### 회원 정보 얻기 테스트 시작 ####");
//    	mock.perform(get("/api/memview/" + "111")) // {userId:ssafy, userPwd:1234, userName:김싸피}
//    		.andExpect(status().isOk())
//    		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
//    		//.andExpect(jsonPath("$.userPwd", is("111")))
//    		.andDo(print());
//    	//log.debug("#### 회원 정보 얻기 테스트 종료 ####");
//    }
//}
//
