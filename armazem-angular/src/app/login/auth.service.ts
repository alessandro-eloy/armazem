import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn:'root'
})

export class AuthService {

  constructor(private httpClient: HttpClient){}

  private readonly API = "api/usuarios";

  loginUsuario(objeto:any){
    return this.httpClient.post<any>(
      `${this.API}/CriarTokenIdentity/`,objeto);
  }


}
