import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { NonNullableFormBuilder } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';

import { ProdutosService } from '../../servicos/produtos.service';
import { Produtos } from '../../model/produtos';

@Component({
  selector: 'app-produtos-form',
  templateUrl: './produtos-form.component.html',
  styleUrls: ['./produtos-form.component.scss']
})
export class ProdutosFormComponent implements OnInit {

  form = this.formBuilder.group({
    id:[""],
    nome: [""],
    codigo: [""]
  });

  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: ProdutosService,
    private _snackBar: MatSnackBar,
    private location: Location,
    private route: ActivatedRoute){
  }

  ngOnInit(): void {
    const produto: Produtos = this.route.snapshot.data['produto'];
    this.form.setValue({
      id: produto.id,
      nome: produto.nome,
      codigo: produto.codigo
     });
  }

  onSubmit(){
    this.service.save(this.form.value)
    .subscribe(result => this.onSuccess(), error => this.onError());
  }

  onCancel(){
    this.location.back();
  }

  private onSuccess(){
    this._snackBar.open("Produto Salvo com Sucesso!", " ", {duration: 3000});
    this.onCancel();
  }

  private onError(){
    this._snackBar.open("Erro ao salvar.", "X", {duration: 3000});
  }

}
