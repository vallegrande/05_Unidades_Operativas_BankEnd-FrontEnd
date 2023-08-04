import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, RetryConfig, map } from 'rxjs';
import { UnitModel } from '../model/unit-model';

@Injectable({
  providedIn: 'root'
})
export class UnitService {

  constructor(private httpClient: HttpClient) { 

  }

  getUnits(): Observable<UnitModel[]>{
    return this.httpClient.get<UnitModel[]>('http://localhost:8080/ms-soa').pipe(map(res => res));
  }

  saveUnits(request: any): Observable<any>{
    return this.httpClient.post<any>('http://localhost:8080/ms-soa', request).pipe(map(resp => resp));
  }

  updateUnits(request: any): Observable<any> {
    return this.httpClient.post<any>('http://localhost:8080/ms-soa', request).pipe(map(resp => resp));
  }

  deleteUnits(id: number): Observable<any> {
    return this.httpClient.delete<any>('http://localhost:8080/ms-soa/'+ id).pipe(map(resp => resp));
  }

}











