import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Injectable } from '@angular/core';
import { AuthService } from '../auth.service';
import { Usuario } from '../usuario';

@Injectable({
  providedIn: 'root'
})

export class loginResolver implements Resolve<Usuario>{

  constructor(private service: AuthService){ }

  resolve(route:ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Usuario>{
    if (route.params && route.params['cod']){
      return this.service.loadById(route.params['cod']);
    }
    return of ({id: '', cod:'', nome: '', nvAcesso:''});
  }
}
