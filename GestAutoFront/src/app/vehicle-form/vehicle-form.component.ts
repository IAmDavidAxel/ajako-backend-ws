import {Component, Input, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.sass']
})

export class VehicleFormComponent implements OnInit {
  vehicleForm;

  constructor(private formBuilder: FormBuilder,  private http: HttpClient) {}

  ngOnInit() {
    this.vehicleForm = this.formBuilder.group({
      plateNumber: [''],
      model: [''],
      type: [''],
      color: ['']
    });
  }

  onSubmit() {
    this.http.post('http://192.168.56.1:8080/api/vehicle', this.vehicleForm.value).subscribe((response) => {
      console.log('response', response);
    });
  }

}
