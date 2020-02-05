import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {VehicleFormComponent} from './vehicle-form/vehicle-form.component';
import {DriverAddComponent} from './driver-add/driver-add.component';
import {DriverFindComponent} from './driver-find/driver-find.component';
import {VehicleFindComponent} from './vehicle-form/vehicle-find/vehicle-find.component';
import {MissionAddComponent} from './mission-add/mission-add.component';
import {DriverResultComponent} from './driver-find/driver-result/driver-result.component';
import {DriverToMissionComponent} from './driver-to-mission/driver-to-mission.component';


const routes: Routes = [
  {path: ' ', component: VehicleFormComponent},
  {path: 'addVehicle', component: VehicleFormComponent},
  {path: 'addDriver' , component: DriverAddComponent},
  {path: 'findDriver' , component: DriverFindComponent},
  {path: 'findVehicle', component: VehicleFindComponent},
  {path: 'createMission', component: MissionAddComponent},
  {path: 'driver/results', component: DriverResultComponent},
  {path: 'findDriver/sendToMission' , component: DriverToMissionComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
