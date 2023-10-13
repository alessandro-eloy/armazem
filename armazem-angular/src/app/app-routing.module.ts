import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'produtos', loadChildren: () => import('./produtos/produtos.module').then(m => m.ProdutosModule)},
  {path: 'estoque', loadChildren: () => import('./estoque/estoque.module').then(m => m.EstoqueModule)},
  {path: 'home', loadChildren: () => import('./home/home.module').then(m => m.HomeModule)},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
