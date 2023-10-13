import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';
import { Estoque } from 'src/app/estoque/model/estoque';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private readonly API = "api/estoque";

  constructor(private httpClient: HttpClient) { }

  save(record: Partial<Estoque>){
    if(record.usuario){
      return this.findById(record);
    }
    return this.create(record);
  }

  private create(record: Partial<Estoque>){
    return this.httpClient.post<Estoque>(this.API, record).pipe(first());
  }

  findById(record: Partial<Estoque>){
    return
  }
}
