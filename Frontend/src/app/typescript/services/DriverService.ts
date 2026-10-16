import {inject, Injectable, signal} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Driver, DriverRequest} from '../entities/Driver';
import {toSignal} from '@angular/core/rxjs-interop';
import {Car} from '../entities/Car';
import {updateEntity} from '../utils/list';


@Injectable({providedIn : "root"})
export class DriverService{
    private http : HttpClient = inject(HttpClient);
    private url : string = "/api/driver";
    private _drivers = signal<Driver[]>([]);
    public drivers = this._drivers.asReadonly();

    constructor() {
      this.getAll().subscribe(response =>this._drivers.set(response)
      )
    }


  public updateDriver(driver: Driver){
    this._drivers.update(list => updateEntity(driver,list));
  }

  public appendDriver(driver :Driver){
      this._drivers.update(list =>[...list,driver] )
  }


   private getAll() : Observable<Driver[]>{
      return this.http.get<Driver[]>(this.url);
}

   private getById(id : number) : Observable<Driver>{
      return this.http.get<Driver>(`${this.url}/${id}`);
    }
   public add(driver : Omit<Driver, "id">):Observable<Driver>{
      return this.http.post<Driver>(this.url,driver);
    }

    delete(id : number) : Observable<void>{
      return this.http.delete<void>(`${this.url}/${id}`);
    }

}
