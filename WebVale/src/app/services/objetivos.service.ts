import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ObjetivosService {

  API_URI = 'http://localhost:3000/api/vale/objetivos';

  constructor(private http: HttpClient) {}

  getObjetivos(){
    return this.http.get(`${this.API_URI}/`)
  }
}
