import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actividad } from 'src/app/models/Actividad';
import { ActividadesService } from 'src/app/services/actividades.service';
import { SociosService } from 'src/app/services/socios.service';
import {Solucion} from '../../../models/Solucion';

@Component({
  selector: 'app-socio-actividad-page',
  templateUrl: './socio-actividad-page.component.html',
  styleUrls: ['./socio-actividad-page.component.css']
})
export class SocioActividadPageComponent implements OnInit {

  solucion : Solucion = new Solucion();
  actividad : Actividad = new Actividad();

  constructor(private actividadesService : ActividadesService, private sociosService : SociosService, private router: Router, private activeRoute : ActivatedRoute) {
   }

  ngOnInit(): void {
    this.Actualizar();
  }

  Actualizar() : void {
    let params = this.activeRoute.snapshot.params;
    let {idSocio} = params;
    let {idActividad} = params;

    // Obtener actividad
    this.actividadesService.getActividad(idActividad)
    .subscribe(
      res => {
        this.actividad = res as Actividad;
      },
      err => console.error(err)
    );

    // Obtener solucion
    this.sociosService.getActividadSocio(idSocio, idActividad)
    .subscribe(
      res => {
        this.solucion = res as Solucion;
      },
      err => console.error(err)
    );
  }

}
