import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Estoque } from '../../estoque/model/estoque';
import { HomeService } from '../service/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']

})
export class HomeComponent implements OnInit {


  @Input() estoque:Estoque[] = []
  @Output() buscar = new EventEmitter(false);

  constructor(private homeService: HomeService ){}

  ngOnInit(): void {

  }

  onBuscar(estoque: Estoque){
    this.homeService.findByCod(estoque.idProduto);
  }
}
