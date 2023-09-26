import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {

  private readonly API = "api/estoque";

  constructor(private httpClient: HttpClient) { }

  findByCod(cod:string){
    return this.httpClient.delete(`${this.API}/${cod}`).pipe(first());
  }
}
