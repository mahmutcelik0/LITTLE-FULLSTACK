import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserRegistrationService {
  

  constructor(private http: HttpClient) { }

  postUser(user:User){
    return this.http.post("http://localhost:8080/api/v1",user,{responseType:'text' as 'json'});
  }

  getUsers(){
    return this.http.get("http://localhost:8080/api/v1");
  }

  deleteUser(email:string){
    return this.http.delete("http://localhost:8080/api/v1/email/"+email);
  }

  getUserByEmail(email: any) {
    return this.http.get("http://localhost:8080/api/v1/"+email);
  }
}
