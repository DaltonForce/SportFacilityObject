import {Injectable} from '@angular/core';
import {environment as env, environment} from 'src/environments/environment';
import {HttpClient, HttpParams} from '@angular/common/http';
import { Sport_Object } from 'src/_models/sport_object';
import { Observable } from 'rxjs';

@Injectable()
export class SportObjectService{

    private readonly url: string = `${environment.apiUrl}/facilities`;

    constructor (private http: HttpClient){}

    public getFacilities(): Observable<Sport_Object[]> {
        return this.http.get<Sport_Object[]>(this.url);
    }
}
