import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { AppMaterialModule } from '../share/app-material/app-material.module';
import { EstoqueRoutingModule } from './estoque-routing.module';
import { EstoqueComponent } from './estoque/estoque.component';
import { EstoqueListComponent } from './Components/estoque-list/estoque-list.component';



@NgModule({
  declarations: [
    EstoqueComponent,
    EstoqueListComponent
  ],
  imports: [
    CommonModule,
    EstoqueRoutingModule,
    AppMaterialModule,
  ]
})
export class EstoqueModule { }
