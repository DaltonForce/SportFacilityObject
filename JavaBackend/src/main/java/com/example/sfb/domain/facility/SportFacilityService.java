package com.example.sfb.domain.facility;

import com.example.sfb.api.facility.SportFacilityDto;
import com.example.sfb.api.reservation.CalendarDataDto;
import com.example.sfb.api.reservation.ReservationDto;
import com.example.sfb.domain.reservation.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class SportFacilityService {

    private final ReservationService reservationService;
    private final SportFacilityDao sportFacilityDao;
    private final SportFacilityMapper sportFacilityMapper;

    public SportFacilityDto getSportFacility(int id) {
        SportFacility sportFacility = sportFacilityDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Sport facility with id " + id + " has not been found!"));

        return sportFacilityMapper.mapToDto(sportFacility);
    }

    public List<SportFacilityDto> getSportFacilities() {
        Iterable<SportFacility> sportFacilities = sportFacilityDao.findAll();

        return StreamSupport.stream(sportFacilities.spliterator(), false)
                .map(sportFacilityMapper::mapToDto)
                .collect(toList());
    }

    public List<CalendarDataDto> getCalendarData(int facilityId) {

        return reservationService.getReservationsByFacilityId(facilityId).stream()
                .map(e -> CalendarDataDto.builder()
                        .username(e.getUsername())
                        .reservationTime(e.getReservationTime())
                        .reservationFinish(e.getReservationFinish())
                        .build())
                .collect(toList());
    }
}
