package com.ssafy.admin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/admin/users")
@CrossOrigin("*")
public class AdminUserController {

	private static final Logger logger = LoggerFactory.getLogger(AdminUserController.class);

	private MemberService memberService;

	@Autowired
	public AdminUserController(MemberService memberService) {
		this.memberService = memberService;
	}

	// TODO : 회원목록 얻기

	@RequestMapping(method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public List<MemberDto> userRegister(@RequestBody MemberDto memberDto) throws Exception {
		memberService.joinMember(memberDto);
		return memberService.listMember(null);
	}

	@RequestMapping(value = "/{userid}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public MemberDto userInfo(@PathVariable("userid") String userid) throws Exception {
		return memberService.getMember(userid);
	}

	@RequestMapping(method = RequestMethod.PATCH, headers = { "Content-type=application/json" })
	public List<MemberDto> userModify(@RequestBody MemberDto memberDto) throws Exception {
		memberService.updateMember(memberDto);
		return memberService.listMember(null);
	}

	@RequestMapping(value = "/{userid}", method = RequestMethod.DELETE, headers = {
			"Content-type=application/json" })
	public List<MemberDto> userDelete(@PathVariable("userid") String userid) throws Exception {
		memberService.deleteMember(userid);
		return memberService.listMember(null);
	}

//	@GetMapping
//	public ResponseEntity<?> userList() {
//		logger.debug("userList call");
//		try {
//			List<MemberDto> list = memberService.listMember(null);
//			if(list != null && !list.isEmpty()) {
//				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
////				return new ResponseEntity<List<MemberDto>>(HttpStatus.NOT_FOUND);
//			} else {
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//			}
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//		
//	}
//	
//	@PostMapping
//	public ResponseEntity<?> userRegister(@RequestBody MemberDto memberDto) {
//		logger.debug("userRegister memberDto : {}", memberDto);
//		try {
//			memberService.joinMember(memberDto);
//			List<MemberDto> list = memberService.listMember(null);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
////			return new ResponseEntity<Integer>(cnt, HttpStatus.CREATED);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//		
//	}
//	
//	@GetMapping(value = "/{userid}")
//	public ResponseEntity<?> userInfo(@PathVariable("userid") String userId) {
//		logger.debug("userInfo userid : {}", userId);
//		try {
//			MemberDto memberDto = memberService.getMember(userId);
//			if(memberDto != null)
//				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
//			else
//				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
//	
//	@PatchMapping
//	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto) {
//		logger.debug("userModify memberDto : {}", memberDto);
//		try {
//			memberService.updateMember(memberDto);
//			List<MemberDto> list = memberService.listMember(null);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
//	
//	@DeleteMapping(value = "/{userid}")
//	public ResponseEntity<?> userDelete(@PathVariable("userid") String userId) {
//		logger.debug("userDelete userid : {}", userId);
//		try {
//			memberService.deleteMember(userId);
//			List<MemberDto> list = memberService.listMember(null);
//			return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
//		} catch (Exception e) {
//			return exceptionHandling(e);
//		}
//	}
//
//	private ResponseEntity<String> exceptionHandling(Exception e) {
//		e.printStackTrace();
//		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}

}
