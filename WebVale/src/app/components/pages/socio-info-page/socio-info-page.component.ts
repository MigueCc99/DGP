import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Socio } from 'src/app/models/Socio';
import { SociosService } from 'src/app/services/socios.service';

@Component({
  selector: 'app-socio-info-page',
  templateUrl: './socio-info-page.component.html',
  styleUrls: ['./socio-info-page.component.css']
})
export class SocioInfoPageComponent implements OnInit {

  socio : any = new Socio();

  constructor(private sociosService: SociosService, private router: Router, private activeRoute : ActivatedRoute) { }

  ngOnInit(): void {
    const {id} = this.activeRoute.snapshot.params;
   this.sociosService.getSocio(id)
    .subscribe(
      res => {
        this.socio = res;
      }
    );
  }

}
