import { Component, OnInit } from '@angular/core';

import { FacilitadoresService } from '../../../services/facilitadores.service';
import { Facilitador } from '../../../models/Facilitador'

import { ConstantsComponent } from '../../constants/constants.component'


@Component({
  selector: 'app-perfil-page',
  templateUrl: './perfil-page.component.html',
  styleUrls: ['./perfil-page.component.css']
})
export class PerfilPageComponent implements OnInit {

  correo: string = ConstantsComponent.usuarioactual;


  constructor(private facilitadoresService: FacilitadoresService, ) { }

  ngOnInit(): void {
       this.facilitadoresService.getFacilitador(this.correo).subscribe(
        res => console.log(res),
        err => console.log(err)
      );
    }
    
  }
