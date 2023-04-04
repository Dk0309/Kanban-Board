import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { FormControl, FormGroup } from '@angular/forms';
import { faLock } from '@fortawesome/free-solid-svg-icons';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  faLock = faLock;
  loginForm = new FormGroup({
    userName: new FormControl(''),
    password: new FormControl(''),
  });
  constructor(private router: Router, private auth: AuthService,private userService: UserService,) { }

  ngOnInit(): void {
    // if (this.auth.isLoggedIn()) {
    //   this.router.navigate(['admin']);
    // }
  }

//   onSubmit(): void {
//     if (this.loginForm.valid){
//       this.auth.login(this.loginForm.value).subscribe(
//         (result) => {
//           console.log(result);
//           this.router.navigate(['/admin']);
//         },
//         (err: Error) => {
//           alert(err.message);
//         }
//       );
// }
onSubmit(): void {
  this.userService.login(this.loginForm.value).subscribe(
    (response: any) => {
      this.auth.setRoles(response.user.role);
      this.auth.setToken(response.jwtToken);

      const role = response.user.role[0].roleName;
      if (role === 'Admin') {
        this.router.navigate(['/admin']);
      } else {
        this.router.navigate(['/user']);
      }
    },
    (error: any) => {
      console.log(error);
    }
  );
}

}
