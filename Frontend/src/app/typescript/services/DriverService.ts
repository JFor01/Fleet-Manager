import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Driver} from '../entities/Driver';
import {toSignal} from '@angular/core/rxjs-interop';


@Injectable({providedIn : "root"})
export class DriverService{
    private http : HttpClient = inject(HttpClient);
    private url : string = "/api/driver";
    public drivers = toSignal(this.getAll(), {initialValue : []})





   private getAll() : Observable<Driver[]>{
      return this.http.get<Driver[]>(this.url);
}
   private getById(id : number) : Observable<Driver>{
      return this.http.get<Driver>(`${this.url}/${id}`);
    }
   private create(driver : Omit<Driver,'id'>):Observable<Driver>{
      return this.http.post<Driver>(this.url,driver
        );
    }

    delete(id : number) : Observable<void>{
      return this.http.delete<void>(`${this.url}/${id}`);
    }

}
