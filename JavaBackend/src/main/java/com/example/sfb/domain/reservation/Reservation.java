package com.example.sfb.domain.reservation;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity(name = "RESERVATION")
@Table(name = "RESERVATION")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
class Reservation implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "FACILITY_ID")
    private int facilityId;

    @Column(name = "RESERVATION_TIME")
    private LocalDateTime reservationTime;

    @Column(name = "RESERVATION_FINISH")
    private LocalDateTime reservationFinish;

    @Column(name = "STATUS_ID")
    private int statusId;
}
