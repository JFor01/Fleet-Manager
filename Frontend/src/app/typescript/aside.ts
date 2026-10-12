import {Component, inject, signal} from '@angular/core';
import {DriverService} from './services/DriverService';
import {toSignal} from '@angular/core/rxjs-interop'
import {CarrService} from './services/CarService';



@Component({
  selector : "Left-bar",
  templateUrl : "../html/app.aside.html",
  styleUrl : "../../styles.css"

})
export class Aside{
  title = "Aside";
  driverService  = inject(DriverService);
  carService  = inject(CarrService);
  protected drivers = this.driverService.drivers;
  protected cars = this.carService.cars;

}
