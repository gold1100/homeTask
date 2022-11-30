import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class SorterService {

  private API_URL = "http://localhost:8080/numbers/sort";

  constructor(private http: HttpClient) {}

  public postSort(array : Array<number>, order : string){
     return this.http.post<any>(this.API_URL, {"numbers": array, "order": order})
  }

  private async makePostRequest(){

  }
}
