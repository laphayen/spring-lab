package com.ssafy.edu.controller;

import java.net.HttpCookie;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.service.MemberService;
import com.ssafy.edu.service.MemberServiceImpl;
import com.ssafy.edu.service.MemberServiceImplMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	@Qualifier("MemberServiceImplMapper")
	private MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@GetMapping("/memberselectall")
	public ModelAndView memberSelectAll(ModelAndView mv) {
		logger.debug("memberselectall");
		System.out.println("memberselectall........");
		try {
			List<MemberDto> list = service.selectMemberAll();
			mv.addObject("list", list);
			mv.setViewName("member/list");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}

	@GetMapping("/memberinsertform")
	public String memberInsertform() {
		return "member/insert";
	}

	@PostMapping("/memberinsert")
	public ModelAndView memberInsert(ModelAndView mv, 
			@ModelAttribute MemberDto dto) {
		try {
			service.insertMember(dto);
			mv.setViewName("redirect:/member/memberselectall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@GetMapping("/memberdetail")
	public ModelAndView memberdetail(ModelAndView mv, 
			@RequestParam("id") String id) {
		try {
			MemberDto m = service.selectMember(id);
			mv.addObject("m",m);
			mv.setViewName("member/detail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@PostMapping("/memberdelete")
	public ModelAndView memberDelete(ModelAndView mv, 
			@RequestParam("id") String id) {
		try {
			service.deleteMember(id);
			mv.setViewName("redirect:/member/memberselectall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@PostMapping("/memberupdate")
	public ModelAndView memberUpdate(ModelAndView mv, 
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("age") int age) {
		try {
			service.updateMember(new MemberDto(id, pw, name, age));
			mv.setViewName("redirect:/member/memberselectall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@GetMapping("/dels")
	public ModelAndView memberDels(ModelAndView mv, 
			@RequestParam("id") String[] dels) {
		MemberDto dto = new MemberDto();
		try {
			
			service.deleteMembers(dels);
			mv.setViewName("redirect:/member/memberselectall");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@GetMapping("/loginform")
	public ModelAndView loginForm(ModelAndView mv) {
		try {
			mv.setViewName("login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@PostMapping("login")
	public ModelAndView login(ModelAndView mv, 
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			@RequestParam(value = "idsave",required = false) String[] idsave,
			HttpServletRequest request,
			HttpSession session,
			HttpServletResponse response) {
		try {
			MemberDto login = service.login(id, pw);
			if(login!=null) {
				session.setAttribute("id", id);
				//String idsave = request.getParameter("idsave");
				Cookie cookie = null;
				if(idsave!=null) {
					cookie = new Cookie("idsave",id);
					cookie.setMaxAge(60*60*24);
					response.addCookie(cookie);
				}else {
					Cookie[] cookies = request.getCookies();
					for (Cookie c : cookies) {
						if(c.getName().equals("idsave")){
							c.setMaxAge(0);
							response.addCookie(c);
							break;
						}
					}
				}
				mv.setViewName("redirect:/member/memberselectall");
			}
			else {
				mv.setViewName("redirect:/member/loginform");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	@GetMapping("logout")
	public ModelAndView logout(ModelAndView mv,
			HttpSession session) {
		try {
			session.invalidate();
			mv.setViewName("redirect:/");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
}
