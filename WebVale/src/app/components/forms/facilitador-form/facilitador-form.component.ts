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

   cambiarDatos(tlf: any) {
    console.log(tlf)
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
  
}


