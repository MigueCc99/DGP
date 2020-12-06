import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Objetivo } from '../models/Objetivo';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ObjetivosService {

  API_URI = 'http://localhost:3000/api/vale/objetivos';

  constructor(private http: HttpClient) {}

  getObjetivos(){
    return this.http.get(`${this.API_URI}/`)
  }
  getObjetivo(id : number){
    return this.http.get(`${this.API_URI}/${id}`)
  }

  deleteObjetivo(id: any){
    return this.http.delete(`${this.API_URI}/${id}`);
  }
  saveObjetivo(objetivo: Objetivo) {
    return this.http.post(`${this.API_URI}`, {"nombre": objetivo.nombre, "descripcion": objetivo.descripcion, "imagen": objetivo.imagen});
  }

  updateObjetivo(id: string | number, updatedObjetivo: Objetivo){
    return this.http.put(`${this.API_URI}/${id}`, updatedObjetivo);
  }

}
