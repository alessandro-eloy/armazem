import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { AuthService } from '../auth.service';



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit{

  hide = true;

  username: any;
  password : any;
  errorMessage = 'Invalid Credentials';
  successMessage: any;
  invalidLogin = false;
  loginSuccess = false;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private auth: AuthService) {   }

  ngOnInit() {
  }

  handleLogin() {
    this.auth.authService(this.username, this.password).subscribe((result)=> {
      this.invalidLogin = false;
      this.loginSuccess = true;
      this.successMessage = 'Login Successful.';
      this.router.navigate(['/hello-world']);
    }, () => {
      this.invalidLogin = true;
      this.loginSuccess = false;
    });
  }
}
