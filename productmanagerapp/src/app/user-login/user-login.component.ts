import { Component } from '@angular/core';
import { LoginUserService } from '../loginuser.services';
import { User } from '../user';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent
{
  user: User;
  constructor(private loginUserService: LoginUserService)
  {
    this.user = new User();
  }

  userLogin()
  {
    console.log(this.user)
    this.loginUserService.loginUser(this.user).subscribe(data=>{
      alert("Login success")
    }, error=>alert("User was not found"));
  }
}
