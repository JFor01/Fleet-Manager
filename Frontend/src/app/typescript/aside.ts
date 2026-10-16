import {Component, inject, signal} from '@angular/core';
import {DriverService} from './services/DriverService';
import {toSignal} from '@angular/core/rxjs-interop'
import {CarrService} from './services/CarService';
import {AddDriversForm} from './app.add.drivers';


@Component({
  selector : "Left-bar",
  templateUrl : "../html/app.aside.html",
  styleUrl : "../../styles.css",
  imports : [AddDriversForm]

})
export class Aside{
  title = "Aside";
  driverService  = inject(DriverService);
  carService  = inject(CarrService);
  protected drivers = this.driverService.drivers;
  protected cars = this.carService.cars;

}
