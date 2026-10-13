import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Car, CarRequest} from '../entities/Car';
import {toSignal} from '@angular/core/rxjs-interop';
import {updateEntity} from '../utils/list';


@Injectable({providedIn : "root"})
export class CarrService{
  private http : HttpClient = inject(HttpClient);
  private url : string = "/api/car";
  private _cars = signal<Car[]>([]);
  public cars = this._cars.asReadonly();


  constructor() {
    this.getAll().subscribe(created => this._cars.set(created));
  }

  public updateCar(car : Car){
    this._cars.update(list => updateEntity(car,list));
  }

  private getAll() : Observable<Car[]>{
    return this.http.get<Car[]>(this.url);
  }
  private getById(id : number) : Observable<Car>{
    return this.http.get<Car>(`${this.url}/${id}`);
  }
  private create(driver : Omit<Car,'id'>):Observable<Car>{
    return this.http.post<Car>(this.url,driver
    );
  }

  delete(id : number) : Observable<void>{
    return this.http.delete<void>(`${this.url}/${id}`);
  }

}
