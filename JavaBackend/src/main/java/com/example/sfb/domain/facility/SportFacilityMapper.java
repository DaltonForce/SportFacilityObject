package com.example.sfb.domain.facility;

import com.example.sfb.api.facility.SportFacilityDto;
import org.springframework.stereotype.Component;

@Component
public class SportFacilityMapper {

    SportFacilityDto mapToDto(SportFacility sportFacility){
        return SportFacilityDto.builder()
                .id(sportFacility.getId())
                .sport(sportFacility.getSport())
                .sportId(sportFacility.getSportId())
                .build();
    }
}
