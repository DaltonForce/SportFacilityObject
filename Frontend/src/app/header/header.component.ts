import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/_services/authentication.service';
import { User } from 'src/_models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public loggedIn !: boolean;
  public isAdmin !: boolean;
  public isUser !: boolean;
  constructor(private authService: AuthenticationService, private router: Router) { }

  ngOnInit(): void {
    this.loggedIn = this.authService.isAuthenticated();
    this.isAdmin = this.authService.isAdmin();
    this.isUser = this.authService.isUser();
  }

  logout(): void {
    this.authService.logout();
    window.location.reload();
    this.router.navigate(["/"]);
  }
}
