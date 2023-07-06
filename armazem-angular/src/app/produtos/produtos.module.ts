import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppMaterialModule } from '../share/app-material/app-material.module';
import { SharedModule } from '../share/share.module';
import { ProdutosFormComponent } from './Containers/produtos-form/produtos-form.component';
import { ProdutosRoutingModule } from './produtos-routing.module';
import { ProdutosComponent } from './Containers/produtos/produtos.component';
import { ProdutosListComponent } from './Components/produtos-list/produtos-list.component';




@NgModule( {
  declarations: [
    ProdutosComponent,
    ProdutosFormComponent,
    ProdutosListComponent
  ],
  imports: [
    CommonModule,
    ProdutosRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule
  ]
})
export class ProdutosModule { }
