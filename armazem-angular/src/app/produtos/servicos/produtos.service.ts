import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Produtos } from './../model/produtos';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProdutosService {

  private readonly API = "api/produtos";

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Produtos[]>(this.API)
    .pipe(
      first(),
      delay(3000),
      tap(produtos => console.log(produtos))
    );
  }

  loadById(id:string){
    return this.httpClient.get<Produtos>(`${this.API}/${id}`);
  }

  save(record: Partial<Produtos>){
    return this.httpClient.post<Produtos>(this.API, record).pipe(first());
  }
}
