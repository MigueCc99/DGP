import { Component, OnInit } from '@angular/core';
import { Objetivo } from '../../../models/Objetivo'

@Component({
  selector: 'app-objetivos-page',
  templateUrl: './objetivos-page.component.html',
  styleUrls: ['./objetivos-page.component.css']
})
export class ObjetivosPageComponent implements OnInit {

  //Listado
  listadoObjetivos : Objetivo[];
  listadoObjetivosFiltrado : Objetivo[];
  filtro : string = '';


  constructor() {
    this.listadoObjetivos = [
      {
        id: 1,
        nombre: "Lavarse la cara",
        descripcion: "Hacer algo",
        imagen: "guapa"
      },
      {
        id: 2,
        nombre: "Lavarse la tienda",
        descripcion: "Hacer algo",
        imagen: "guapa"
      },
      
    ];
    this.listadoObjetivosFiltrado = this.listadoObjetivos;
   }

  ngOnInit(): void {
  }

  filtrarObjetivos (){
    this.listadoObjetivosFiltrado = this.listadoObjetivos.filter(
      objetivo => 
      objetivo.nombre.toLowerCase().includes(this.filtro.toLowerCase())
    )
  }
}
