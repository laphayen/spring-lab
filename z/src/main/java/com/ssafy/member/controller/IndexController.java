package com.ssafy.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index"; // `WEB-INF/views/index.jsp`를 렌더링합니다.
    }
}
