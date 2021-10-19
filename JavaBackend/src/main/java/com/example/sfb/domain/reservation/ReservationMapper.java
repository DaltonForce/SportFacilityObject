package com.example.sfb.domain.reservation;

import com.example.sfb.api.reservation.ReservationDto;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {

    ReservationDto mapToDto(Reservation reservation) {
        return ReservationDto.builder()
                .id(reservation.getId())
                .username(reservation.getUsername())
                .facilityId(reservation.getFacilityId())
                .reservationTime(reservation.getReservationTime())
                .reservationFinish(reservation.getReservationFinish())
                .statusId(reservation.getStatusId())
                .build();
    }

    Reservation mapToEntity(ReservationDto reservationDto) {
        return Reservation.builder()
                .id(reservationDto.getId())
                .username(reservationDto.getUsername())
                .facilityId(reservationDto.getFacilityId())
                .reservationTime(reservationDto.getReservationTime())
                .reservationFinish(reservationDto.getReservationFinish())
                .statusId(reservationDto.getStatusId())
                .build();
    }
}
