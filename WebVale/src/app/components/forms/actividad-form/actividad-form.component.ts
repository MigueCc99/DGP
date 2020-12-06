import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Actividad } from 'src/app/models/Actividad';
import { ActividadesService } from 'src/app/services/actividades.service';


@Component({
  selector: 'app-actividad-form',
  templateUrl: './actividad-form.component.html',
  styleUrls: ['./actividad-form.component.css'],
})
export class ActividadFormComponent implements OnInit {
  
  actividad : any = {
    id: 0,
    nombre: '',
    descripcion: '',
    imagen: '',
    multimedia: ''
  }
  
  edit : Boolean = false;

  constructor(private actividadesService: ActividadesService, private router: Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    const {id} = this.activeRoute.snapshot.params;

    if (id != undefined)
      this.actividadesService.getActividad(id).subscribe(
        res =>{ 
          console.log(res);
          this.edit = true;
          this.actividad = res;
        },
        err => {
          console.error(err);
        })
    else 
      this.edit = false;
  }

  updateActividad() {
    this.actividadesService.updateActividad(this.actividad.id!, this.actividad)
      .subscribe(
        res => {
          console.log(res);
          this.router.navigate(['/actividades']);
        }
      )
  }

  saveNewActividad() {
    delete this.actividad.id;

    this.actividadesService.saveActividad(this.actividad)
      .subscribe(
        res => {
          console.log(this.actividad)
          console.log(res);
          this.router.navigate(['/actividades']);
        },
        err => console.log(err)
      );
  }
}



