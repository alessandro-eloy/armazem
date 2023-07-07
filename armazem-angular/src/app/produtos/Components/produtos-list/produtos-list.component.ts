import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Produtos } from './../../model/produtos';

@Component({
  selector: 'app-produtos-list',
  templateUrl: './produtos-list.component.html',
  styleUrls: ['./produtos-list.component.scss']
})
export class ProdutosListComponent  implements OnInit  {

  @Input() produtos: Produtos[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() remove = new EventEmitter(false);

  readonly displayedColumns = ['codigo', 'nome', 'quantidade','actions']

  constructor(

  ){ }

  ngOnInit(): void {
  }

  onAdd(){
    this.add.emit(true);
  }

  onEdit(produto: Produtos){
    this.edit.emit(produto);
  }

  onDelete(produto: Produtos){
    this.remove.emit(produto);
  }
}
