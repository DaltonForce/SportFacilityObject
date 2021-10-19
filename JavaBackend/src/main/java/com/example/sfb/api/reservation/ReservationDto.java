package com.example.sfb.api.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class ReservationDto {

    private int id;
    private String username;
    private int facilityId;
    private LocalDateTime reservationTime;
    private LocalDateTime reservationFinish;
    private int statusId;
}
