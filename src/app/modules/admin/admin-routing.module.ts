import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { BoardComponent } from './components/board/board.component';
import { CardComponent } from './components/card/card.component';
import { WorkspaceComponent } from './components/workspace/workspace.component';

const routes: Routes = [
{
    path: '',
    component: AdminDashboardComponent,
    children: [
      { path:'workspace', component:WorkspaceComponent},
      { path: '', redirectTo: '/admin/workspace', pathMatch: 'full' },
      { path: 'addBoard' , component:BoardComponent},
      { path: 'addCard' , component: CardComponent}
     ],
  },

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
