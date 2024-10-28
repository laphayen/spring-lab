package com.ssafy.member.model.service;

import com.ssafy.member.model.ReservationDto;
import com.ssafy.member.model.dao.ReservationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationDao reservationDao;

    @Override
    public List<ReservationDto> getAllReservations() {
        return reservationDao.getAllReservations();
    }

    @Override
    public List<ReservationDto> getReservationsByUser(String userId) {
        return reservationDao.getReservationsByUser(userId);
    }

    @Override
    public boolean createReservation(ReservationDto reservation) {
        return reservationDao.createReservation(reservation) > 0;
    }

    @Override
    public boolean cancelReservation(int reservationId) {
        return reservationDao.cancelReservation(reservationId) > 0;
    }
}
