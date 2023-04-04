import { Component, OnInit } from '@angular/core';
import { NgForm , FormGroup, FormControl, Validators , FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import {SignupService} from '../../services/signup.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
alert:boolean=false;
  registerForm = new FormGroup({
    userName: new FormControl('',Validators.required),
    email: new FormControl('',[Validators.required,Validators.email]),
    password: new FormControl('',[Validators.required,Validators.minLength(4)]),
  });
  users:any;
  constructor( private SignupService:SignupService) { 
    //  this.SignupService.getUser().subscribe((data)=>{
    //    this.users = data;
    //  })
  }

  ngOnInit(): void {
  }

  sendUserFormData(data:any)
  {
    console.warn(data)
    this.SignupService.postUser(data).subscribe((result) =>{
      this.alert=true;
      this.registerForm.reset('');
    })
   
  }

  closeAlert()
  {
    this.alert = false;
  }

}
