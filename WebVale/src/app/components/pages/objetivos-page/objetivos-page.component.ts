import { Component, OnInit } from '@angular/core';
import { ObjetivosService } from 'src/app/services/objetivos.service';
import { Objetivo } from '../../../models/Objetivo'

@Component({
  selector: 'app-objetivos-page',
  templateUrl: './objetivos-page.component.html',
  styleUrls: ['./objetivos-page.component.css']
})
export class ObjetivosPageComponent implements OnInit {

  //Listado
  listadoObjetivos : Objetivo[] = [];
  listadoObjetivosFiltrado : Objetivo[] = [];
  filtro : string = '';


  constructor(private objetivosService : ObjetivosService) {
   }

   ngOnInit(): void {
    this.getObjetivos();
  }
  
   getObjetivos() {
    this.objetivosService.getObjetivos().subscribe(
      res => {
        this.listadoObjetivos = this.listadoObjetivosFiltrado = res as Objetivo[];
      },
      err => console.error(err)
    );
   }

  filtrarListado (){
    this.listadoObjetivosFiltrado = this.listadoObjetivos.filter(
      objetivo => 
      objetivo.nombre.toLowerCase().includes(this.filtro.toLowerCase())
    )
  }
}
