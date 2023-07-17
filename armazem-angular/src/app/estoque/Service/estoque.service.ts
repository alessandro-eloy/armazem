import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Estoque } from './../model/estoque';
import { delay, first, tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class EstoqueService {

private readonly API = "api/estoque";

  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Estoque[]>(this.API)
    .pipe(
      first(),
      delay(3000),
      tap(estoque => console.log(estoque))
    );
  }

  loadById(id:string){
    return this.httpClient.get<Estoque>(`${this.API}/${id}`);
  }

  save(record: Partial<Estoque>){
    if(record.id){
      return this.update(record);
    }
    return this.create(record);
  }

  private create(record: Partial<Estoque>){
    return this.httpClient.post<Estoque>(this.API, record).pipe(first());
  }

  private update(record: Partial<Estoque>){
    return this.httpClient.put<Estoque>(`${this.API}/${record.id}`,record).pipe(first());
  }

  remove(id:string){
    return this.httpClient.delete(`${this.API}/${id}`).pipe(first());
  }
}
