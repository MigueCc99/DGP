import { Component, OnInit } from '@angular/core';
import { Actividad } from 'src/app/models/Actividad';

@Component({
  selector: 'app-actividades-page',
  templateUrl: './actividades-page.component.html',
  styleUrls: ['./actividades-page.component.css']
})
export class ActividadesPageComponent implements OnInit {

  //Listado
  listadoActividades : Actividad[];
  listadoActividadesFiltrado : Actividad[];
  filtro : string = '';


  constructor() {
    this.listadoActividades = [
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
      },  {
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
      },  {
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
      },  {
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
      },  {
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
      },  {
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
      },  {
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
      },  {
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
      },  {
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
    this.listadoActividadesFiltrado = this.listadoActividades;
   }

  ngOnInit(): void {
  }

  filtrarListado (){
    this.listadoActividadesFiltrado = this.listadoActividades.filter(
      actividad => 
      actividad.nombre.toLowerCase().includes(this.filtro.toLowerCase())
    )
  }
}
