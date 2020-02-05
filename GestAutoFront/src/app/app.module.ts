import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VehicleFormComponent } from './vehicle-form/vehicle-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { DriverAddComponent } from './driver-add/driver-add.component';
import {DriverService} from './driver-add/driver.service';
import { DriverFindComponent } from './driver-find/driver-find.component';
import { DriverResultComponent } from './driver-find/driver-result/driver-result.component';
import { VehicleFindComponent } from './vehicle-form/vehicle-find/vehicle-find.component';
import { MissionAddComponent } from './mission-add/mission-add.component';
import { DriverToMissionComponent } from './driver-to-mission/driver-to-mission.component';


@NgModule({
  declarations: [
    AppComponent,
    VehicleFormComponent,
    DriverAddComponent,
    DriverFindComponent,
    DriverResultComponent,
    VehicleFindComponent,
    MissionAddComponent,
    DriverToMissionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    DriverService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
