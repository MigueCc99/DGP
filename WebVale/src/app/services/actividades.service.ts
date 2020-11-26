import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ActividadesService {

  API_URI = 'http://localhost:3000/api/vale/actividades';

  constructor(private http: HttpClient) {}

  getActividades(){
    return this.http.get(`${this.API_URI}/`)
  }
}
