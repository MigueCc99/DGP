import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actividad } from 'src/app/models/Actividad';
import { Objetivo } from 'src/app/models/Objetivo';
import { Socio } from 'src/app/models/Socio';
import { SociosService } from 'src/app/services/socios.service';

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-socio-info-page',
  templateUrl: './socio-info-page.component.html',
  styleUrls: ['./socio-info-page.component.css']
})

export class SocioInfoPageComponent implements OnInit {

  selectedValue: any;
  actividad: any;
  socio : any = new Socio();
  listadoActividadesNoAsignadas : Actividad[] = [];
  listadoActividadesNoAceptadas : Actividad[] = [];
  listadoActividadesNoEntregadas : Actividad[] = [];
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
    this.getActividadesNoAsignadas(this.id);
  }

  getActividades() {
    this.sociosService.getActividadesNoAceptadasSocio(this.id).subscribe(
      res => {
        this.listadoActividadesNoAceptadas = res as Actividad[];
      },
      err => console.error(err)
    );
    this.sociosService.getActividadesNoEntregadasSocio(this.id).subscribe(
      res => {
        this.listadoActividadesNoEntregadas = res as Actividad[];
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

   getActividadesNoAsignadas(id : number) {
    this.sociosService.getActividadesNoAsignadasSocio(id).subscribe(
      res => {
        this.listadoActividadesNoAsignadas = res as Actividad[];
        //console.log(this.listadoActividadesNoAsignadas)
      },
      err => console.error(err)
    );
   }

   navegaVerActividad(idActividad : number){
    this.router.navigate(['/socios/ver/actividad/' + this.id + '/' + idActividad]);
   }

   Anadir(idact: number){
    this.sociosService.addActividadUsuario(this.id, idact).subscribe(
      res => {
        console.log(res)
      },
      err => console.error(err)
    );
    window.location.href = this.router.url;
     return true;
   }

}
