package com.ssafy.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.service.ResourceService;
import com.ssafy.member.model.ResourceDto;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService; // 인터페이스 타입으로 변경

    @GetMapping("/all")
    public String getAllResources(Model model) {
        List<ResourceDto> resources = resourceService.getAllResources();
        model.addAttribute("resources", resources);
        return "resources"; // 자원 리스트 페이지 (WEB-INF/views/resources.jsp)
    }

    @GetMapping("/details")
    public String getResourceById(@RequestParam int resourceId, Model model) {
        ResourceDto resource = resourceService.getResourceById(resourceId);
        model.addAttribute("resource", resource);
        return "resourceDetails"; // 자원 상세 페이지 (WEB-INF/views/resourceDetails.jsp)
    }
}
