import { Injectable } from '@angular/core';
import {HttpHeaders} from '@angular/common/http';


const endPoint = 'http://192.168.56.1:8080/api/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};
@Injectable({
  providedIn: 'root'
})
export class RestService {

  constructor(private httpClient) { }
}
