import { Component, OnInit } from '@angular/core';
import { ConstantsComponent } from '../../components/constants/constants.component';

@Component({
  selector: 'app-nav-menu',
  templateUrl: './nav-menu.component.html',
  styleUrls: ['./nav-menu.component.css']
})
export class NavMenuComponent implements OnInit {

  constructor() { }

  centro: boolean = ConstantsComponent.centro;

  ngOnInit(): void {
  }

  isCentro() {
    return !this.centro;
  }

}
