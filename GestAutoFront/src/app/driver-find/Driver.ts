import {Injectable} from '@angular/core';

export class Driver {
  constructor(
  public first_name: string,
  public last_name: string,
  public id_number: string,
  public cell_phone_number: string,
  public driver_licence_number: string,
  public birth_date: string,
) {}

}

@Injectable({
  providedIn: 'root'
})

export class DriverAdapter {

  adapt(item: any): Driver {
    return new  Driver(item.first_name, item.last_name, item.id_number,
      item.cell_phone_number, item.driver_licence_number, item.birth_date);
  }
}
