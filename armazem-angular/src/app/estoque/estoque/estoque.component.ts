import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { ErroDialogComponent } from 'src/app/share/components/erro-dialog/erro-dialog.component';

import { Estoque } from '../model/estoque';
import { EstoqueService } from '../Service/estoque.service';

@Component({
  selector: 'app-estoque',
  templateUrl: './estoque.component.html',
  styleUrls: ['./estoque.component.scss']
})
export class EstoqueComponent {
  estoque$: Observable <Estoque[]> | null = null;

  constructor(
    private estoqueService: EstoqueService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private _snackBar: MatSnackBar,
    ){
      this.refresh();
  }

  refresh(){
    this.estoque$ = this.estoqueService.list()
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
}
