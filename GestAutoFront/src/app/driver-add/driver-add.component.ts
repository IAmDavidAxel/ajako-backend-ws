import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {pipe} from 'rxjs';
import {DriverService} from './driver.service';

@Component({
  selector: 'app-driver-add',
  templateUrl: './driver-add.component.html',
  styleUrls: ['./driver-add.component.sass']
})
export class DriverAddComponent implements OnInit {
 public driverForm;

  constructor(private driverService: DriverService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.driverForm = this.formBuilder.group({
      first_name: [''],
      last_name: [''],
      id_number: [''],
      cell_phone_number: [''],
      birth_date: [''],
      driver_licence_number: ['']
    });
  }

  onSubmit() {
    this.driverService.addDriver(this.driverForm.value).subscribe();
  }

}
