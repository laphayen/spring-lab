package com.ssafy.member.controller;

import com.ssafy.member.model.UserDto;
import com.ssafy.member.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, @RequestParam("password") String password, HttpSession session, Model model) {
        UserDto user = userService.loginUser(id, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "index";
        }
        return "error";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/login";
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "join"; // 회원가입 페이지 (WEB-INF/views/join.jsp)
    }

    @PostMapping("/register")
    public String register(UserDto user, Model model) {
        if (userService.registerUser(user)) {
            return "index"; // 회원가입 성공 시 index.jsp로 이동
        }
        model.addAttribute("error", "Registration failed");
        return "join"; // 실패 시 회원가입 페이지로 돌아감
    }
}
