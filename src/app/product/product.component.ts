import { Component, OnInit } from '@angular/core';

interface Product{
  name :string,
  description:string,
  price:number

}
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  articulos: Array<Product> = new Array<Product>();

  constructor() { }

  ngOnInit(): void {
    this.articulos.push(
      {name:"Hamburguesa", description:"doble carne y bacon",price:2000},
      {name:"Gaseosa", description:"Grande ",price:500},
      {name:"Papas Fritas", description:"Medianas",price:4000}
    )
  }

}
