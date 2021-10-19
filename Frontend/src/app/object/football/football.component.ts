import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/_models/reservation';
import { ReservationService } from 'src/_services/reservation.service';

@Component({
  selector: 'app-football',
  templateUrl: './football.component.html',
  styleUrls: ['./football.component.css']
})
export class FootballComponent implements OnInit {

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
