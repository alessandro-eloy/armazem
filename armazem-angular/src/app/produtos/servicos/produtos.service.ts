import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Produtos } from './../model/produtos';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  private readonly API = "/assets/produtos.json";

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Produtos[]>(this.API)
    .pipe(
      first(),
      delay(5000),
      tap(produtos => console.log(produtos))
    );
  }
}