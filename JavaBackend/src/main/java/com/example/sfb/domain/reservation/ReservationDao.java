package com.example.sfb.domain.reservation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationDao extends CrudRepository<Reservation, Integer> {

    Iterable<Reservation> findAllByFacilityId(int facilityId);
}
