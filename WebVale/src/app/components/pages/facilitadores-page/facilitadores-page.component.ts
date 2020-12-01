import { Component, OnInit } from '@angular/core';
import { Facilitador } from 'src/app/models/Facilitador';
import { FacilitadoresService} from 'src/app/services/facilitadores.service'

@Component({
  selector: 'app-facilitadores-page',
  templateUrl: './facilitadores-page.component.html',
  styleUrls: ['./facilitadores-page.component.css']
})
export class FacilitadoresPageComponent implements OnInit {

  //Listado
  listadoFacilitadores : Facilitador[] = [];
  listadoFacilitadoresFiltrado : Facilitador[] = [];
  filtro : string = '';

  constructor(private facilitadoresService :  FacilitadoresService) {
    }

  ngOnInit(): void {
    this.getObjetivos();
  }
  
   getObjetivos() {
    this.facilitadoresService.getFacilitadores().subscribe(
      res => {
        this.listadoFacilitadores = this.listadoFacilitadoresFiltrado = res as Facilitador[];
      },
      err => console.error(err)
    );
   }

  filtrarListado (){
    this.listadoFacilitadoresFiltrado = this.listadoFacilitadores.filter(
      facilitador => 
      facilitador.nombre.toLowerCase().includes(this.filtro.toLowerCase())
    )
  }

}
