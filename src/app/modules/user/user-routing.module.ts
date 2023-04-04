import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { UserWorkSpaceComponent } from './components/user-work-space/user-work-space.component';
 
const routes: Routes = [
{
    path: '',
    component: UserDashboardComponent,
    children: [
      {path:'workspace',component:UserWorkSpaceComponent},
      { path:'header',component: HeaderComponent},
      { path:'footer',component: FooterComponent},
      { path: '', redirectTo: '/user/workspace', pathMatch: 'full' },
    ],
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UserRoutingModule { }
