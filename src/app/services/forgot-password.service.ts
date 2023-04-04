import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForgotPasswordService {

  url = "http://localhost:9091/forgot_password";
  constructor(private http:HttpClient) { }


  getMail(body:any):Observable<any[]>
  {
    return this.http.post<any>(this.url,body);
  }

}
