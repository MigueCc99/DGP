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

  constructor(private facilitadoresService: FacilitadoresService) {
    }

  ngOnInit(): void {
    this.getFacilitadores();

  }

  eliminar(correo: string): void {
    //console.log(correo);
    this.facilitadoresService.eliminarFacilitador(correo)
      .subscribe(
        res => {
         console.log(res);
          setTimeout(() => {
            this.getFacilitadores()
          }, 100
          )
        },
        err => console.error(err)
      );

  }
  
   getFacilitadores() {
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
