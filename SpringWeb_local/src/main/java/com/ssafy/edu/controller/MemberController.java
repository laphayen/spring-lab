package com.ssafy.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.edu.dto.MemberDto;
import com.ssafy.edu.service.MemberService;
import com.ssafy.edu.service.MemberServiceImpl;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService = new MemberServiceImpl();

	@GetMapping( "/memberselectall")
	public ModelAndView memberSelectAll(ModelAndView mv) {
		try {
			List<MemberDto> list = memberService.selectMember();
			mv.addObject("list", list);
			mv.setViewName("member/list");
		} catch (Exception e) {
			System.out.println(e);
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	@GetMapping("/memberinsertform")
	public ModelAndView memberInsertForm(ModelAndView mv, @ModelAttribute MemberDto dto) {

		try {
			mv.setViewName("member/insert");

		} catch (Exception e) {
			System.out.println(e);
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}
	
	@GetMapping("/detail")
	public String memberDetail(@RequestParam("id") String id, Model model) {
	    try {
	        MemberDto member = memberService.selectMember(id);
	        model.addAttribute("member", member);
	    } catch (Exception e) {
	        System.out.println(e);
	        model.addAttribute("msg", "Error occurred while fetching member details.");
	        return "error/error";
	    }
	    return "member/detail";
	}
	

	@PostMapping("/memberinsert")
	public ModelAndView memberInsert(ModelAndView mv, @ModelAttribute MemberDto dto) {

		try {
			memberService.insertMember(dto);
			mv.setViewName("redirect:memberselectall");

		} catch (Exception e) {
			System.out.println(e);
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}

	@PostMapping("/memberupdate")
	public ModelAndView memberUpdate(ModelAndView mv, @ModelAttribute MemberDto dto) {

		try {
			memberService.updateMember(dto);
			mv.setViewName("redirect:memberselectall");

		} catch (Exception e) {
			System.out.println(e);
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}

	@PostMapping("memberdelete")
	public ModelAndView memberDelete(ModelAndView mv, @ModelAttribute MemberDto dto) {
		try {
			memberService.deleteMember(dto);
			mv.setViewName("redirect:memberselectall");

		} catch (Exception e) {
			System.out.println(e);
			mv.addObject("msg", e);
			mv.setViewName("error/error");
		}
		return mv;
	}

	@PostMapping("dels")
	public ModelAndView memberDelsPost(ModelAndView mv, @RequestParam("id") String[] ids) {
	    try {
	        for (String id : ids) {
	            MemberDto dto = new MemberDto();
	            dto.setId(id);
	            memberService.deleteMember(dto);
	            mv.setViewName("redirect:memberselectall");
	        }
	    } catch (Exception e) {
	        System.out.println(e);
	        mv.setViewName("error/error");
	    }
	    return mv;
	}

	
}
