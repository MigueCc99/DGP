import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class FacilitadoresService {

  API_URI = 'http://localhost:3000/api/vale/facilitadores';

  constructor(private http: HttpClient) {}

  getFacilitadores() {
    return this.http.get(`${this.API_URI}/`);
  }

  getFacilitador(correo: string){
    return this.http.get(`${this.API_URI}/${correo}`);
  }

  cambiarDatos(correo: string, tlfCambiado: any) {
    console.log(correo);
    return this.http.put(`${this.API_URI}/${correo}`,{"telefono" :[tlfCambiado]}); 
  }

  getNuevaPsw(correo: string, psw: any){
    return this.http.put(`${this.API_URI}/${correo}`, { "contrasena": [psw] }); 

  }
  
  }

