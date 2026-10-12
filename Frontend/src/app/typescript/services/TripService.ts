import {inject, Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Trip} from '../entities/Trip';
import {TripRequest} from '../entities/Trip';
import {toSignal} from '@angular/core/rxjs-interop';


@Injectable({providedIn : "root"})
export class TripService{
  private http : HttpClient = inject(HttpClient);
  private url : string = "/api/driver";
  public trips = toSignal(this.getAll(), {initialValue : []})





  private getAll() : Observable<Trip[]>{
    return this.http.get<Trip[]>(this.url);
  }
  private getById(id : number) : Observable<Trip>{
    return this.http.get<Trip>(`${this.url}/${id}`);
  }
  private create(trip : TripRequest):Observable<Trip>{
    return this.http.post<Trip>(this.url,trip
    );
  }

  delete(id : number) : Observable<void>{
    return this.http.delete<void>(`${this.url}/${id}`);
  }

}
