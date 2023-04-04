import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UserRoutingModule } from './user-routing.module';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { UserWorkSpaceComponent } from './components/user-work-space/user-work-space.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatTabsModule} from '@angular/material/tabs';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { MatIconModule} from '@angular/material/icon';
import { MatSelectModule } from '@angular/material/select';
import { MatToolbarModule } from '@angular/material/toolbar'
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { MatDividerModule } from '@angular/material/divider';
import {DragDropModule} from '@angular/cdk/drag-drop';

@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    UserDashboardComponent,
    UserWorkSpaceComponent
  ],
  imports: [
    CommonModule,
    UserRoutingModule,
    MatFormFieldModule,
    MatCardModule,
    MatTabsModule,
    MatInputModule,
    MatButtonModule,
    MatCheckboxModule,
    MatIconModule,
    MatSelectModule,
    MatToolbarModule,
    MatProgressBarModule,
    MatDividerModule,
    DragDropModule
  ]
})
export class UserModule { }
