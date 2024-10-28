package com.ssafy.member.model;

import java.sql.Timestamp;

public class ReservationDto {

    private int reservationId;      // 예약 ID
    private String userId;          // 사용자 ID
    private int resourceId;         // 자원 ID
    private Timestamp startTime;    // 시작 시간
    private Timestamp endTime;      // 종료 시간

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId + ", userId=" + userId 
                + ", resourceId=" + resourceId + ", startTime=" + startTime 
                + ", endTime=" + endTime + "]";
    }
}
