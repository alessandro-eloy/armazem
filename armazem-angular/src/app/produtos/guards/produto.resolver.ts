import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Produtos } from '../model/produtos';
import { ProdutosService } from '../servicos/produtos.service';

export class produtoResolver implements Resolve<Produtos>{

  constructor(private service: ProdutosService){ }

  resolve(route:ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Produtos>{
    if (route.params && route.params['id']){
      return this.service.loadById(route.params['id']);
    }
    return of ({id: '', codigo:'', nome: '', quantidade:''});
  }
}
