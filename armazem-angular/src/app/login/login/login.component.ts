import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';

import { Usuario } from '../usuario';
import { AuthService } from '../auth.service';
import { Token } from '@angular/compiler';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  loginForm!:FormGroup;

  ImagePath: string;

  constructor(private router: Router,
              private _snackBar: MatSnackBar,
              private formBuilder: FormBuilder,
              private authService: AuthService) {
    this.ImagePath = '/assets/images1.jpg'
  }

  ngOnInit(): void {
   this.loginForm = this.formBuilder.group({
    login: ['',[Validators.required,]],
    senha: ['',[Validators.required,]]
   })
  }

  submitLogin(){
    var dadosLogin = this.loginForm.getRawValue() as Usuario;

    this.authService.loginUsuario(dadosLogin).subscribe(token => {
      debugger
      var nossoToken = token
      this.onSuccess()
    }, error => {
      this.onError()
    })
  }
  private onSuccess(){
    this._snackBar.open("Login efetuado com Sucesso!", " ", {duration: 3000});
  }

  private onError(){
    this._snackBar.open("Erro ao logar.", "X", {duration: 3000});
  }

}
