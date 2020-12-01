import { Component, OnInit } from '@angular/core';
import { Socio } from 'src/app/models/Socio';
import { SociosService} from 'src/app/services/socios.service'

@Component({
  selector: 'app-socios-recupera-contra-page',
  templateUrl: './socios-recupera-contra-page.component.html',
  styleUrls: ['./socios-recupera-contra-page.component.css']
})
export class SociosRecuperaContraPageComponent implements OnInit {

   //Listado
   listadoSocios : Socio[] = [];
   listadoSociosFiltrado : Socio[] = [];
   filtro : string = '';
 
   constructor(private sociosService :  SociosService) {
     }
 
   ngOnInit(): void {
     this.getSocios();
   }
   
    getSocios() {
     this.sociosService.getSocios().subscribe(
       res => {
         this.listadoSocios = this.listadoSociosFiltrado = res as Socio[];
       },
       err => console.error(err)
     );
    }
 
   filtrarListado (){
     this.listadoSociosFiltrado = this.listadoSocios.filter(
       socio => 
       socio.nombre.toLowerCase().includes(this.filtro.toLowerCase())
     )
   }

   mostrarContrasena(contra: string) : string {
     return "hey"
   }
}


 