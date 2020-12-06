import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Objetivo } from 'src/app/models/Objetivo';
import { ObjetivosService } from 'src/app/services/objetivos.service';

@Component({
  selector: 'app-objetivo-form',
  templateUrl: './objetivo-form.component.html',
  styleUrls: ['./objetivo-form.component.css']
})
export class ObjetivoFormComponent implements OnInit {

  objetivo : any = {
    id: 0,
    nombre: '',
    descripcion: '',
    imagen: '',
    toggle: false
  }
  edit : Boolean = false;

  constructor(private objetivosService: ObjetivosService, private router: Router, private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {

    const {id} = this.activeRoute.snapshot.params;

    if (id != undefined)
      this.objetivosService.getObjetivo(id).subscribe(
        res =>{ 
          console.log(res);
          this.edit = true;
          this.objetivo = res;
        },
        err => {
          console.error(err);
        })
    else 
      this.edit = false;
  }

  updateObjetivo() {
    this.objetivosService.updateObjetivo(this.objetivo.id!, this.objetivo)
      .subscribe(
        res => {
          console.log(res);
          this.router.navigate(['/objetivos']);
        }
      )
  }

  saveNewObjetivo() {
    delete this.objetivo.id;

    this.objetivosService.saveObjetivo(this.objetivo)
      .subscribe(
        res => {
          console.log(this.objetivo)
          console.log(res);
          this.router.navigate(['/objetivos']);
        },
        err => console.log(err)
      );
  }
    
  }


