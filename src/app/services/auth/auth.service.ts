import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
// import { Router } from '@angular/router';
// import { Observable, of, throwError } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  logout() {
    localStorage.removeItem('token');
    this.router.navigate(['login']);
  }
 

  constructor(private router:Router) { }
  public setRoles(roles: []) {
    localStorage.setItem('roles', JSON.stringify(roles));
  }

  public getRoles(): [] {
 return JSON.parse(localStorage.getItem('roles')!);
   }

  public setToken(jwtToken: string): void {
    localStorage.setItem('jwtToken', jwtToken);
  }

  public getToken(): string {
     return localStorage.getItem('jwtToken')!;
  }

  public clear() {
    localStorage.clear();
    
  }

  public isLoggedIn() {
    return this.getRoles() && this.getToken();
  }
  // setToken(token: string): void {
  //   localStorage.setItem('token', token);
  // }

  // getToken(): string | null {
  //   return localStorage.getItem('token');
  // }

  // isLoggedIn() {
  //   return this.getToken() !== null;
  // }

  // logout() {
  //   localStorage.removeItem('token');
  //   this.router.navigate(['login']);
  // }

  // login({ email, password }: any): Observable<any> {
  //   if (email === 'admin@gmail.com' && password === 'admin123') {
  //     this.setToken('abcdefghijklmnopqrstuvwxyz');
  //     return of({ name: 'Mrityunjay', email: 'admin@gmail.com' });
  //   }
  //   return throwError(new Error('Failed to login'));
  // }
}
