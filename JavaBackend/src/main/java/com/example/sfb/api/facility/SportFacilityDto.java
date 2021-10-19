package com.example.sfb.api.facility;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class SportFacilityDto {

    private int id;
    private int sportId;
    private String sport;
}
