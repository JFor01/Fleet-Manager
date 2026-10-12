import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Car} from '../entities/Car';
import {toSignal} from '@angular/core/rxjs-interop';


@Injectable({providedIn : "root"})
export class CarrService{
  private http : HttpClient = inject(HttpClient);
  private url : string = "/api/car";
  public cars = toSignal(this.getAll(), {initialValue : []})


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
