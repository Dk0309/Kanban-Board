import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  users:any=[]
  userName:string;
  constructor(private auth:AuthService,private signup:SignupService){}
  ngOnInit(): void {
    // this.signup.getUser().subscribe(data => {
    //      this.users = data;
    //      console.log(data);
    //      this.userName = this.users.userName;
    //      console.log(this.userName);
    // })
  }
 logout(): void {
    this.auth.logout();
  }

}
