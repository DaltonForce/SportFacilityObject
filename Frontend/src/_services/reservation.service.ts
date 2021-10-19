import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Reservation } from 'src/_models/reservation';

@Injectable()
export class ReservationService{

    private readonly url: string = `${environment.apiUrl}/reservations`;

    constructor(private http: HttpClient) {}

    getAll(){
        const headers = new HttpHeaders({[`Authorization`] : `Basic `+ localStorage.getItem('creds'), [`Content-Type`]: `application/json`});
        const options = {headers: headers};
        return this.http.get<Reservation[]>(this.url, options);
    }

    getById(id: number){
        return this.http.get<Reservation>(this.url + `/` + id);
    }

    update(reservation: Reservation) {
        return this.http.put<Reservation>(this.url + reservation.id, reservation);
    }

    updateStatus(reservation: Reservation){
        return this.http.patch<Reservation>(this.url + '/' + reservation.id + '?statusId=', reservation);
    }

    addReservation(reservation: Reservation){
        return this.http.post(this.url, reservation)
    }
}