import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/_models/reservation';
import { ReservationService } from 'src/_services/reservation.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  reservationsDetails: Reservation[] = [];

  reservationModel: Reservation = new Reservation();
  
  headers = ["ID", "Facility_ID", "Username", "Reservation Start Date", "Reservation Finish Date", "Status_ID", "Change Button"];

  constructor(private reservationService: ReservationService) { }

  ngOnInit() {
    this.reservationService.getAll().subscribe(
      reservationsDetails => {
        this.reservationsDetails = reservationsDetails;
      }
    );
  }

  updateStatus() {
    console.log(this.reservationModel);
    this.reservationService.update(this.reservationModel).subscribe(
      response => {
        console.log(response);
        console.log("success");
      },
      error => {
        console.log(error);
      }
    );
  }

}
