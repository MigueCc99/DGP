import { Component, OnInit } from '@angular/core';

import { FacilitadoresService } from '../../../services/facilitadores.service';
import { Facilitador } from '../../../models/Facilitador';

import { ConstantsComponent } from '../../constants/constants.component'
import { __values } from 'tslib';


@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {

  //facilitador: any = {};

  correo: string = ConstantsComponent.usuarioactual;

  constructor(private facilitadoresService: FacilitadoresService) { }

  facilitador: Facilitador = new Facilitador();
  facilitador2: Facilitador = new Facilitador();

  ngOnInit(): void {
    this.facilitadoresService.getFacilitador(this.correo).subscribe(
    res => { 
      this.facilitador2 = <Facilitador>res;
      this.facilitador.nombre = this.facilitador2.nombre;
      this.facilitador.apellidos = this.facilitador2.apellidos;
      this.facilitador.contrasena = this.facilitador2.contrasena;
      this.facilitador.centro = this.facilitador2.centro;
      this.facilitador.correo = this.facilitador2.correo;
      this.facilitador.telefono = this.facilitador2.telefono;
      this.facilitador.nacimiento = this.facilitador2.nacimiento;
    },
    err => console.log(err)
    );
    }
    
  }
