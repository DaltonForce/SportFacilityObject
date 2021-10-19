package com.example.sfb.domain.reservation;

import com.example.sfb.api.reservation.ReservationDto;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class ReservationService {

    private final ReservationDao reservationDao;
    private final ReservationMapper reservationMapper;

    @Secured("ROLE_USER")
    public ReservationDto getReservation(int id) {
        Reservation reservation = getReservationById(id);

        return reservationMapper.mapToDto(reservation);
    }

    //@Secured("ROLE_USER")
    @Transactional
    public void addReservation(ReservationDto reservationDto) {
        Reservation reservation = reservationMapper.mapToEntity(reservationDto);
        reservationDao.save(reservation);
    }

    @Secured("ROLE_ADMIN")
    @Transactional
    public void updateReservationStatus(int reservationId, int statusId) {
        Reservation reservation = getReservationById(reservationId);
        reservation.setStatusId(statusId);

        reservationDao.save(reservation);
    }

    public List<ReservationDto> getReservationsByFacilityId(int facilityId) {
        Iterable<Reservation> reservations = reservationDao.findAllByFacilityId(facilityId);

        return StreamSupport.stream(reservations.spliterator(), false)
                .map(reservationMapper::mapToDto)
                .collect(toList());
    }

    private Reservation getReservationById(int id) {
        return reservationDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Reservation with id " + id + " has not been found!"));
    }

    //@Secured("ROLE_ADMIN")
    public List<ReservationDto> getReservations() {
        Iterable<Reservation> reservations = reservationDao.findAll();

        return StreamSupport.stream(reservations.spliterator(), false)
                .map(reservationMapper::mapToDto)
                .collect(toList());
    }
}
