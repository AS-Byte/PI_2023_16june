import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserModel } from '../Models/user/UserModel';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  



  private baseUrl = 'http://localhost:8080/v1/auth';
  private baseUrl2 = 'http://localhost:8080/user';
  private baseUrl3 = 'http://localhost:8080/token';

  constructor(private http: HttpClient) { }

  register(request: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/register`, request);
  }

  authenticate(request: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/authenticate`, request);
  }

  confirmAccount(token: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/confirm-account?token=${token}`);
  }
  forgotPassword(email: any) {
    return this.http.post<any>(`${this.baseUrl}/forgot-password`, email);


  }


  updateCurrentUser(request: any) {
    return this.http.put<any>(`${this.baseUrl}/update-user`, request);
  }

  resetPassword(token: string, password: string):Observable<any> {
    const body = new FormData();
    body.append("token", token);
    body.append("password", password);

    return this.http.post<any>(`${this.baseUrl}/reset-password`, body);

  }
  
  getCurrentUser(email: any) {
    const params = { email };
    return this.http.get<any>(`${this.baseUrl2}/current-user`, { params });
  }

  userList(): any {

    return this.http.get<any>(`${this.baseUrl2}/user-list`);
  }

  userRestrict(request: any): any {

    return this.http.post<any>(`${this.baseUrl2}/restrict`,request);
  }

  sessionList(): any{
    return this.http.get<any>(`${this.baseUrl3}/all`)
  }
  
  dataTracking(){
    return this.http.get<any>(`${this.baseUrl2}/data`);
  }
  deleteToken(tokenId:any): any  {
    const params = { tokenId };
    return this.http.delete<any>(`${this.baseUrl3}/delete`,{ params });
  }
}
