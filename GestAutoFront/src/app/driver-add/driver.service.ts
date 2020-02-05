import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, of} from 'rxjs';
import {catchError, map, tap} from 'rxjs/operators';
import {FormBuilder} from '@angular/forms';
import {Driver, DriverAdapter} from '../driver-find/Driver';

const endpoint = 'http://192.168.56.1:8080/api/';
const httpOptions = {
  headers : new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class DriverService {

  public driver: Driver;

  constructor(private http: HttpClient, private adapter: DriverAdapter) { }

  addDriver(driverForm): Observable<any> {
    return this.http.post<any>(endpoint + 'driver', driverForm, httpOptions ).pipe(
      // tslint:disable-next-line:no-shadowed-variable
      tap( (driverForm) => console.log('added driver')),
    );
  }

  findDriver(driverName): Observable<Driver[]> {
    return this.http.get(endpoint + 'driver/' + driverName, httpOptions).pipe(
      map((  data: Driver[]) => data.map(item => this.adapter.adapt(item))));
  }

  associateDriverToVehicle(driver): Observable<any> {
   return this.http.post( endpoint + 'driver/associateDriverToVehicle', driver, httpOptions).pipe();
  }

}
