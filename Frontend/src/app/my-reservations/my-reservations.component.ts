import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/_models/reservation';
import { AuthenticationService } from 'src/_services/authentication.service';
import { ReservationService } from 'src/_services/reservation.service';

@Component({
  selector: 'app-my-reservations',
  templateUrl: './my-reservations.component.html',
  styleUrls: ['./my-reservations.component.css']
})
export class MyReservationsComponent implements OnInit {

  reservationsDetails: Reservation[] = [];

  reservationModel: Reservation = new Reservation();
  
  headers = ["Facility", "Reservation Start Date", "Reservation Finish Date", "Status"];

  constructor(private reservationService: ReservationService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.reservationService.getAll().subscribe(
      reservationsDetails => {
        this.reservationsDetails = reservationsDetails;
      }
    );

    let currentUser = localStorage.getItem('currentUser');
    console.log(currentUser);
  }

}
