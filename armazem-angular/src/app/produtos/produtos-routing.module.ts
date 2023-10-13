import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ProdutosFormComponent } from './Containers/produtos-form/produtos-form.component';
import { ProdutosComponent } from './Containers/produtos/produtos.component';
import { produtoResolver } from './guards/produto.resolver';

const routes: Routes = [
  { path: "", component: ProdutosComponent},
  { path: "new", component: ProdutosFormComponent, resolve:{ produto:produtoResolver}},
  { path: "edit/:codigo", component: ProdutosFormComponent, resolve:{ produto:produtoResolver}}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutosRoutingModule { }
