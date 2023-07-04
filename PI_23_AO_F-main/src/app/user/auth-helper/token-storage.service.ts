import { Injectable } from '@angular/core';

const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';
const USER_KEY_ROLE = 'auth-user-role';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {

  constructor() { }

  signOut() {
    window.sessionStorage.clear();
  }

  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }

  public getToken(): any {
    return sessionStorage.getItem(TOKEN_KEY);
  }
  public getRole(): any {
    return sessionStorage.getItem(USER_KEY_ROLE);
  }

  public saveUser(user: any) {
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, user);
  }

  isAdmin(): boolean {
   const  role = sessionStorage.getItem(USER_KEY_ROLE);
   if(role=="ADMIN")
   { return true }
   else

    return  false;
  }

  public saveUserRole(role: any) {
    window.sessionStorage.removeItem(USER_KEY_ROLE);
    window.sessionStorage.setItem(USER_KEY_ROLE, role);
  }
  public getUser():any {
    return JSON.parse(sessionStorage.getItem(USER_KEY)|| '{}');
  }
  
  getAuthStatus(): boolean {
    let isAuthenticated: boolean;
  
    if (sessionStorage.getItem(TOKEN_KEY) != null) {
      isAuthenticated = true;
    } else {
      isAuthenticated = false;
    }
  
    return isAuthenticated;
  }
}