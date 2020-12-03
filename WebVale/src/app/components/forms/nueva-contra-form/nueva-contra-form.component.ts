import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { FacilitadoresService } from '../../../services/facilitadores.service';

@Component({
  selector: 'app-nueva-contra-form',
  templateUrl: './nueva-contra-form.component.html',
  styleUrls: ['./nueva-contra-form.component.css']
})
export class NuevaContraFormComponent implements OnInit {

  constructor(private facilitadoresService: FacilitadoresService,
    private router: Router, private activatedRoute: ActivatedRoute ) { }

  ngOnInit(): void {
  }

  cambiarPsw(psw1: any, psw2: any){

    const params = this.activatedRoute.snapshot.params;
    const correo = params.correo;

    if (psw1.length == 0 || psw2.length == 0) {
      alert("Los campos de las contraseñas no deben quedar vacíos");

    } else if (psw1 != psw2) {
      alert("Las contraseñas deben de coincidir");

    }else{
      alert("Todo está correcto");

      this.facilitadoresService.getNuevaPsw(correo, psw1).subscribe(
        res => {
          console.log(res);
          this.router.navigate(['/perfil']);
        },
        err => {
          console.error(err)
        })
    }
  }
}
