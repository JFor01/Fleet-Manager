import {Driver} from "./Driver"
import {Car} from './Car';
import {Indexable} from './Indexable';


export type Status = "COMMENCING" | "ACTIVE" | "FINISHED";

export interface Trip extends Indexable {
  driver: Driver;
  car : Car;
  status : Status;
  destination : string;
  origin : string;
}

export type TripRequest = {
  id : number;
  driverId : number;
  carId : number;
  destination : string;
  origin : string;
}
