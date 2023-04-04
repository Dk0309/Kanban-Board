import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { SignupComponent } from './components/signup/signup.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ForbiddenComponent } from './components/forbidden/forbidden.component';
import { AuthGuard } from './guard/auth.guard';
import { AuthInterceptor } from './guard/auth.interceptor';
import { UserService } from './services/user.service';
import { SignupService } from './services/signup.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {AdminModule} from './modules/admin/admin.module';
import { ForgotPasswordService } from './services/forgot-password.service';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ForgotPasswordComponent,
    PageNotFoundComponent,
    SignupComponent,
    ForbiddenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FontAwesomeModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    AdminModule
  ],
  providers: [AuthGuard,
    {
      provide: HTTP_INTERCEPTORS,
      useClass:AuthInterceptor,
      multi:true
    },
    UserService,SignupService,ForgotPasswordService],
  bootstrap: [AppComponent]
})
export class AppModule { }
