import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {
  imagen:string= 'https://static.vecteezy.com/system/resources/previews/002/711/857/original/detective-holding-a-magnifying-glass-behind-404-text-error-404-page-not-found-system-maintenance-vector.jpg';
  constructor() { }

  ngOnInit(): void {
  }

}
