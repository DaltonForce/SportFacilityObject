package com.example.sfb.api.reservation;

import com.example.sfb.domain.reservation.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reservations")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/{id}")
    public ReservationDto getReservation(@PathVariable int id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    public void addReservation(@RequestBody ReservationDto reservationDto) {
        reservationService.addReservation(reservationDto);
    }

    @PatchMapping("/{reservationId}")
    public void updateReservationStatus(@PathVariable int reservationId, @RequestParam int statusId) {
        reservationService.updateReservationStatus(reservationId, statusId);
    }

    @GetMapping
    public List<ReservationDto> getReservations() {
        return reservationService.getReservations();
    }
}
