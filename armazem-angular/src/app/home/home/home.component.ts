import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomeService } from '../service/home.service';
import { NonNullableFormBuilder } from '@angular/forms';
import { Estoque } from 'src/app/estoque/model/estoque';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']

})
export class HomeComponent implements OnInit {

  form = this.formBuilder.group({
    produto: [""],
    usuario: [""]
  });

  constructor(
    private homeService: HomeService,
    private route: ActivatedRoute,
    private formBuilder: NonNullableFormBuilder
    )
    {}

  ngOnInit(): void {
    const estoque: Estoque = this.route.snapshot.data['estoque'];
    this.form.setValue({
      produto: estoque.produto,
      usuario: estoque.usuario
     });
  }

  onAdd(): void{
    this.homeService.save(this.form.value);
  }
}
