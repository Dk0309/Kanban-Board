import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { LoginComponent } from './components/login/login.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { SignupComponent } from './components/signup/signup.component';
import { AuthGuard } from './guard/auth.guard';

const routes: Routes = [
  {
    path:'',
    component : SignupComponent, 
  },
  {
    path: 'login',
    component : LoginComponent
  },
  { 
    path:'forgot-password',
    component:ForgotPasswordComponent
  },
  {
    path: 'admin',
    canActivate: [AuthGuard],
    data:{roles:['Admin']},
    loadChildren: () =>
      import('./modules/admin/admin.module').then((m) => m.AdminModule),
  },
  {
    path:'user',
    canActivate:[AuthGuard],
    data:{roles:['User']},
    loadChildren: () =>
     import ('./modules/user/user.module').then((m)  => m.UserModule), 
  },
  {
    path:'**',
    component:PageNotFoundComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
