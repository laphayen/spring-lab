package com.ssafy.member.model.service;

import com.ssafy.member.model.ReservationDto;
import java.util.List;

public interface ReservationService {
    List<ReservationDto> getAllReservations();
    List<ReservationDto> getReservationsByUser(String userId);
    boolean createReservation(ReservationDto reservation);
    boolean cancelReservation(int reservationId);
}
