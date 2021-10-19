import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/_services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  public loggedIn !: boolean;
  public isAdmin !: boolean;
  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.loggedIn = this.authService.isAuthenticated();
    this.isAdmin = this.authService.isAdmin();
    localStorage.getItem('currentUser');
    localStorage.getItem('currentUserRole');
  }

}
