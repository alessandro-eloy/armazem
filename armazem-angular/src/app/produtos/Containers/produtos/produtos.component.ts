import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of, subscribeOn } from 'rxjs';
import { ErroDialogComponent } from 'src/app/share/components/erro-dialog/erro-dialog.component';

import { Produtos } from '../../model/produtos';
import { ProdutosService } from '../../servicos/produtos.service';


@Component({
  selector: 'app-produtos',
  templateUrl: './produtos.component.html',
  styleUrls: ['./produtos.component.scss']
})
export class ProdutosComponent implements OnInit{

  produto$: Observable <Produtos[]> | null = null;

  constructor(
    private produtosService: ProdutosService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private _snackBar: MatSnackBar,
    ){
      this.refresh();
  }

  refresh(){
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
    this.router.navigate(['new'], {relativeTo: this.route});
  }

  onEdit(produto: Produtos){
    this.router.navigate(['edit', produto.id],{relativeTo: this.route} )
  }

  onRemove(produto: Produtos){
    this.produtosService.remove(produto.id).subscribe(
      ()=>{
        this.refresh();
        this._snackBar.open("Produto deletado com sucesso!", "X", {
          duration: 3000,
          verticalPosition: 'top',
          horizontalPosition: 'center'
        });
    },
    error => this.onError("Erro ao tenter remover produto")
    );
  }

}
