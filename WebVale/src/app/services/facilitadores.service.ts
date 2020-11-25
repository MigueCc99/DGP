import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FacilitadoresService {

  API_URI = 'http://localhost:3000/api/vale/facilitadores';

  constructor(private http: HttpClient) {}

  getObjetivos() {
    return this.http.get(`${this.API_URI}/`)
  }
}
