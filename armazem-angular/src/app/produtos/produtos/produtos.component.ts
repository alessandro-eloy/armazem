import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';

import { Produtos } from '../model/produtos';
import { ProdutosService } from '../serviços/produtos.service';

@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.scss']
})
export class ProdutosComponent implements OnInit{

  produtos: Observable <Produtos[]> ;
  displayedColumns = ['id', 'nome']

  //produtosService:ProdutosService;

  constructor(private produtosService:ProdutosService){
    //this.produtos = []
    //this.produtosService = new ProdutosService();
    this.produtos = this.produtosService.list();
  }

  ngOnInit(): void {
  }

}
