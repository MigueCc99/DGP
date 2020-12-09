import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { FacilitadoresService } from '../../../services/facilitadores.service';

@Component({
  selector: 'app-facilitador-form',
  templateUrl: './facilitador-form.component.html',
  styleUrls: ['./facilitador-form.component.css']
})
export class FacilitadorFormComponent implements OnInit {

  constructor(private facilitadoresService: FacilitadoresService, 
    private router: Router, private activatedRoute: ActivatedRoute ) { }

  ngOnInit(): void {}
    /*const params = this.activatedRoute.snapshot.params;
    if(params.correo){
      this.facilitadoresService.getFacilitador(params.correo)
      .subscribe(
        res => {
          console.log(res);
        },
        err => console.error(err)
      )
    }*/

    formatoFecha(fecha:any) {
    return fecha.replace(/^(\d{4})-(\d{2})-(\d{2})$/g, '$3/$2/$1');
}

   cambiarDatos(tlf: any) {
    if (tlf == '') {
      confirm("Faltan parámetros");
    } 

    const params = this.activatedRoute.snapshot.params;
    const correo = params.correo;
    console.log(correo);

    this.facilitadoresService.cambiarDatos(correo,tlf).subscribe(
      res =>{ console.log(res);
      this.router.navigate(['/perfil']);
      },
       err => {
        console.error(err)
      })
      
  }

  nuevoFacilitador(nombre: string, apellidos: string, fN: any, correo: string, tlf: any ){

    var fecha = this.formatoFecha(fN);
    
    this.facilitadoresService.crearFacilitador(nombre,apellidos,fecha,correo,tlf).subscribe(
      res => {
        this.router.navigate(['/centro']);
      },
      err => {
        console.error(err)
      })

  }
  
}


