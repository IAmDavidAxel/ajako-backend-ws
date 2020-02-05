import {Component, Input, OnInit} from '@angular/core';
import {DriverService} from '../driver-add/driver.service';
import {Driver} from '../driver-find/Driver';

@Component({
  selector: 'app-driver-to-mission',
  template : '<app-driver-find></app-driver-find>',
  styleUrls: ['./driver-to-mission.component.sass']
})
export class DriverToMissionComponent implements OnInit {

  @Input() driver: Driver;
  constructor(private driverService: DriverService) { }

  ngOnInit() {

  }

}
