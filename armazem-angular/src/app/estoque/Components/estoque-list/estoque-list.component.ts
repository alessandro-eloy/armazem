import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { Estoque } from '../../model/estoque';

@Component({
  selector: 'app-estoque-list',
  templateUrl: './estoque-list.component.html',
  styleUrls: ['./estoque-list.component.css']
})
export class EstoqueListComponent implements OnInit {
  @Input() estoques: Estoque[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);

  readonly displayedColumns = ['codigoProduto', 'loginUsuario', 'dataSaida']

  constructor(

  ) { }

  ngOnInit() {
  }
  onAdd(){
    this.add.emit(true);
  }

  onEdit(estoque: Estoque){
    this.edit.emit(estoque);
 }

  }
