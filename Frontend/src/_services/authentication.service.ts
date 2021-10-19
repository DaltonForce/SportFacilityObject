import {EventEmitter, Injectable, Output} from '@angular/core';
import { HttpClient, HttpHeaderResponse, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

import { environment } from 'src/environments/environment';
import {User} from 'src/_models/user';

@Injectable()
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  @Output() loggedInStatus: EventEmitter<boolean> = new EventEmitter();

  login() {
    const headers = new HttpHeaders({[`Authorization`] : `Basic `+ localStorage.getItem('creds'), [`Content-Type`]: `application/json`});
    const options = {headers: headers};
    return this.http.get<any>(`${environment.apiUrl}/login`, options)
      .pipe(map(user => {
        if (user.user) {}
        return user;
      }));
  }

  logout() {
    localStorage.removeItem('currentUser');
    localStorage.removeItem('creds');
  }

  isAuthenticated(): boolean {
    const  creds = localStorage.getItem('creds');
    return creds !== null ;
  }

  isAdmin(): boolean {
    const  currentUserRole = localStorage.getItem('currentUserRole');
    return currentUserRole == "ADMIN";
  }

  isUser(): boolean {
    const  currentUserRole = localStorage.getItem('currentUserRole');
    return currentUserRole == "USER";
  }
}
