import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actividad } from 'src/app/models/Actividad';
import { Objetivo } from 'src/app/models/Objetivo';
import { Socio } from 'src/app/models/Socio';
import { SociosService } from 'src/app/services/socios.service';

@Component({
  selector: 'app-socio-info-page',
  templateUrl: './socio-info-page.component.html',
  styleUrls: ['./socio-info-page.component.css']
})
export class SocioInfoPageComponent implements OnInit {

  socio : any = new Socio();
  listadoActividades : Actividad[] = [];
  listadoObjetivos : Objetivo[] = [];
  id : number;

  constructor(private sociosService: SociosService, private router: Router, private activeRoute : ActivatedRoute) { 
    this.id = this.activeRoute.snapshot.params.id;
  }

  ngOnInit(): void {
   
   this.sociosService.getSocio(this.id)
    .subscribe(
      res => {
        this.socio = res;
      }
    );

    this.getActividades();
    this.getObjetivos();
  }

  getActividades() {
    this.sociosService.getActividadesSocio(this.id).subscribe(
      res => {
        this.listadoActividades = res as Actividad[];
      },
      err => console.error(err)
    );
   }

   getObjetivos() {
    this.sociosService.getObjetivosSocio(this.id).subscribe(
      res => {
        this.listadoObjetivos = res as Objetivo[];
      },
      err => console.error(err)
    );
   }

}
