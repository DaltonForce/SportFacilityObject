package com.example.sfb.api.reservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class CalendarDataDto {

    private String username;
    private LocalDateTime reservationTime;
    private LocalDateTime reservationFinish;
}
