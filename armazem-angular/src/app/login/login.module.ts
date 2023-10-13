import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../share/app-material/app-material.module';
import { SharedModule } from '../share/share.module';
import { LoginRoutingModule } from './login-routing.module';


@NgModule({
  declarations: [
   ],
  imports: [
    CommonModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule,
    LoginRoutingModule,
    FormsModule
  ]
})
export class LoginModule { }
