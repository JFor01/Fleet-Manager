import {Component, computed, inject} from '@angular/core';
import {TripService} from './services/TripService';
import {Status, Trip} from './entities/Trip';
import {CarrService} from './services/CarService';
import {Car} from './entities/Car';
import {Driver} from './entities/Driver';
import {DriverService} from './services/DriverService';



@Component({
  selector : "Trips",
  templateUrl : "../html/app.trips.html",
  styleUrl : "../../styles.css"

})
export class Trips{
  title = "Trips"
  tripService = inject(TripService);
  trips = this.tripService.trips;
  tripLength = computed(() => this.trips().length);

  protected start(tripId: number){
      this.tripService.start(tripId);
  }

  protected finish(tripId : number ){
    this.tripService.finish(tripId);
  }

  protected readonly length = length;
}

