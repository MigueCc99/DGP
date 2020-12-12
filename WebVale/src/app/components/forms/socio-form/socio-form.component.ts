import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { SociosService } from '../../../services/socios.service';


@Component({
  selector: 'app-socio-form',
  templateUrl: './socio-form.component.html',
  styleUrls: ['./socio-form.component.css']
})
export class SocioFormComponent implements OnInit {

  constructor(private sociosService: SociosService, private router: Router) { }

  ngOnInit(): void {
  }

  formatoFecha(fecha: any) {
    return fecha.replace(/^(\d{4})-(\d{2})-(\d{2})$/g, '$3/$2/$1');
  }

  nuevoSocio(nombre: string, apellidos: string, fN: any){

    var fecha = this.formatoFecha(fN);
    
    console.log(nombre);
    this.sociosService.crearSocio(nombre, apellidos, fecha).subscribe(
      res => {
        this.router.navigate(['/centro']);
      },
      err => {
        console.error(err)
      })



  }

}
