import { Component } from '@angular/core';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-search-delete',
  templateUrl: './search-delete.component.html',
  styleUrls: ['./search-delete.component.css']
})
export class SearchDeleteComponent {
  users:any;
  email:any;

  constructor(private service:UserRegistrationService){

  }

  ngOnInit(){
    this.service.getUsers().subscribe(res=>this.users = res);
  }

  deleteSelected(email:string){
    this.service.deleteUser(email).subscribe(res =>{
      console.log(res);
      this.users = res;
    })
  }

  searchMethod(){
    console.log(this.email)
    if(this.email ===undefined || this.email === "" || this.email ===false) this.service.getUsers().subscribe(res=>this.users = res);
    else this.service.getUserByEmail(this.email).subscribe(res => this.users =res);
  }

}