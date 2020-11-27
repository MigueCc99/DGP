import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { ValeService } from 'src/app/services/vale.service';
import { ConstantsComponent } from '../../constants/constants.component'

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {

  constructor(private user: LoginService, private router: Router, private vale: ValeService) {}

  mail: any;
  prueba: any;

  logIn(correo: any, pass: any) {
    this.user.correo = correo;
    if(correo==''){
      confirm("Faltan parámetros");
    }
    if(pass==''){
      confirm("Faltan parámetros");
    }

    this.vale.getLogIn(correo, pass).subscribe(
      res => {
        if(res!=0){
          this.mail=correo;
          this.prueba=res;
          ConstantsComponent.usuarioactual=this.mail;
          ConstantsComponent.centro=this.prueba.centro;
          this.router.navigate(['/perfil']);
        }else{
          confirm("Error en login");
        }
      },
      err => {
        console.error(err)
      }
    )
  }
}
