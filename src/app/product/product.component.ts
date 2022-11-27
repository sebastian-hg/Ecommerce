import { Component, inject, OnInit } from '@angular/core';
import { Route, Router, RouterLinkActive } from '@angular/router';
import { Product } from '../models/article';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  articulos: Array<Product> = new Array<Product>();

  constructor(private ruta : Router) { }

  ngOnInit(): void {
    this.articulos.push(
      {name:"Hamburguesa", description:"doble carne y bacon",price:2000},
      {name:"Gaseosa", description:"Grande ",price:500},
      {name:"Papas Fritas", description:"Medianas",price:4000}
    )
  }

  passParameter(productRecieved:Product){
     this.ruta.navigate(['productosDetalle', {product: JSON.stringify(productRecieved)}]);
  }

}
