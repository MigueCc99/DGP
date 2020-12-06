import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actividad } from '../models/Actividad';

@Injectable({
  providedIn: 'root'
})
export class ActividadesService {

  API_URI = 'http://localhost:3000/api/vale/actividades';

  constructor(private http: HttpClient) {}

  getActividades(){
    return this.http.get(`${this.API_URI}/`)
  }
  getActividad(id : number){
    return this.http.get(`${this.API_URI}/${id}`)
  }

  deleteActividad(id: any){
    return this.http.delete(`${this.API_URI}/${id}`);
  }
  saveActividad(Actividad: Actividad) {
    return this.http.post(`${this.API_URI}`, {"nombre": Actividad.nombre, "descripcion": Actividad.descripcion, "imagen": Actividad.imagen});
  }

  updateActividad(id: string | number, updatedActividad: Actividad){
    return this.http.put(`${this.API_URI}/${id}`, updatedActividad);
  }
}
