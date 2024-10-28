package com.ssafy.member.model.dao;

import com.ssafy.member.model.ReservationDto;
import java.util.List;

public interface ReservationDao {
    List<ReservationDto> getAllReservations();
    List<ReservationDto> getReservationsByUser(String userId);
    int createReservation(ReservationDto reservation);
    int cancelReservation(int reservationId);
}