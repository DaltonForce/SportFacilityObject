import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { UserService } from 'src/_services/user.service';
import { User } from 'src/_models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm!: FormGroup;
  loading = false;
  submitted = false;

  constructor(private userService: UserService, private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      email: ['', Validators.required],
      username: ['', Validators.required],
      age: ['', Validators.required],
      password: ['', [Validators.required, Validators.minLength(1)]],
    });
  }

 
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.registerForm.invalid) {
      return;
    }

    this.loading = true;
    this.userService.register(this.registerForm.value)
      .pipe(first())
      .subscribe(
        data => {
          console.log(this.registerForm.value)
          this.router.navigate(['/user']
          )}
      )}
}
