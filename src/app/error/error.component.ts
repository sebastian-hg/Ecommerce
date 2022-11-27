import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  imagen:string= 'https://www.seoptimer.com/es/blog/wp-content/uploads/2015/07/Destacada.jpg';
  constructor() { }

  ngOnInit(): void {
  }

}
