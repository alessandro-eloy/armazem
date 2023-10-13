import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Produtos } from '../model/produtos';
import { ProdutosService } from '../servicos/produtos.service';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class produtoResolver implements Resolve<Produtos>{

  constructor(private service: ProdutosService){ }

  resolve(route:ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Produtos>{
    if (route.params && route.params['codigo']){
      return this.service.loadById(route.params['codigo']);
    }
    return of ({id: '', codigo:'', nome: '', quantidade:''});
  }
}
