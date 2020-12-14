import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Solucion } from '../models/Solucion';

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
  
  getActividadSocio(idSocio: number, idActividad : number )
  {
    return this.http.get(`${this.API_URI}/${idSocio}/actividades/solucion/${idActividad}`)
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

  addActividadUsuario(id : number, idact : number){
    return this.http.put(`${this.API_URI}/${id}/objetivos/add/${idact}`, {})
  }

  getActividadesNoAsignadasSocio(id : number){
    return this.http.get(`${this.API_URI}/${id}/actividades/no-asignadas`)
  }

  actualizaSolucion (id : number, actividad : number, solucion : Solucion)
  {
    console.log(solucion)
    let a_repetir = (solucion.a_repetir == true)? 1 : 0;
    let aceptada = (solucion.aceptada == true)? 1 : 0;
    return this.http.put(`${this.API_URI}/${id}/actividades/solucion/${actividad}`, { "a_repetir": [a_repetir], 
                                                                                      "aceptada": [aceptada]});
  }

  crearSocio(nombre: string, apellidos: string, fN: string) {
    
    return this.http.post(`${this.API_URI}/`, {
      "nombre": [nombre],
      "apellidos": [apellidos],
      "nacimiento": [fN],
      "contrasena": "",
    });
  }

  eliminarSocio(id: any){
    return this.http.delete(`${this.API_URI}/${id}`);
  }
}
