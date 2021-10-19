import { Component, OnInit } from '@angular/core';
import { Reservation } from 'src/_models/reservation';
import { ReservationService } from 'src/_services/reservation.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-basketball',
  templateUrl: './basketball.component.html',
  styleUrls: ['./basketball.component.css']
})
export class BasketballComponent implements OnInit {

  reservationForm!: FormGroup;
  loading = false;
  submitted = false;

  reservationsDetails: Reservation[] = [];
  
  headers = ["ID", "Username", "Reservation Start Date", "Reservation Finish Date"];

  constructor(private reservationService: ReservationService, private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.reservationService.getAll().subscribe(
      reservationsDetails => {
        this.reservationsDetails = reservationsDetails;
      }
    );

    this.reservationForm = this.formBuilder.group({
      username: [localStorage.getItem('currentUser')],
      facilityId: [2],
      statusId: [1],
      reservationTime: ['', Validators.required],
      reservationFinish: ['', Validators.required]
    });
  }

  
 
  get f() { return this.reservationForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.reservationForm.invalid) {
      return;
    }

    this.loading = true;
    this.reservationService.addReservation(this.reservationForm.value)
      .pipe(first())
      .subscribe(
        data => {
          console.log(this.reservationForm.value)
          this.router.navigate(['/user']
          )}
      )}

}
