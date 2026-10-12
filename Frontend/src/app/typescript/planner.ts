import {Component, inject} from '@angular/core';
import {DriverService} from './services/DriverService';
import {CarrService} from './services/CarService';
import {TripForm} from './TripForm';



@Component({
  selector: "Planner",
  templateUrl: "../html/app.planner.html",
  imports: [
    TripForm
  ],
  styleUrl: "../../styles.css"

})
export class Planner{
  title = "Planner"
}

