import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Trip} from '../entities/Trip';
import {TripRequest} from '../entities/Trip';
import {toSignal} from '@angular/core/rxjs-interop';
import {Driver} from '../entities/Driver';
import {Car} from '../entities/Car';
import {updateEntity} from '../utils/list';
import {DriverService} from './DriverService';
import {CarrService} from './CarService';


@Injectable({providedIn : "root"})
export class TripService{
  private http : HttpClient = inject(HttpClient);
  private url : string = "/api/trip";
  private driverService = inject(DriverService);
  private carService = inject(CarrService);
  private _trips = signal<Trip[]>([]) ;
  readonly trips = this._trips.asReadonly();
  constructor() {
    this.getAll().subscribe(t => this._trips.set(t));
  }

  public start(id :number){
    this.http.post<Trip >(`${this.url}/start/${id}`, null).subscribe(
      response => {
        this._trips.update(list => updateEntity<Trip>(response,list));
        this.driverService.updateDriver(response.driver);
        this.carService.updateCar(response.car);
      }
    )
  }
  public finish(id : number){
    this.http.post<Trip>(`${this.url}/end/${id}`,null).subscribe(
      response => {
        this._trips.update(list => updateEntity<Trip>(response, list));
        this.driverService.updateDriver(response.driver);
        this.carService.updateCar(response.car);
      }
    )
  }


  private getAll() : Observable<Trip[]>{
    return this.http.get<Trip[]>(`${this.url}/order`);
  }
  private getById(id : number) : Observable<Trip>{
    return this.http.get<Trip>(`${this.url}/${id}`);
  }
  public plan(trip : Omit<TripRequest, 'id'>){
    return this.http.post<Trip>(this.url,trip
    ).subscribe(response =>{ this._trips.update(list => [...list, response])});
  }

  delete(id : number) : Observable<void>{
    return this.http.delete<void>(`${this.url}/${id}`);
  }

}
