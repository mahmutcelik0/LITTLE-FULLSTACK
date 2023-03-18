import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent {
  users:Observable<any>;
  email:any;

  constructor(private service:UserRegistrationService){
    this.users = new Observable
    
  }

  ngOnInit(){
    this.users = this.service.getUsers();
  }

  deleteSelected(email:string){
    this.users = this.service.deleteUser(email);
  }

  searchMethod(){
    console.log(this.email)
    if(this.email ===undefined || this.email === "" || this.email ===false) this.users = this.service.getUsers();
    else {
      console.log("entered")
      this.users = this.service.getUserByEmail(this.email);
    }
  }

}