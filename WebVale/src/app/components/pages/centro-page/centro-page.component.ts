import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-centro-page',
  templateUrl: './centro-page.component.html',
  styleUrls: ['./centro-page.component.css']
})
export class CentroPageComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  navegaRecuperarContraFacilitador () {
    this.router.navigate(['/centro/recuperar-contra/facilitadores']);
  }

  navegaRecuperarContraSocio () {
    this.router.navigate(['/centro/recuperar-contra/socios']);
  }

}
