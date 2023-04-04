import { Component, OnInit,EventEmitter,Output } from '@angular/core';
import { AuthService } from 'src/app/services/auth/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Output() toggleSidebarForMe: EventEmitter<any> = new EventEmitter();
  constructor(private auth: AuthService,private router: Router) { }

  ngOnInit(): void {
    
  }
  toggleSidebar() {
    this.toggleSidebarForMe.emit();
  }
  sideBarOpen = true;

  sideBarToggler() {
    this.sideBarOpen = !this.sideBarOpen;
  }
  logout(): void {
    this.auth.logout();
  }
}


