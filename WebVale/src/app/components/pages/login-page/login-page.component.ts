import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';
import { ValeService } from 'src/app/services/vale.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent {

  u: any;

  constructor(private user: LoginService, private router: Router, private vale: ValeService) {}

  logIn(uname: any, pass: any) {
    this.user.username = uname;
    if(uname==''){
      confirm("Faltan parámetros");
    }
    if(pass==''){
      confirm("Faltan parámetros");
    }

    this.vale.getLogIn(uname, pass).subscribe(
      res => {
        if(res==1){
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
