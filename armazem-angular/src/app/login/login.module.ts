import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../share/app-material/app-material.module';
import { SharedModule } from '../share/share.module';
import { LoginRoutingModule } from './login-routing.module';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';


@NgModule({
  providers: [
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}}
  ],
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
