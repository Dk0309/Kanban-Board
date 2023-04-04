import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { faLock } from '@fortawesome/free-solid-svg-icons';
import { ForgotPasswordService } from 'src/app/services/forgot-password.service';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit {

  faLock = faLock;
  constructor(private emailService:ForgotPasswordService) { }

  ngOnInit(): void {
  }
  sendEmail(passwordForm:NgForm)
  {
    console.log(passwordForm.value.email);
    this.emailService.getMail(passwordForm.value).subscribe(data =>{
        console.log(data + "email send successfully");    
    })
    passwordForm.reset();
   
  }
}
