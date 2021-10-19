import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { User } from '../_models/user';

interface registerResponse {
  success: boolean,
  message: string
}

@Injectable()
export class UserService {

  private readonly url: string = `${environment.apiUrl}/users`;

  constructor(private http: HttpClient) {}

  getAll(){
      const headers = new HttpHeaders({[`Authorization`] : `Basic `+ localStorage.getItem('creds'), [`Content-Type`]: `application/json`});
      const options = {headers: headers};
      return this.http.get<User[]>(this.url, options);
  }

  register(user: User) {
    return this.http.post(this.url + '/registration', user);
  }

}
