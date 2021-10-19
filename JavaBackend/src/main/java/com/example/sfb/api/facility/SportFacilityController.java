package com.example.sfb.api.facility;

import com.example.sfb.api.reservation.CalendarDataDto;
import com.example.sfb.domain.facility.SportFacilityService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/facilities")
@AllArgsConstructor
public class SportFacilityController {

    private final SportFacilityService sportFacilityService;

    @GetMapping("/{id}")
    public SportFacilityDto getSportFacility(@PathVariable int id) {
        return sportFacilityService.getSportFacility(id);
    }

    @GetMapping
    public List<SportFacilityDto> getSportFacilities() {
        return sportFacilityService.getSportFacilities();
    }

    @GetMapping("{id}/calendarData")
    public List<CalendarDataDto> getDates(@PathVariable int id) {
        return sportFacilityService.getCalendarData(id);
    }
}
