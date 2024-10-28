package com.ssafy.member.model.dao;

import com.ssafy.member.model.ReservationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDaoImpl implements ReservationDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_ALL_RESERVATIONS = "SELECT * FROM reservations";
    private final String SELECT_RESERVATIONS_BY_USER = "SELECT * FROM reservations WHERE user_id = ?";
    private final String INSERT_RESERVATION = "INSERT INTO reservations (user_id, resource_id, start_time, end_time) VALUES (?, ?, ?, ?)";
    private final String DELETE_RESERVATION = "DELETE FROM reservations WHERE reservation_id = ?";

    @Override
    public List<ReservationDto> getAllReservations() {
        return jdbcTemplate.query(SELECT_ALL_RESERVATIONS, new BeanPropertyRowMapper<>(ReservationDto.class));
    }

    @Override
    public List<ReservationDto> getReservationsByUser(String userId) {
        return jdbcTemplate.query(SELECT_RESERVATIONS_BY_USER, new Object[]{userId}, new BeanPropertyRowMapper<>(ReservationDto.class));
    }

    @Override
    public int createReservation(ReservationDto reservation) {
        return jdbcTemplate.update(INSERT_RESERVATION, 
            reservation.getUserId(), 
            reservation.getResourceId(), 
            reservation.getStartTime(), 
            reservation.getEndTime()
        );
    }

    @Override
    public int cancelReservation(int reservationId) {
        return jdbcTemplate.update(DELETE_RESERVATION, reservationId);
    }
}
