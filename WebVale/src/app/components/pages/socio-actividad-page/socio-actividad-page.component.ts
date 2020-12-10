import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
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
  idSocio : number = 0;
  idActividad : number = 0;

  constructor(private actividadesService : ActividadesService, private sociosService : SociosService, private _location: Location, private activeRoute : ActivatedRoute) {
   }

  ngOnInit(): void {
    this.Actualizar();
  }

  Actualizar() : void {
    let params = this.activeRoute.snapshot.params;
    this.idSocio = params.idSocio;
    this.idActividad = params.idActividad;

    // Obtener actividad
    this.actividadesService.getActividad(this.idActividad)
    .subscribe(
      res => {
        this.actividad = res as Actividad;
      },
      err => console.error(err)
    );

    // Obtener solucion
    this.sociosService.getActividadSocio(this.idSocio, this.idActividad)
    .subscribe(
      res => {
        this.solucion = res as Solucion;
      },
      err => console.error(err)
    );
  }

  aceptarSolucion() : void {
    this.solucion.aceptada = true;
    this.solucion.a_repetir= false;
    this.sociosService.actualizaSolucion(this.idSocio, this.idActividad, this.solucion)
    .subscribe(
      res => {
        console.log(res)
      },
      err => console.error(err)
    );
    setTimeout(() => {
      this._location.back()}, 500);
  }

  rechazarSolucion() : void {
    this.solucion.a_repetir = true;
    this.solucion.aceptada = false;
    this.sociosService.actualizaSolucion(this.idSocio, this.idActividad, this.solucion)
    .subscribe(
      res => {
        console.log(res)
      },
      err => console.error(err)
    );
    this._location.back();
  }

}
