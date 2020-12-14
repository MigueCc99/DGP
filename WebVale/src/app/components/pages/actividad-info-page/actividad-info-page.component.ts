import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Location} from '@angular/common';
import * as am4core from "@amcharts/amcharts4/core";
import * as am4charts from "@amcharts/amcharts4/charts";

import { Actividad } from 'src/app/models/Actividad';
import { ActividadesService } from 'src/app/services/actividades.service';
import { SociosService } from 'src/app/services/socios.service';
import {Solucion} from '../../../models/Solucion';
import { Feedback } from 'src/app/models/Feedback';

@Component({
  selector: 'app-actividad-info-page',
  templateUrl: './actividad-info-page.component.html',
  styleUrls: ['./actividad-info-page.component.css']
})
export class ActividadInfoPageComponent implements OnInit {

  actividad : Actividad = new Actividad();
  idActividad : number = 0;
  feedback : Feedback = new Feedback();
  


  constructor(private actividadesService : ActividadesService, private _location: Location, private activeRoute : ActivatedRoute) {
   }

  ngOnInit(): void {
    this.Actualizar();
  }

  async Actualizar() : Promise<void> {
    let params = this.activeRoute.snapshot.params;
    this.idActividad = params.id;

    // Create chart instance
    let chart = am4core.create("chartdiv", am4charts.PieChart);

    // Obtener actividad
    this.actividadesService.getActividad(this.idActividad)
    .subscribe(
      res => {
        this.actividad = res as Actividad;
      },
      err => console.error(err)
    );

    // Obtener feedback
    this.actividadesService.getFeedback(this.idActividad)
    .subscribe(
      res => {
        this.feedback = res as Feedback;

        // Add data
        chart.data = [{
          "feedback": "Útil",
          "votos": this.feedback.utiles
        }, {
          "feedback": "Difícil",
          "votos": this.feedback.dificiles
        }, {
          "feedback": "Ha gustado",
          "votos": this.feedback.gustados
        }];
      },
      err => console.error(err)
    );

    // Add and configure Series
    let pieSeries = chart.series.push(new am4charts.PieSeries());
    pieSeries.dataFields.value = "votos";
    pieSeries.dataFields.category = "feedback";
  }

  showFeedback() : boolean{
    return this.feedback.votos>0;
  }

}
