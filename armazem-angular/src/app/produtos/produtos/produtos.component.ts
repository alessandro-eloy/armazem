import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErroDialogComponent } from 'src/app/share/components/erro-dialog/erro-dialog.component';
import { CommonModule } from '@angular/common';

import { Produtos } from '../model/produtos';
import { ProdutosService } from '../serviços/produtos.service';


@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.scss']
})
export class ProdutosComponent implements OnInit{

  produto$: Observable <Produtos[]> ;
  displayedColumns = ['id', 'nome','actions']

  //produtosService:ProdutosService;

  constructor(
    private produtosService:ProdutosService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
    ){
    //this.produtos = []
    //this.produtosService = new ProdutosService();
    this.produto$ = this.produtosService.list()
    .pipe(
      catchError(error =>{
        this.onError('Erro ao carregar produtos.');
        return of ([])
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErroDialogComponent, {
      data: errorMsg,
    });
  }


  ngOnInit(): void {
  }


  onAdd(){
    const a = 5;
   console.log('erro',a);
  }

}
