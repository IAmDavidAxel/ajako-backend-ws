import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Driver} from './Driver';
import {DriverService} from '../driver-add/driver.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-driver-find',
  templateUrl: './driver-find.component.html',
  styleUrls: ['./driver-find.component.sass']
})
export class DriverFindComponent implements OnInit {
  driverForm;
  public driver: Driver;
 public  drivers: Driver[];

  constructor(private  formBuilder: FormBuilder, private driverService: DriverService,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {

    this.driverForm = this.formBuilder.group({
      driverName: [''],
    });
  }

  getDriver() {
     this.driverService.findDriver(this.driverForm.value.driverName).subscribe((drivers: Driver[]) => {
       console.log('got data', drivers);
       this.drivers = drivers;
    });
  }

  associateDriverToVehicle(driver: Driver) {
    this.driverService.associateDriverToVehicle(driver);
  }
}
