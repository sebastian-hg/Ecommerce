import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from '../models/article';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {

  product!: Product;
  ;
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {

    this.product = JSON.parse(this.route.snapshot.params['product']);
    console.log(this.product) 
  } 

}
