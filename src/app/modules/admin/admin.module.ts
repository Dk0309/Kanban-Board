import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminDashboardComponent } from './components/admin-dashboard/admin-dashboard.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { WorkspaceComponent } from './components/workspace/workspace.component';
import {FormsModule,ReactiveFormsModule} from '@angular/forms';   
import { DragDropModule } from '@angular/cdk/drag-drop';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatDialogModule } from '@angular/material/dialog';
import { SidenavComponent } from './components/sidenav/sidenav.component';
import { MatMenuModule} from '@angular/material/menu';
import { MatListModule } from '@angular/material/list';
import { MatSidenavModule } from '@angular/material/sidenav';
import { BoardComponent } from './components/board/board.component';
import { CardComponent } from './components/card/card.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatCardModule} from '@angular/material/card';
import {MatTabsModule} from '@angular/material/tabs';
import {MatCheckboxModule} from '@angular/material/checkbox';
import { MatSelectModule } from '@angular/material/select';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import { MatDividerModule } from '@angular/material/divider';
 @NgModule({
  declarations: [ 
    AdminDashboardComponent,
    HeaderComponent,
    FooterComponent,
    WorkspaceComponent,
    SidenavComponent,
    BoardComponent,
    CardComponent,
    
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatIconModule,
    MatButtonModule,
    DragDropModule,
    MatExpansionModule,
    MatToolbarModule,
    MatDialogModule,
    MatMenuModule,
    MatListModule,
    MatSidenavModule,
    MatFormFieldModule,
    MatCardModule,
    MatTabsModule,
    MatCheckboxModule,
    MatSelectModule,
    MatProgressBarModule,
    MatDividerModule
  ],
})
export class AdminModule { }
