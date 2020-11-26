import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Actividad } from 'src/app/models/Actividad';
import { ActividadesService } from 'src/app/services/actividades.service';

@Component({
  selector: 'app-actividades-page',
  templateUrl: './actividades-page.component.html',
  styleUrls: ['./actividades-page.component.css']
})
export class ActividadesPageComponent implements OnInit {

  //Listado
  listadoActividades : Actividad[] = [];
  listadoActividadesFiltrado : Actividad[] = [];
  filtro : string = '';


  constructor(private actividadesService : ActividadesService, private router: Router) {
   }

  ngOnInit(): void {
    this.getActividades();
  }

  getActividades() {
    this.actividadesService.getActividades().subscribe(
      res => {
        this.listadoActividades = this.listadoActividadesFiltrado = res as Actividad[];
      },
      err => console.error(err)
    );
   }

  filtrarListado (){
    this.listadoActividadesFiltrado = this.listadoActividades.filter(
      actividad => 
      actividad.nombre.toLowerCase().includes(this.filtro.toLowerCase())
    )
  }

  navegaVer (id : number | string) {
    this.router.navigate(['/actividades/ver/' + id]);
  }

  navegaEditar (id : number | string) {
    this.router.navigate(['/actividades/editar/' + id]);
  }

  eliminar (id : number | string) {

  }

  crear () {
    this.router.navigate(['/actividades/crear']);
  }
}
