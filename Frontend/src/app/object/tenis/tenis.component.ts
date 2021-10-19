import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/_models/reservation';
import { ReservationService } from 'src/_services/reservation.service';

@Component({
  selector: 'app-tenis',
  templateUrl: './tenis.component.html',
  styleUrls: ['./tenis.component.css']
})
export class TenisComponent implements OnInit {

  reservationsDetails: Reservation[] = [];
  
  headers = ["ID", "Username", "Reservation Start Date", "Reservation Finish Date"];

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
    this.reservationService.getAll().subscribe(
      reservationsDetails => {
        this.reservationsDetails = reservationsDetails;
      }
    );
  }

}
