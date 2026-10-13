import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import {Component, inject, signal} from '@angular/core';
import {DriverService} from './services/DriverService';
import {CarrService} from './services/CarService';
import {TripService} from './services/TripService';

@Component({
  selector: 'trip-form',
  imports: [ReactiveFormsModule],
  templateUrl: '../html/app.trip-form.html'
})
export class TripForm {
  driverService =inject(DriverService);
  carService = inject(CarrService);
  tripService = inject(TripService);
  drivers = this.driverService.drivers;
  cars = this.carService.cars;
  private fb = inject(FormBuilder).nonNullable;
  message = signal("");

  form = this.fb.group({
    driverId: this.fb.control<number | null>(null, Validators.required),
    carId: this.fb.control<number | null>(null, Validators.required),
    origin: this.fb.control("", Validators.required),
    destination: this.fb.control("",Validators.required)
  });

  plan() {
    if(this.form.invalid){
      this.message.set("Please provide origin and destination")
      this.form.reset();
      return;
    }
    const trip = this.form.getRawValue();
    this.message.set(`Driver ${trip.driverId} with car ${trip.carId} from ${trip.origin} to ${trip.destination}` );
    if (trip.driverId == null || trip.carId == null) {
      this.message.set('Select a driver and a car');
      return;
    }
    this.tripService.plan({driverId : trip.driverId,
                           carId : trip.carId, destination : trip.destination,
                          origin : trip.origin
    })
  }

}
