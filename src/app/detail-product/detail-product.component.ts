import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-detail-product',
  templateUrl: './detail-product.component.html',
  styleUrls: ['./detail-product.component.css']
})
export class DetailProductComponent implements OnInit {

  nameProduct:string = "";
  priceProduct:any;
;
  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.nameProduct = this.route.snapshot.params['nombre'];
    this.priceProduct = this.route.snapshot.params['precio'];
  }

}
