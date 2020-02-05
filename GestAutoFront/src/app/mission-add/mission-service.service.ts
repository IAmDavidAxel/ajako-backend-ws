import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {tap} from 'rxjs/operators';

const endpoint = 'http://192.168.56.1:8080/api/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};



@Injectable({
  providedIn: 'root'
})
export class MissionServiceService {

  constructor(private http: HttpClient) { }

  addMission(missionForm): Observable<any> {
    return this.http.post<any>(endpoint + 'mission', missionForm, httpOptions).pipe(
      // tslint:disable-next-line:no-shadowed-variable
      tap((missionForm) => console.log('added mission')),
    );
  }
}
