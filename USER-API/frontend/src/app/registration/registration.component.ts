import { Component } from '@angular/core';
import { User } from '../user';
import { UserRegistrationService } from '../user-registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  user:User = new User();

  message:any;

  constructor(private userService:UserRegistrationService){

  }

  registerButtonClicked(){
    this.userService.postUser(this.user).subscribe(res =>this.message = res);
  }

}
