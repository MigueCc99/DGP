import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SociosService {
  API_URI = 'http://localhost:3000/api/vale/socios';

  constructor(private http: HttpClient) {}

  getSocios(){
    return this.http.get(`${this.API_URI}/`)
  }

  getSocio(id : number){
    return this.http.get(`${this.API_URI}/${id}`)
  }

  getActividadesSocio(id : number){
    return this.http.get(`${this.API_URI}/${id}/actividades`)
  }
  getActividadesNoAceptadasSocio(id : number){
    return this.http.get(`${this.API_URI}/${id}/actividades/no-aceptadas`)
  }
  getActividadesNoEntregadasSocio(id : number){
    return this.http.get(`${this.API_URI}/${id}/actividades/no-entregadas`)
  }

  getObjetivosSocio(id : number){
    return this.http.get(`${this.API_URI}/${id}/objetivos`)
  }
}
