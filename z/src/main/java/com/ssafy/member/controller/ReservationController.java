package com.ssafy.member.controller;

import com.ssafy.member.model.ReservationDto;
import com.ssafy.member.model.ResourceDto;
import com.ssafy.member.model.UserDto;
import com.ssafy.member.model.service.ReservationService;
import com.ssafy.member.model.service.ResourceService;

import jakarta.servlet.http.HttpSession;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/new")
    public String showReservationForm(HttpSession session, Model model) {
        List<ResourceDto> resources = resourceService.getAllResources();
        model.addAttribute("resources", resources);
        model.addAttribute("user", session.getAttribute("user"));
        return "reservation"; // 예약 페이지 (WEB-INF/views/reservation.jsp)
    }

    @PostMapping("/create")
    public String createReservation(@ModelAttribute ReservationDto reservation, HttpSession session) {
        // 세션에서 userId 가져오기
        UserDto user = (UserDto) session.getAttribute("user");
        if (user != null) {
            reservation.setUserId(user.getId());
        }
        
        reservationService.createReservation(reservation);
        return "redirect:/reservation/user";
    }

    @GetMapping("/user")
    public String getUserReservations(HttpSession session, Model model) {
        String userId = ((UserDto) session.getAttribute("user")).getId();
        List<ReservationDto> userReservations = reservationService.getReservationsByUser(userId);
        model.addAttribute("reservations", userReservations);
        return "userReservations"; // 사용자 예약 페이지 (WEB-INF/views/userReservations.jsp)
    }

    @PostMapping("/cancel")
    public String cancelReservation(@RequestParam int reservationId) {
        reservationService.cancelReservation(reservationId);
        return "redirect:/reservation/user";
    }
}
