import {Driver} from "./Driver"
import {Car} from './Car';

export type Trip = {
  id : number;
  driver: Driver;
  car : Car;
  status : number;
  destination : string;
  origin : string;
}

export type TripRequest = {
  driverId : number;
  carId : number;
  destination : string;
  origin : string;
}
