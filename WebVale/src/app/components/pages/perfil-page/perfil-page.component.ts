import { Component, OnInit } from '@angular/core';

import { FacilitadoresService } from '../../../services/facilitadores.service';
import { Facilitador } from '../../../models/Facilitador'

import { ConstantsComponent } from '../../constants/constants.component'
import { __values } from 'tslib';


@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {

  facilitador: any = {};
  correo: string = ConstantsComponent.usuarioactual;

  constructor(private facilitadoresService: FacilitadoresService) { }

  ngOnInit(): void {
       this.facilitadoresService.getFacilitador(this.correo).subscribe(
        res => { 
          this.facilitador = res
           console.log(this.facilitador);
        },
        err => console.log(err)
      );
    }
    
  }
