import { Component, OnInit } from '@angular/core';
import { User } from 'src/_models/user';
import { UserService } from 'src/_services/user.service';

@Component({
  selector: 'app-users-list',
  templateUrl: './users-list.component.html',
  styleUrls: ['./users-list.component.css']
})
export class UsersListComponent implements OnInit {

  usersDetails: User[] = [];
  
  headers = ["ID", "Age", "Username", "Password", "Email", "Role", "Change Button"];

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.userService.getAll().subscribe(
      userService => {
        this.usersDetails = userService;
      }
    );
  }
}
