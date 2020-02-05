import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {MissionServiceService} from './mission-service.service';

@Component({
  selector: 'app-mission-add',
  templateUrl: './mission-add.component.html',
  styleUrls: ['./mission-add.component.sass']
})
export class MissionAddComponent implements OnInit {
  missionForm;

  constructor(private formBuilder: FormBuilder, private missionService: MissionServiceService) { }

  ngOnInit() {
    this.missionForm = this.formBuilder.group({
      order_number: [''],
      mission_description: [''],
      driver_name: [],
      plate_number: [],
      location: [''],
      mission_start_date: [''],
      mission_end_date: [''],
      driver_companion: [''],
      mean_of_transport: ['']
      }
    );
  }

  onSubmit() {
    this.missionService.addMission(this.missionForm.value).subscribe();
  }

}
