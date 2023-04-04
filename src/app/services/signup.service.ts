import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class SignupService {

 
  url= "http://localhost:8081/api/v2";

  constructor(private http:HttpClient) { }

 
  postUser(data:any)
  {
    return this.http.post(this.url+'/register',data);
  }

  // getUser()
  // {
  //   return this.http.get(this.url + '/employees');
  // }
}
