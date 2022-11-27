import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  logo:string = 'https://d1fdloi71mui9q.cloudfront.net/hJSSjqSrTiOrEtMHnwOc_ICbBoIGSrhBm76hU';

  constructor() { }

  ngOnInit(): void {
  }

}
