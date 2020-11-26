import { Component, OnInit } from '@angular/core';
import { Socio } from 'src/app/models/Socio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-socios-page',
  templateUrl: './socios-page.component.html',
  styleUrls: ['./socios-page.component.css']
})
export class SociosPageComponent implements OnInit {
  //Listado
  listadoSocios : Socio[];
  listadoSociosFiltrado : Socio[];
  filtro : string = '';


  constructor( private router: Router) {
    this.listadoSocios = [
      {
        id: 1,
        nombre: "Cayetana",
        apellidos: "Alvarez"
      },
      
    ];
    this.listadoSociosFiltrado = this.listadoSocios;
   }

  ngOnInit(): void {
  }

  filtrarListado (){
    this.listadoSociosFiltrado = this.listadoSocios.filter(
      socio => 
      (socio.nombre + " " + socio.apellidos).toLowerCase().includes(this.filtro.toLowerCase()) 
    )
  }

  navegaVer (id : number | string) {
    this.router.navigate(['/socios/ver/' + id]);
  }
}
